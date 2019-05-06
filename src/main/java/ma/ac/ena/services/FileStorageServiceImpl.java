package ma.ac.ena.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ma.ac.ena.entities.Envoie;
import ma.ac.ena.entities.User;
import ma.ac.ena.exception.FileStorageException;
import ma.ac.ena.exception.MyFileNotFoundException;
import ma.ac.ena.pogo.FileStorageProperties;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

@Service
public class FileStorageServiceImpl  implements FileStorageService{

    private final Path fileStorageLocation;
    @Autowired
    private HttpSession session ; 
    @Autowired
    private EnvoieService envoieService ; 
    
    
    
    @Autowired
    public FileStorageServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDirectory())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public Path storeFile(MultipartFile file  , String to , String dir) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename()
        		+"_"+ new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Timestamp(System.currentTimeMillis())));
        String uri = dir+"/"+( (User) session.getAttribute("user")).getUsername() + "_"+to ; 
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            	
            // Copy file to the target location (Replacing existing file with the same name)
            try {
                Files.createDirectories(this.fileStorageLocation.resolve(uri));
            } catch (Exception ex) {
                throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
            }
            
            Path targetLocation = this.fileStorageLocation.resolve(uri+"/"+fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return targetLocation;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName , String from_to) {
        try {
            Path filePath = this.fileStorageLocation.resolve("Message_Privé").resolve(from_to).resolve(fileName).normalize();
            Resource resource ; 
            Envoie envoie = envoieService.isAuth(filePath.toUri() , ( (User ) session.getAttribute("user") ).getEmployee().getId() ) ; 
            if(envoie != null) {
            	
            	resource = new UrlResource(filePath.toUri());
            	
            }else {
            
            	 resource = null ; 
            }
            
            if(resource != null ) {
            	envoieService.setLu(envoie) ; 
                return resource; 
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
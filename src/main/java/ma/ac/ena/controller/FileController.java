package ma.ac.ena.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ma.ac.ena.api.UploadFileResponse;
import ma.ac.ena.entities.Employee;
import ma.ac.ena.entities.User;
import ma.ac.ena.services.DocumentwrapperService;
import ma.ac.ena.services.FileStorageService;
import ma.ac.ena.services.FileStorageServiceImpl;
import ma.ac.ena.wrapper.Documentwrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired   
	private SimpMessageSendingOperations messagingTemplate;
    @Autowired 
    private DocumentwrapperService documentwrapperService ; 
    @Autowired
    private HttpSession session ; 
    
    
    
    @PostMapping("/uploadFile")
    public void uploadFile( @RequestParam("files") MultipartFile file
    		, String to ,  Documentwrapper documentwrapper) {
    	Employee employee = ( (User) session.getAttribute("user") ).getEmployee() ; 


        Path path = fileStorageService.storeFile(file , to , "Message_Privé");
        String fileName = path.getFileName().toString()  ;
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(employee.getUser().getUsername()+"_"+to+"/")
                .path(fileName)
                .toUriString();
        documentwrapper.getDocument().setChemin(path.toString());
        documentwrapper.getDocument().setNomFichier(fileName);
        int toId = documentwrapperService.save(documentwrapper , to  ) ;
        messagingTemplate.convertAndSend("/queue/privé."+toId, new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize() , employee.getNom()+" "+employee.getPrenom() ) );
    }
    
    @PostMapping("/uploadFileToMany")
    public void uploadFileTomany( @RequestParam("files") MultipartFile file
    		, String []to ,  Documentwrapper documentwrapper){
    	
    	for(String t : to) {
    		uploadFile(  file, t,  documentwrapper) ; 
    	}
    	
    }
    

    @GetMapping("/downloadFile/{from_to:.+_.+}/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String from_to, @PathVariable String fileName, HttpServletRequest request ) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName , from_to);
        
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
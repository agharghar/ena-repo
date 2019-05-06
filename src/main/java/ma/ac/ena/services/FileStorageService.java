package ma.ac.ena.services;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

	Path storeFile(MultipartFile file , String to , String dir) ;
	Resource loadFileAsResource(String fileName, String from_to); 
	
}

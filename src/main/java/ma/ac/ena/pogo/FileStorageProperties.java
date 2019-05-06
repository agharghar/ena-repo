package ma.ac.ena.pogo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="file")
public class FileStorageProperties {

	private String uploadDirectory ;

	public FileStorageProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUploadDirectory() {
		return uploadDirectory;
	}

	public void setUploadDirectory(String uploadDirectory) {
		this.uploadDirectory = uploadDirectory;
	} 
	
	
	
}

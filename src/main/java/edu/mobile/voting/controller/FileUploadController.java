package edu.mobile.voting.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.mobile.storage.DataFileStorageImpl;
import edu.mobile.voting.model.DataFileInfo;
import edu.mobile.voting.repository.DataFileRepo;

@RestController
@RequestMapping("/api")
public class FileUploadController {
	
	@Autowired
	private DataFileRepo dataFileRepo; 
	@Autowired
	private DataFileStorageImpl fileStorage;
	
	private final static String UPLOAD_FOLDER = "D:\\";
	
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    	DataFileInfo dataFileInfo = new DataFileInfo();
    	dataFileInfo.setFileName(file.getOriginalFilename());
    	dataFileInfo.setFileSize(file.getSize());	
    	
    	if(!file.isEmpty() ) {
    		byte[] bytes = file.getBytes();
    		java.nio.file.Path locations = (java.nio.file.Path) Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
    		Files.write(locations, bytes);
    		return "Image upload succeed";
    	} else {
    		return "Image not contained";
    	}
		/*
		 * long id = fileStorage.writeFile(file.getInputStream(), dataFileInfo); return
		 * new ResponseEntity<String>(dataFileRepo.findById(id).get(),
		 * HttpStatus.CREATED);
		 */
    	
    }
    	
    @GetMapping("/uploadFile/{id}")
    public ResponseEntity<DataFileInfo> getFileInfo(@PathVariable("id") long id) {
    	return new ResponseEntity<DataFileInfo>(dataFileRepo.findById(id).get(), HttpStatus.OK);
    }
    
    @GetMapping("/uploadFile/{id}/content")
    public ResponseEntity<InputStreamResource> getFileContentAsStream(@PathVariable("id") long id) throws IOException {
        InputStream inputStream = fileStorage.readFile(id);
        HttpHeaders headers = new HttpHeaders();
        Optional<DataFileInfo> fileInfo = dataFileRepo.findById(id);
        headers.setContentDisposition(ContentDisposition.attachment().filename(fileInfo.get().getFileName()).build());
        
        String contentType = new MimetypesFileTypeMap().getContentType(fileInfo.get().getFileName());
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        
        headers.setContentType(MediaType.parseMediaType(contentType));
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        return ResponseEntity.ok().headers(headers).body(inputStreamResource);
    }
    
    @DeleteMapping("/deleteFile/{id}")
    public String deleteFileInfor(@PathVariable("id") long id) {
    	String statusMesssage = fileStorage.deleteFile(id);
    	return statusMesssage;
    }
    
    @GetMapping("/getAllDataInfo")
    public List<DataFileInfo> getAllDataInfor(){
    	return fileStorage.getAll();
    }
}
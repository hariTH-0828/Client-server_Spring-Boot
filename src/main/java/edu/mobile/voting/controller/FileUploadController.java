package edu.mobile.voting.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.mobile.storage.DataFileStorage;
import edu.mobile.voting.model.DataFileInfo;
import edu.mobile.voting.repository.DataFileRepo;

@RestController
@RequestMapping("/api")
public class FileUploadController {
	
	@Autowired
	private DataFileStorage storage;
	@Autowired
	private DataFileRepo dataFileRepo; 
	
    @PostMapping("/uploadFile")
    public ResponseEntity<DataFileInfo> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    	DataFileInfo dataFileInfo = new DataFileInfo();
    	dataFileInfo.setFileName(file.getOriginalFilename());
    	dataFileInfo.setFileSize(file.getSize());
    	
    	long id = storage.writeFile(file.getInputStream(), dataFileInfo);
    	Optional<DataFileInfo> fileInfo = dataFileRepo.findById(id);
        return ResponseEntity.ok(fileInfo.get());
    }
    
    @GetMapping("/uploadFile/{id}")
    public ResponseEntity<DataFileInfo> getFileInfo(@PathVariable("id") long id) {
    	Optional<DataFileInfo> fileInfo = dataFileRepo.findById(id);
        return ResponseEntity.ok(fileInfo.get());
    }
    
    @GetMapping("/uploadFile/{id}/content")
    public ResponseEntity<InputStreamResource> getFileContentAsStream(@PathVariable("id") long id) throws IOException {
        InputStream inputStream = storage.readFile(id);
        // Set the Content-Disposition header to force a download
        HttpHeaders headers = new HttpHeaders();
        Optional<DataFileInfo> fileInfo = dataFileRepo.findById(id);
        headers.setContentDisposition(ContentDisposition.attachment().filename(fileInfo.get().getFileName()).build());
        
        String contentType = new MimetypesFileTypeMap().getContentType(fileInfo.get().getFileName());
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
    headers.setContentType(MediaType.parseMediaType(contentType));
        // Wrap the InputStream in an InputStreamResource and return it as the response body
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        return ResponseEntity.ok().headers(headers).body(inputStreamResource);
    }
}
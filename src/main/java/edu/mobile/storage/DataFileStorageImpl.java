package edu.mobile.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mobile.voting.model.DataFileInfo;
import edu.mobile.voting.repository.DataFileRepo;

@Component
public class DataFileStorageImpl implements DataFileStorage {
	
	@Autowired
	private DataFileRepo dataFileRepo;
	
	private static final String path = "D:\\Documents\\Project\\user_data\\";
	
	@Override
	public InputStream readFile(long fileId) throws IOException {
		String filePath = path + File.separator+ fileId;
		return new FileInputStream(filePath);
	}

	@Override
	public long writeFile(InputStream inputStream, DataFileInfo dataFileInfo) throws IOException {
		dataFileInfo.setFilePath("");
		DataFileInfo fileInfo = dataFileRepo.save(dataFileInfo);
		long id = fileInfo.getId();
		String filePath = path + File.separator + id;
		FileOutputStream outputStream = new FileOutputStream(filePath);
		IOUtils.copy(inputStream, outputStream);
		
		IOUtils.closeQuietly(outputStream);
		IOUtils.closeQuietly(inputStream);
		return id;
	}

	@Override
	public boolean deleteFile(long fileId) {
		
		return false;
	}

}

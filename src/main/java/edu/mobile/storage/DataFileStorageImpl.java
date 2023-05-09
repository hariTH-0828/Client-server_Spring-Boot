package edu.mobile.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mobile.voting.model.DataFileInfo;
import edu.mobile.voting.repository.DataFileRepo;

@Component
public class DataFileStorageImpl implements DataFileStorage {
	
	@Autowired
	private DataFileRepo dataFileRepo;
	
	File file;
	
	private static final String path = "C:\\Documents\\Project\\user_data\\";
	
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
	public String deleteFile(long fileId) {
		File file = new File(path, String.valueOf(fileId));
		file.delete();
		dataFileRepo.deleteById(fileId);
		return "File delete successfully";
	}

	@Override
	public List<DataFileInfo> getAll() {
		return dataFileRepo.findAll();
	}
}

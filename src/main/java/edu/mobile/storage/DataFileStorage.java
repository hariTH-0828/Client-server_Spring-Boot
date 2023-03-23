package edu.mobile.storage;

import java.io.IOException;
import java.io.InputStream;

import edu.mobile.voting.model.DataFileInfo;

public interface DataFileStorage {
	public InputStream readFile(long fileId) throws IOException;

	public boolean deleteFile(long fileId);

	long writeFile(InputStream inputStream, DataFileInfo dataFileInfo) throws IOException;
}
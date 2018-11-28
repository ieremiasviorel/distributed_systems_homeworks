package org.assignment_3_2_consumer.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

	public void generateFile(String fileName, String fileContent) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
		writer.write(fileContent);
		writer.close();
	}
}

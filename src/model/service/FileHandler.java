package model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	private static final String PART_OF_THE_NEW_FILE_NAME = "/copy_of_";

	public static List<String> fileAsList(String pathAndFileName) {
		List<String> fileContents = new ArrayList<>();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(pathAndFileName))) {
			fileContents = readingFile(fileReader);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return fileContents;
	}

	private static List<String> readingFile(BufferedReader fileReader) throws IOException {
		List<String> fileContents = new ArrayList<>();

		String currentFileLine = fileReader.readLine();
		while (currentFileLine != null) {
			fileContents.add(currentFileLine);
			currentFileLine = fileReader.readLine();
		}

		return fileContents;
	}
	
	public static void listAsFile(List<String> fileContents, String oldFilePath) {
		String pathAndNameOfNewFile = creatingPathAndNameOfModifiedFile(oldFilePath);
		try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(pathAndNameOfNewFile))) {
			for (String line : fileContents) {
				fileWriter.write(line);
				fileWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String creatingPathAndNameOfModifiedFile(String oldFilePath) {
		String[] partsOfTheFilePath = oldFilePath.split("/");
		String pathAndNameOfNewFile = partsOfTheFilePath[0];
		for (int count = 1; count < partsOfTheFilePath.length - 1; count++) {
			pathAndNameOfNewFile += "/" + partsOfTheFilePath[count];
		}
		pathAndNameOfNewFile += PART_OF_THE_NEW_FILE_NAME;
		pathAndNameOfNewFile += partsOfTheFilePath[partsOfTheFilePath.length - 1];
		
		return pathAndNameOfNewFile;
	}
}

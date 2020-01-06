package model.service;

import java.util.List;

public class FileContentModifier {
	public static List<String> removeBlankLinesFromFile(List<String> fileContents, int startOfModification, int endOfModification) {
		for (int iterator = startOfModification; iterator < endOfModification; iterator++) {
			if (fileContents.get(iterator).equals("")) {
				fileContents.remove(iterator);
				endOfModification--;
			}
		}
		
		return fileContents;
	}
}

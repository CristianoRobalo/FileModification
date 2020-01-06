package application;

import java.util.ArrayList;
import java.util.List;

import model.service.FileContentModifier;
import model.service.FileHandler;
import view.UserInterface;

public class Program {
	
	public static void main(String[] args) {
		String filePath = UserInterface.askUserForFilePath();
		int startOfModification = UserInterface.askTheUserWhichLineToStartModifying();
		int endOfModification = UserInterface.askTheUserWhichLineToStopModifying();
		
		List<String> fileContents = new ArrayList<>();
		fileContents = FileHandler.fileAsList(filePath);
		
		fileContents = FileContentModifier.removeBlankLinesFromFile(fileContents, startOfModification, endOfModification);
		
		FileHandler.listAsFile(fileContents, filePath);
		
		UserInterface.completionMessageAndCloseScan();
	}

}

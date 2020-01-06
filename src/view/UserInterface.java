package view;

import java.util.Scanner;

public class UserInterface {
	private static Scanner scan = new Scanner(System.in);
	
	public static String askUserForFilePath() {
		System.out.print("Em qual arquivo devo trabalhar? ");
		return getUserInputOfTypeString();
	}
	
	public static int askTheUserWhichLineToStartModifying() {
		System.out.print("A partir de qual linha começo a modificar? ");
		return getUserInputOfTypeInteger();
	}
	
	public static int askTheUserWhichLineToStopModifying() {
		System.out.print("Até que linha devo modificar? ");
		return getUserInputOfTypeInteger();
	}
	
	public static void completionMessageAndCloseScan() {
		System.out.println("Concluído!");
		closeScan();
	}
	
	private static void closeScan() {
		if (scan != null) {
			scan.close();
		}
	}
	
	private static String getUserInputOfTypeString() {
		String userInput = scan.nextLine();
		return userInput;
	}
	
	private static int getUserInputOfTypeInteger() {
		int userInput = scan.nextInt();
		return userInput;
	}
}

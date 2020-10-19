//Imports
import util.Input;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ContactApp {
	//================== Main CLI==================
	public static void mainCLI() throws IOException {
		Input input = new Input();
		Scanner sc = new Scanner(System.in);
		Path dataFilePath = Paths.get("ContactList", "ContactList.txt");


		System.out.println("1. View contacts.");
		System.out.println("2. Add a new contact.");
		System.out.println("3. Search a contact by name.");
		System.out.println("4. Delete an existing contact.");
		System.out.println("5. Update an Existing Contact.");
		System.out.println("6. List options.");
		System.out.println("7. Exit.");

		createDirectoryAndFile();
		while (true) {
			System.out.println("Enter an option (1, 2, 3, 4, 5 or 6):");
			int userInput = sc.nextInt();
			switch (userInput) {
				case 1:
					System.out.println("1. View contacts.");
					printFileContents(dataFilePath);
					break;
				case 2:
					System.out.println("2. Add a new contact.");
					PersonInfo person = new PersonInfo(input, false);
					break;
				case 3:
					System.out.println("3. Search a contact by name.");
					//searchForContact();
					break;
				case 4:
					System.out.println("4. Delete an existing contact.");
					deleteLine();
					break;
				case 5:
					System.out.println("5. Update an Existing Contact.");
					updateLine();
					break;
				case 6:
					System.out.println("6. List Options.");
					mainCLI();
					break;
				case 7:
					System.out.println("7. Exit.");
					boolean quit = input.yesNo("Are You sure you want to quit?(Y/N)");
					if (quit) {
						System.out.println("Program ending");
						System.out.println("01101000 01110100 01110100 01110000 01110011 00111010 00101111 00101111 01100101 01101110\n 00101110 01110111 01101001 01101011 01101001 01110000 01100101 01100100 01101001\n 01100001 00101110 01101111 01110010 01100111 00101111 01110111 01101001 01101011 01101001\n 00101111 01000010 01101001 01101111 01110000 01101000 01101111 01101110 01100101 ");
						System.exit(0);
					} else {
						break;
					}
					break;
				default:
					System.out.print("Invalid! ");
			}
		}
	}


	//================== File Creation Method==================
	public static void createDirectoryAndFile() throws IOException {
		Input input = new Input();
		String directoryName = "ContactList";
		String fileName = "ContactList.txt";

		System.out.println("Folder Name = " + directoryName);
		System.out.println("File Name = " + fileName);

		try {
			System.out.println();
			Path dataFilePath = createDirectoryAndFile(directoryName, fileName); //Todo: dataFilePath global
		} catch (IOException ex) {
			System.out.println("Cannot create the file.");
			ex.printStackTrace();
		}
	}

	public static Path createDirectoryAndFile(String directoryName, String fileName) throws IOException {
		Path directoryPath = Paths.get(directoryName);
		Path dataFilePath = Paths.get(directoryName, fileName);

		if (Files.notExists(directoryPath)) {
			Files.createDirectories(directoryPath);
		}
		if (!Files.exists(dataFilePath)) {
			Files.createFile(dataFilePath);
		}
		return dataFilePath;
	}



	//================== File Manipulation Methods==================
	public static void printFileContents(Path filePath) throws IOException {
		System.out.println();
		List<String> fileContents = Files.readAllLines(filePath);
		for (int i = 0; i < fileContents.size(); i++) {
			System.out.printf("%s\n", fileContents.get(i));
		}
	}

	//Todo:Broke only for add
	public static String createContact() throws IOException {
		Input input = new Input();
		PersonInfo person = new PersonInfo(input, true);

		List<String> list = new ArrayList<>();
		list.add(person.name + "  |  " + person.number);

		String updateContact = (person.name + "  |  " + person.number);
		return updateContact;
	}

	public static void updateLine() throws IOException {
		Input input = new Input();
		Path filePath = Paths.get("ContactList", "ContactList.txt");

		String oldValue = input.getString("Who do you want to delete?");
		System.out.println("What would you like to change it to?");
		String newValue = createContact();

		List<String> fileContents = Files.readAllLines(filePath);
		for (int i = 0; i < fileContents.size(); i++) {
			List<String> newList = new ArrayList<>();
			for (String item : fileContents) {
				if (item.contains(oldValue)) {
					newList.add(newValue);
				} else {
					newList.add(item);
				}
				Files.write(filePath, newList);
				fileContents = Files.readAllLines(filePath);
			}
		}
	}


	public static void deleteLine() throws IOException {
		Input input = new Input();
		Path filePath = Paths.get("ContactList", "ContactList.txt");

		System.out.println("Who do you want to delete?");
		String line = input.getString("Name: ");

		List<String> fileContents = Files.readAllLines(filePath);
		List<String> modifiedList = new ArrayList<>();
		for (String item: fileContents) {
			if (!item.equalsIgnoreCase(line)) {
				modifiedList.add(item);
			}
		}
		Files.write(filePath, modifiedList);
	}



//	public static void searchForContact() throws IOException {
//		Input input = new Input();
//		seachName = input.getString("Name: ");
//		for (String element : list) {
//			if (element.contains(seachName)) {
//				System.out.println(element);
//			}
//		}
//	}

	public static void bioPhone() {
		System.out.println(" ______     __     ______     ______   __  __     ______     __   __     ______    \n" +
						"/\\  == \\   /\\ \\   /\\  __ \\   /\\  == \\ /\\ \\_\\ \\   /\\  __ \\   /\\ \"-.\\ \\   /\\  ___\\   \n" +
						"\\ \\  __<   \\ \\ \\  \\ \\ \\/\\ \\  \\ \\  _-/ \\ \\  __ \\  \\ \\ \\/\\ \\  \\ \\ \\-.  \\  \\ \\  __\\   \n" +
						" \\ \\_____\\  \\ \\_\\  \\ \\_____\\  \\ \\_\\    \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_\\\\\"\\_\\  \\ \\_____\\ \n" +
						"  \\/_____/   \\/_/   \\/_____/   \\/_/     \\/_/\\/_/   \\/_____/   \\/_/ \\/_/   \\/_____/ \n" +
						"                                                                                  ");
	}
}
package ContactApplication;

import util.Input;

import util.Input;

import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ContactApp {

	//================== Main CLI==================
	public static void mainCLI() throws IOException {
		Input input = new Input();
		Scanner sc = new Scanner(System.in);

		System.out.println("1. Create contact list.");
		System.out.println("2. View contacts.");
		System.out.println("3. Add a new contact.");
		System.out.println("4. Search a contact by name.");
		System.out.println("5. Delete an existing contact.");
		System.out.println("6. List options.");
		System.out.println("7. Exit.");
		
	 while (true) {
			System.out.println("Enter an option (1, 2, 3, 4, 5, 6 or 7):");
			int userInput = sc.nextInt();
			switch (userInput) {
				case 1:
					System.out.println("1. Create contact list.");
					createDirectoryAndFile();
					break;
				case 2:
					System.out.println("2. View contacts.");
//					printFileContents(dataFilePath);
					break;
				case 3:
					System.out.println("3. Add a new contact.");
					break;
				case 4:
					System.out.println("4. Search a contact by name.");
					break;
				case 5:
					System.out.println("5. Delete an existing contact.");
					break;
				case 6:
					System.out.println("5. List Options.");
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
//			return input.yesNo("Do you want to continue?(Y/N)");
//		} while (true);
//	}
	}


	//================== File Creation Method==================
	public static void createDirectoryAndFile() throws IOException {
		Input input = new Input();
		String directoryName = "ContactList";
		String fileName = input.getString("Enter the phone book name");

		System.out.println("Folder Name = " + directoryName);
		System.out.println("File Name = " + fileName);

		try {
			Path dataFilePath = createDirectoryAndFile(directoryName, fileName);
			printFileContents(dataFilePath);
		} catch (IOException ex) {
			System.out.println("Cannot create the file.");
			ex.printStackTrace();
		}
	}

	public static Path createDirectoryAndFile(String directoryName, String fileName) throws IOException {
		Path directoryPath = Paths.get(directoryName);
		Path dataFilePath = Paths.get(directoryName, fileName);
		//We have to create a directory first before we create before we create the file.
		if (Files.notExists(directoryPath)) {
			Files.createDirectories(directoryPath);
		}
		if (!Files.exists(dataFilePath)) {
			Files.createFile(dataFilePath);
		}
		return dataFilePath;/*Todo:Return dataFilePath(Global Scale)*/
	}
	//================== File Manipulation Methods==================

	public static void printFileContents(Path filePath) throws IOException {
		System.out.println();
		List<String> fileContents = Files.readAllLines(filePath);
		for (int i = 0; i < fileContents.size(); i++) {
			System.out.printf("%s\n", fileContents.get(i));
		}
		mainCLI();/*Todo:Refactor to return user to mainCLI()*/
	}

//	class PersonInfo {
//		protected String name;
//		protected int number;
//
//		public PersonInfo(String name, int aNumber) {
//			this.name = name;
//			this.number = aNumber;
//		}
//
//		public String getName(String name) {
//			return name;
//		}
//
//		public Long getNumber(Long number) {
//			return number;
//		}
//
//		public int getInt(String number) {
//			int aInteger = 0;
//			try {
//				aInteger = Integer.parseInt(number);
//			} catch (NumberFormatException NFExc) {
//				System.err.println("Not a valid integer");
//			}
//			return aInteger;
//		}
//	}




/*================== Writing a File ==================
//		System.out.print("Enter a name");
//		String name = input.getString().trim();
//
//		System.out.printf("Enter a phone number for %s", name);
//		int number = input.getInt();
//
//		PersonInfo person = new PersonInfo(name, number);
//
//		List<Object> list = new ArrayList<>();
//		list.add(person);
//		Files.write(dataFilePath, list);

//		HashMap<String, PersonInfo> contactInfo = new HashMap<>();
//		contactInfo.put(name,person);

//		List<String> list = new ArrayList<>();
//		list.add(PersonInfo);

//		Files.write(dataFilePath,list);

//		System.out.println("Hello World!");
 */
}
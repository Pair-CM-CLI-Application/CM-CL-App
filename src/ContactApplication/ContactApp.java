package ContactApplication;

//import util.Input;

import util.Input;
import java.util.Scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ContactApp {

	//================== Main CLI==================
	public static void mainCLI() {
//			Input input = new Input();
		Scanner sc = new Scanner(System.in);


		System.out.println("1. Create contact list.");
		System.out.println("2. View contacts.");
		System.out.println("3. Add a new contact.");
		System.out.println("4. Search a contact by name.");
		System.out.println("5. Delete an existing contact.");
		System.out.println("6. Exit.");
		System.out.println("Enter an option (1, 2, 3, 4, 5 or 6):");
		int userInput = sc.nextInt();

		switch (userInput) {
			case 1:
				System.out.println("1. Create contact list.");
				ContactApp.createDirectoryAndFile();
				break;
			case 2:
				System.out.println("2. View contacts.");
//					ContactApp.printFileContents(dataFilePath);
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
				System.out.println("6. Exit.");
				break;
			default:
				System.out.println("Invalid! Enter an option (1, 2, 3, 4 or 5):");
		}
	}

	//================== File Creation Method==================
	public static Path createDirectoryAndFile(String directoryName, String fileName) throws IOException {
		nameList();
		Path dataFilePath = ContactApp.createDirectoryAndFile(directoryName, fileName);

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

	public static String[] nameList () {
		Input input = new Input();
		String directoryName = "ContactList";
		String fileName = input.getString("Enter the phone book name");
		return new String[] { directoryName, fileName };
	}

	//================== File Manipulation Methods==================

	public static void printFileContents(Path filePath) throws IOException {
		System.out.println();
		List<String> fileContents = Files.readAllLines(filePath);
		for (int i = 0; i < fileContents.size(); i++) {
			System.out.printf("%s\n", fileContents.get(i));
		}
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
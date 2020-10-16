package ContactApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactMain {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);

		String directoryName = "ContactList";
		String fileName = "contactList.txt";

		Path dataFilePath = ContactApp.createDirectoryAndFile(directoryName, fileName);


		System.out.println("Enter a name");
		String name = sc.nextLine();

		System.out.printf("Enter a phone number for %s", name);
		String number = sc.nextLine();

		PersonInfo person = new PersonInfo(name, number);


		List<String> contactInfo = Arrays.asList(person);

		System.out.println("Hello World!");
	}
}

package ContactApplication;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactMain {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);

		String directoryName = "ContactList";
		String fileName = "contactList.txt";

		Path dataFilePath = ContactApp.createDirectoryAndFile(directoryName, fileName);


		System.out.println("Enter a name");
		String name = sc.nextLine();

		System.out.printf("Enter a phone number for %s", name);
		Input input = new Input();

		PersonInfo person = new PersonInfo(name, 46234);

		HashMap<String, PersonInfo> contactInfo = new HashMap<>();
		contactInfo.put(name,person);

		List<String> list = new ArrayList<>();
		list.add(name);

		Files.write(dataFilePath,list);

		System.out.println("Hello World!");
	}
}

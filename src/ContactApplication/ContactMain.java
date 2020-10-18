package ContactApplication;

//import util.Input;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.*;

import java.nio.file.Path;

public class ContactMain {
	public static void main(String[] args) {
		ContactApp.mainCLI();


		String directoryName = "ContactList";
		String fileName = "contactList.txt";

		Path dataFilePath = ContactApp.createDirectoryAndFile(directoryName, fileName);
	}
}
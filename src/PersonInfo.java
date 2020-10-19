import util.Input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PersonInfo {
	protected String name;
	protected String number;


	public PersonInfo(Input input, Boolean replace) throws IOException {

		this.name = input.getString("Name: ");
		this.number = input.getString("number: ");
//		//Todo:Bonus adding hash
//		if (this.number.length() == 7) {
//			//7 digit phone number format
//		} else if (this.number.length() == 10) {
//			//10 digit phone number format
//		}  else {
//			//invalid phone number length
//		}
//
//		//Todo:Check for already existing contact
////		ContactApp.searchForContact();


		Path filePath = Paths.get("ContactList", "ContactList.txt");
		List<String> fileContents = Files.readAllLines(filePath);


		List<String> list = new ArrayList<>();
		list.add(name + "  |  " + number);

		Files.write(filePath, list, StandardOpenOption.APPEND);

		for (int i = 0; i < fileContents.size(); i++) {
			List<String> newList = new ArrayList<>();
			for (String item : fileContents) {
				newList.add((i + 1) + ": " + item); //replaces thing 3
				Files.write(filePath, newList, StandardOpenOption.APPEND); //puts new list back
			}
		}
		if (!replace) {
			Files.write(filePath, list, StandardOpenOption.APPEND);
		}
	}


	personCreate() {

	}
}
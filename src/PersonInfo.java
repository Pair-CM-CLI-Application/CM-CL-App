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
		//Todo:Bonus adding hash
//		if (this.number.length() == 7) {
//			String sub1 = number.substring(0, 3);
//			String sub2 = number.substring(3);
//			System.out.println(sub1 + "-" + sub2);
//
//		} else if (this.number.length() == 10) {
//			//10 digit phone number format
//		} else {
//			//invalid phone number length
//		}
//
//		//Todo:Check for already existing contact
////		ContactApp.searchForContact();


		Path filePath = Paths.get("ContactList", "ContactList.txt");
		List<String> fileContents = Files.readAllLines(filePath);


//		List<String> list = new ArrayList<>();
//		list.add(name + "  |  " + number);
		String contact = (name + "  |  " + number);
//		Files.write(filePath, list, StandardOpenOption.APPEND);


		List<String> list = new ArrayList<>();
		for (int i = -1; i < fileContents.size(); i++) {
			for (String item : fileContents) {
				int last = i - 1;
				if (last == fileContents.size()) {
					list.add((i) + ": " + contact);
				} else {
					list.add(item);
				}
				Files.write(filePath, list);
			}
			if (!replace) {
				Files.write(filePath, list, StandardOpenOption.APPEND);
			}
		}
	}
}





//		List<String> list = new ArrayList<>();
//			for (String item : fileContents) {
//				if (i-1 == fileContents.size()) {
//					int e = i;
//					list.add((++e) + ": " + contact);
//					Files.write(filePath, list, StandardOpenOption.APPEND); //puts new list back
//				}
//				if (!replace) {
//					Files.write(filePath, list, StandardOpenOption.APPEND);
//				}
//	personCreate()

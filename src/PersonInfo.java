import util.Input;

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
//		ContactApp.searchForContact();

		List<String> list = new ArrayList<>();
		list.add(name + "  |  " + number);
		Path dataFilePath = Paths.get("ContactList", "ContactList.txt");
		if (!replace){
			Files.write(dataFilePath,list, StandardOpenOption.APPEND);
		}
	}
}
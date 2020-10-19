package ContactApplication;

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

	public PersonInfo(Input input) throws IOException {
		this.name = input.getString("Name: ");
		this.number = input.getString("number: ");
		List<String> list = new ArrayList<>();
		list.add(name + "  |  " + number);
		Path dataFilePath = Paths.get("ContactList", "ContactList.txt");
		Files.write(dataFilePath,list, StandardOpenOption.APPEND);
	}
}
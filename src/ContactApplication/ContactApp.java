package ContactApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

	class ContactApp {
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
	}


	class PersonInfo {
		protected String name;
		protected Long number;

		public PersonInfo(String name, Long aNumber) {
			this.name = name;
			this.number = aNumber;
		}

		public String getName(String name) {
			return name;
		}

		public Long getNumber(Long number) {
			return number;
		}

		public int getInt(String number) {
			int aInteger = 0;
			try {
				aInteger = Integer.parseInt(number);
			} catch (NumberFormatException NFExc) {
				System.err.println("Not a valid integer");
			}
			return aInteger;
		}
	}



	//Bonus: Add email, home/work number
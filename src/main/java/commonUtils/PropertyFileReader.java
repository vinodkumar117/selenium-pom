package commonUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	private static Properties properties = null;
	private static String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\data.properties";

	static {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filepath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("file not found " + filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String configname) {

		return properties.getProperty(configname);

	}

}

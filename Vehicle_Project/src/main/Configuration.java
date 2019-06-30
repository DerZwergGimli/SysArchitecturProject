package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public void generateConfig() {
		Properties prop = new Properties();

		try {

			prop.setProperty("banner.delay", "5");
			prop.setProperty("console.clearScreen", "true");
			prop.setProperty("console.showStatusInConsole", "true");

			// save properties to project root folder
			prop.store(new FileOutputStream("c://config_vehicle.properties"), null);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}

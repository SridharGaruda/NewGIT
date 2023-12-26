package testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
public static void main(String[] args) throws IOException {
	
	//Creating object of property class which is already available in java
	Properties prop = new Properties();
	
	//creating object of fileinputstream class
	FileInputStream fp = new FileInputStream("G:\\Sridhar\\code\\NewGIT\\src\\main\\java\\testing\\Config.prop");
	
	//File input stream class making a connection between java code and config.properties
	//prop.load will load all the config available in config.properties
	prop.load(fp);
	
	//to get the value from config use get property method. 
	//In the below code we are passing the key i.e, browser to get the value of it from the config.properties
	System.out.println(prop.getProperty("browser"));
	
}
}

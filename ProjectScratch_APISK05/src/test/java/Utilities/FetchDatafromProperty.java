package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Constants.constantsData;

public class FetchDatafromProperty {
	
	static  FileReader reader;
	 
	 public static Properties readDataFromProperty() 
	 {
		 try {
			reader=new FileReader(constantsData.propertyfilepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Properties prop=new Properties();
		 try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return prop;
		 
		 
	 }
	
	
	
	

}

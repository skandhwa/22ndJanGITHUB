package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Constants.constantsData;

public class FetchDatafromExcel {
	static Map<String,Object> mp=new LinkedHashMap<String,Object>();
	
	@Test
	
	public static String getData(int x,int y) throws IOException, InvalidFormatException,InvalidPathException
	
	
	{
		FileInputStream fs=new FileInputStream(constantsData.testDataPath);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFCell value=sheet.getRow(x).getCell(y);
	String testDataValue=value.toString();
	return testDataValue;
	
	
	
		
		
		
	}
	
	public static Map AddNewUserDetails() throws InvalidFormatException, InvalidPathException, IOException
	{
		
		mp.put("username",FetchDatafromExcel.getData(1, 0) );
		mp.put("job",FetchDatafromExcel.getData(1, 1) );
		return mp;
		
	}
	
	
	public static Object getUserName()
	{
		Object username=mp.get("username");
		return username;
	}
	
	

}

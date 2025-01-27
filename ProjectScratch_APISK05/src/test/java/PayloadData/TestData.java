package PayloadData;

import java.util.LinkedHashMap;
import java.util.Map;

import Utilities.CommonFunctions;

public class TestData {
	
	static Map<String,Object> mp=new LinkedHashMap<String,Object>();
	
	public static Map AddUserDetails()
	{
		
		mp.put("name","John");
		mp.put("gender","male");
		mp.put("email",CommonFunctions.generateRandomEmail());
		mp.put("status","active");
		return mp;
		
	}
	
	public static Object getName()
	{
	Object name=	mp.get("name");
	
	return name;
	}
	
	
	public static Object getEmail()
	{
	Object email=	mp.get("email");
	
	return email;
	}
	

}

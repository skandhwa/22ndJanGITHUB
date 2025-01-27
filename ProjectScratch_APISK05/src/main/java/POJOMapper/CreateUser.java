package POJOMapper;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateUser {
	
	static CreateUserPOJO emp=new CreateUserPOJO();
	static String empJson;
	static  ObjectMapper obj=new ObjectMapper();
	
	public static String userDetais() throws JsonProcessingException
	{
		
		emp.setName("Tom");
		emp.setAddress("Kolkata");
		emp.setId(1234);
		emp.setMarried(true);
        
       
		
        empJson =     obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
   
   
   return empJson;
   
   
	
   
   
	}
	
	public static int getID() throws JsonMappingException, JsonProcessingException
	{
		CreateUserPOJO empObj=obj.readValue(empJson,CreateUserPOJO.class);
		int ID=empObj.getId();
		return ID;
		
		
	}
	
	public static String getName() throws JsonMappingException, JsonProcessingException
	{
		CreateUserPOJO empObj=obj.readValue(empJson,CreateUserPOJO.class);
		String name=empObj.getName();
		return name;
		
		
	}
	
	
	

}

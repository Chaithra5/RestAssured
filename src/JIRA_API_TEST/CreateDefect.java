package JIRA_API_TEST;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.ReusableMethods;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateDefect {
  
	Properties pro;
	@BeforeTest
	public void init() throws FileNotFoundException, IOException
	{
		pro=new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Documents\\RestAssuerd API\\RestPractice1\\src\\files\\evn.properties");
		pro.load(fis);
	}
	@Test 
	public void testScript()
	{
		
		///creating defect
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		Response res = given().header("Content-Type", "application/json").
		header("Cookie","JSESSIONID="+ReusableMethods.getCoockie()).
		body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"RES\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"Debit card defect2\",\r\n" + 
				"       \"description\": \"adding comment to this bug\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}").
		when().
		post("/rest/api/2/issue").
		then().statusCode(201).extract().response();
		JsonPath js = ReusableMethods.jsonToRaw(res);
		            String id = js.get("id");
		            System.out.println("ID : "+id);
	}
}

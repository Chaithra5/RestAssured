package JIRA_API_TEST;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddComment {

	////Adding the comment
	Properties pro;
	@BeforeTest
	public void init() throws FileNotFoundException, IOException
	{
		pro=new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Documents\\RestAssuerd API\\RestPractice1\\src\\files\\evn.properties");
		pro.load(fis);
	}
	
	@Test
	public void addComment()
	{
RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		Response res = given().header("Content-Type", "application/json").
		header("Cookie","JSESSIONID="+ReusableMethods.getCoockie()).
		body("{\r\n" + 
				"	\"body\": \"I have commented from automation Rest API\",\r\n" + 
				"	\r\n" + 
				"		\"visibility\": {\r\n" + 
				"    \"type\": \"role\",\r\n" + 
				"    \"value\": \"Administrators\"\r\n" + 
				"  \r\n" + 
				"	}\r\n" + 
				"}").
		when().
		post("/rest/api/2/issue/10200/comment").  ///id taken from previous Create defect class
		then().statusCode(201).extract().response();
		JsonPath js = ReusableMethods.jsonToRaw(res);
		            String commentid = js.get("id");
		            System.out.println("ID : "+commentid);
	}
}

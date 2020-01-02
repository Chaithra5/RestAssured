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

public class UpdateComment {

	Properties pro;
	@BeforeTest
	public void init() throws FileNotFoundException, IOException
	{
		pro=new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Documents\\RestAssuerd API\\RestPractice1\\src\\files\\evn.properties");
		pro.load(fis);
	}
	
	@Test 
	public void updateComment()
	{
RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		Response res = given().header("Content-Type", "application/json").
		header("Cookie","JSESSIONID="+ReusableMethods.getCoockie()).
		body("{\r\n" + 
				"	\"body\": \"Hey i am updating the comment from automation script\",\r\n" + 
				"	\r\n" + 
				"		\"visibility\": {\r\n" + 
				"    \"type\": \"role\",\r\n" + 
				"    \"value\": \"Administrators\"\r\n" + 
				"  \r\n" + 
				"	}\r\n" + 
				"}").
		when().
		put("/rest/api/2/issue/10200/comment/10100").  ///updatecommentid taken from previous  AddComment class
		then().statusCode(200).extract().response();
		JsonPath js = ReusableMethods.jsonToRaw(res);
		            String updatecommentid = js.get("id");
		            System.out.println("ID : "+updatecommentid);
	}
}

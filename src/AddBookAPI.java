import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddBookAPI {
	
	@Test
	public void addBook() {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		Response resp = given().
		headers("Content-Type","application/json").
		body("{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\"desahv\",\r\n" + 
				"\"aisle\":\"227\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"").
		when()
		.post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response();
		
		            String response = resp.asString();
		            System.out.println(response);
		            JsonPath js=new JsonPath(response);
		            String id = js.get("ID");
		           System.out.println("ID : "+id );
	}

}

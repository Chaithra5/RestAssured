import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StaticJson {

	@Test()
	public void addBook( ) throws IOException {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		//add book to library
		Response resp = given().
		headers("Content-Type","application/json").
		body(GenerateStringFromResource("E:\\RestAssured API\\addBookDetails.json") ).
		when()
		.post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath js = ReusableMethods.jsonToRaw(resp);
		            String id = js.get("ID");
		           System.out.println("ID : "+id );
	}
	public static String GenerateStringFromResource(String path) throws IOException
	{
	return new String(Files.readAllBytes(Paths.get(path)));
	}

}

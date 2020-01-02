package XMLData;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class XmlAddData {


	@Test
	public void xmlAdd() throws IOException
	{
		String postdata=GenerateStringFromResource("E:\\RestAssured API\\postdata.xml");
		RestAssured.baseURI="http://216.10.245.166";

		Response resp=given().
		queryParam("key","qaclick123").
		body(postdata).

		when().
		post("/maps/api/place/add/xml").

		then().assertThat().statusCode(200).and().contentType(ContentType.XML).
		extract().response(); //extracting response
		          
		XmlPath xmldata = ReusableMethods.xmlToRaw(resp);
		String placeid=xmldata.get("response.place_id");
		System.out.println("place id : "+placeid);
	}

	public static String GenerateStringFromResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));   ///reading all the xml path into bytes and returning into string
	                                                              //converting xml into string data
	
	}
}

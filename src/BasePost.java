import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class BasePost {

	@Test
	public void testScriptP()
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		given().
		queryParam("key","qaclick123").
		
		body("{\r\n" + 
				   "	\"location\":{\r\n" + 
				"		\"lat\" :-38.383494,\r\n" + 
				"		\"lng\" :33.427362\r\n" + 
				"		},\r\n" + 
				"		\"accuarcy\" :50,\r\n" + 
				"		\"name\" :\"Frontline house\",\r\n" + 
				"		\"phone_number\" :\"(+91) 983 693 3937\",\r\n" + 
				"		\"address\" :\"29, side layout ,coren 09 84758,\",\r\n" + 
				"		\"types\": [\"snoe park\",\"shop\"],\r\n" + 
				"		\"website\": \"http://google.com\",\r\n" + 
				"		\"language\":\"French-IN\"\r\n" + 
				"}").
		
		when().
		post("/maps/api/place/add/json").
		
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
		.body("status",equalTo("OK"));
	}
}

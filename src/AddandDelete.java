import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Payload;
import files.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddandDelete {

	Properties pro;
	@BeforeTest
	public void initialize() throws IOException
	{
		pro=new Properties();
		FileInputStream  fis=new FileInputStream("C:\\Users\\User\\Documents\\RestAssuerd API\\RestPractice1\\src\\files\\evn.properties");
		pro.load(fis);

	}

	@Test
	public void mainSript()
	{


		RestAssured.baseURI=pro.getProperty("HOST");

		//task 1:Grab the response
		Response res = given().           ///will get response in raw format
				queryParam("key",pro.getProperty("KEY")).
				body(Payload.getpayLoad()).
				when().
				post( Resources .getResource()).

				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("status",equalTo("OK")).
				extract().response();

		//Task 2:Grab the place id from the response
		System.out.println(res);
		System.out.println("********");
		String responseString = res.asString();   //convert raw format to string
		System.out.println(responseString);
		JsonPath js=new JsonPath(responseString);      ///convert string form to json
		String placeid = js.get("place_id");
		System.out.println("place id : "+ placeid);

		//Task 3: place id in delete request
		given().           
		queryParam("key","qaclick123").
		body("{"+
				"\"place_id\": \""+ placeid+"\""+

				"}").
		when().
		post("/maps/api/place/delete/json").
		then().assertThat().statusCode(404).and().contentType(ContentType.JSON)
		.and()	.body("status",equalTo("OK"));
	}
}
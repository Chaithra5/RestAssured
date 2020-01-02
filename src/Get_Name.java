import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Name {

	@Test
	public void testScriptG()
		
	
	{
		//BaseURL or host
		RestAssured.baseURI="https://maps.googleapis.com";
		
		Response resp = given().
		
		param("location","-33.8670522,151.1957362").
		param("radius","1500").
		param("key","AIzaSyBxEAKPG73dCRqy3o4eWZBcvt8s3s8bpPk").log().all().
		when().
		get("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
		.body("results[0].name", equalTo("Sydney")).and().body("results[0].place_id",equalTo( "ChIJP3Sa8ziYEmsRUKgyFmh9AQM"))
		.and().header("Server", "scaffolding on HTTPServer2").log().body().
		extract().response();
		
		JsonPath json = ReusableMethods.jsonToRaw(resp);
		int  count = json.get("results.size()");
		 System.out.println(count);
		 for(int i=0;i<count;i++)
		 {
			 String placeName = json.get("results["+i+"].name");
			 System.out.println(placeName);
		 }
}
}
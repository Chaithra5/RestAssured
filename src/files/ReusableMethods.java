package files;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {

	public static XmlPath xmlToRaw(Response r)
	{
		String response = r.asString();    //converting raw data into string
	     XmlPath  x=new XmlPath(response);
	     return x;
	}
	
	public static JsonPath jsonToRaw(Response r)
	{
		String response = r.asString();    //converting raw data into string
		System.out.println(response);
	     JsonPath  x=new JsonPath(response);
	     return x;
	}
	
	public static String getCoockie()
	{
		//create session
		  RestAssured.baseURI="http://localhost:8080";
		  
			 Response res = given().
			  headers("Content-Type","application/json").
			  body("{ \"username\": \"ChaithraKota\", \"password\": \"Kota@1994\" }").
			  when().
			  post("/rest/auth/1/session").
			  then().assertThat().statusCode(200).
			  extract().response();
			 JsonPath js = ReusableMethods.jsonToRaw(res);
			String sessionvalue = js.get("session.value");
			System.out.println("Session id : "+sessionvalue);
			return sessionvalue;
	}
}

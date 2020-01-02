import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DynamicJson {
	
	
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle ) {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		//add book to library
		Response resp = given().
		headers("Content-Type","application/json").
		body( Payload.getAddBook(isbn,aisle)).
		when()
		.post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath js = ReusableMethods.jsonToRaw(resp);
		            String id = js.get("ID");
		           System.out.println("ID : "+id );

		           //delete book from library
		          Response resps = given().
		           body("{\r\n" + 
		           		" \r\n" + 
		           		"\"ID\" : \""+id+"\"\r\n" + 
		           		" \r\n" + 
		           		"}").
		   		when()
		   		.post("/Library/DeleteBook.php").
		   		then().assertThat().statusCode(200).
		   		extract().response();
		         String deleteresp=resps.asString();
		   		System.out.println( deleteresp);
}
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		//array=collection of element
		//multidimensional array=collection of arrays
		return new Object[][] { {"gygy","439"},{"ius","874"},{"uajk","232"},{"yad","32983"} };
	}
}
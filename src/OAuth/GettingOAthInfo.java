package OAuth;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class GettingOAthInfo {

	@Test
	public void testScript() throws InterruptedException
	{
		///getting code
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://accounts.google.com/signin/oauth/identifier?client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&as=Ua87UVuq2vymCvIuQoXe7A&destination=https%3A%2F%2Frahulshettyacademy.com&approval_state=!ChRsNHBSbXBrYWVyWGFqUmlUWGpTchIfSTVOaFhwTFlVUjBZOEhuU1JuY2dubXBPZUhoYTlSWQ%E2%88%99AJDr988AAAAAXgr1OM35P-FkEWtND0BUfBgljn4d8pQt&oauthgdpr=1&xsrfsig=ChkAeAh8T_8MneZnl0Pko0BJjnhKQUO3lPicEg5hcHByb3ZhbF9zdGF0ZRILZGVzdGluYXRpb24SBXNvYWN1Eg9vYXV0aHJpc2t5c2NvcGU&flowName=GeneralOAuthFlow");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("chaithra.t.kota");
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("girija@1994");
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
	    Thread.sleep(3000);
	    String url = driver.getCurrentUrl();
	    System.out.println(url);
	    
		///getting access token using code
		        String  resp=given().
		          queryParams("code","").
		          queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		          queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W").
		          queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php").
		          queryParams("grant_type","authorization_code").
		          when().log().all().
		          get("https://www.googleapis.com/oauth2/v4/token").asString();   ///getting access token in the form of string
		        
		        JsonPath js=new JsonPath(resp);
		     String accesstoken = js.get("access_token");   ///getting access token in the form of json
		        System.out.println(accesstoken);
		        
		///Getting information using access token
		String response = given().
		queryParam("access_token", "").
		when().log().all().
		get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println( response);
	}
}

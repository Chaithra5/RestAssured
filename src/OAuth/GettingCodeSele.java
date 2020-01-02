package OAuth;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GettingCodeSele {

	public static void main(String[] args) throws InterruptedException {
//	@Test()
//	public void gettingCode() throws InterruptedException
//	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		 driver.get("https://demo.actitime.com/login.do");
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


	
	
	}
	

}

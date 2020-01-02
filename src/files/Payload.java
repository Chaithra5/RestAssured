package files;

public class Payload {

	public static String getpayLoad()
	{
		String b ="{\r\n" + 
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
				"}";
		return b;
		
	}
	
	public static String getAddBook(String isbn,String aisle)
	{
		String add="{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				" ";
		return add;
		
	}
}

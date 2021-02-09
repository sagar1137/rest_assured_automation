package getting_started;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class NewTest2 {
  
	@Test
	public void simple_get_test() {
		
		given().
			baseUri("https://restcountries.eu/rest/v2").
		when().
			get("/all").
		then().
			statusCode(201);
	}
}

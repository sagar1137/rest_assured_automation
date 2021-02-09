package getting_started;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NewTest1 {
  
	@Test
	public void simple_get_test() {
		
		given().
			baseUri("https://restcountries.eu/rest/v2").
		when().
			get("/all").
		then().
			statusCode(201);
	}
	
	@Test
	public void validate_json() {

		given().
			baseUri("https://restcountries.eu/rest/v2").
		when().
			get("/alpha/USA").
		then().
			statusCode(200).
			body(
					
				"name", equalTo("United States of America"),
				"alpha2Code",equalTo("US"),
				
				"altSpellings",hasItem("USA"),
				"languages[0].nativeName", equalTo("English")
				
				);
	}
}

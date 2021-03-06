

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Ignore;

public class NewTest1 {
  
	@Test(enabled = false) 
	public void simple_get_test() {
		
		given().
			baseUri("https://restcountries.eu/rest/v2").
		when().
			get("/all").
		then().
			statusCode(200);
	}
	
	@Test(enabled = false)
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
		
	@Test(enabled = false)
		public void validate_xml()
		{
			given().
			
				baseUri("http://api.openweathermap.org/data/2.5").
				
				
				queryParam("q", "London").
				queryParam("appid", "04b4c7762897d42b72199ac3ce2e02bb").
				queryParam("mode", "xml").
				
				when().
				get("/weather").
						
			
			then().
				statusCode(200).
						body(
					"current.city.@name",equalTo("London"),
					"current.city.country",equalTo("GB")
							);
		}
	
		@Test(enabled = false)
		public void extract_response_data() {
			Response response = given().

					baseUri("http://api.openweathermap.org/data/2.5").

					queryParam("q", "London").queryParam("appid", "04b4c7762897d42b72199ac3ce2e02bb")
					.queryParam("mode", "json").

					when().get("/weather").

					then().extract().response();

			System.out.println(response.asPrettyString());

		}
	
	@Test
	public void extract_single_value() {
	String cityName=	
given().
		
		baseUri("http://api.openweathermap.org/data/2.5").
		
		
		queryParam("q", "London").
		queryParam("appid", "04b4c7762897d42b72199ac3ce2e02bb").
		queryParam("mode", "xml").
		
		when().
		get("/weather").
		
		then().extract().path("current.city.@name");
		
<<<<<<< Upstream, based on origin/master
		System.out.println(response.asPrettyString());
		
		
		
=======
	System.out.println(cityName);
	
>>>>>>> 65b534a Extract Single Value
	}
	}

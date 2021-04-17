package sample;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class LogAll {

	
	@Test
	public void Validate_responseBody2() {
		given().baseUri("https://api.getpostman.com")
				.header("X-Api-Key", "PMAK-6074967126828e003512c5be-39f58b6fe2e02e7018ae9aecfd55112d1a").log().all()
				.when()
				.get("/workspaces").then().log().all().assertThat().statusCode(200).extract().response();

	
	}
}

package sample;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class BasicOperations {
	@Test
	public void Validate_getStatusCode() {
Response response=		given().baseUri("https://api.getpostman.com")
				.header("X-Api-Key", "PMAK-6074967126828e003512c5be-39f58b6fe2e02e7018ae9aecfd55112d1a").when()
				.get("/workspaces").then().log().all().assertThat().statusCode(200).extract().response();
System.out.println("Response is:"+response.asString());
	}

	@Test
	public void Validate_responseBody() {
		given().baseUri("https://api.getpostman.com")
				.header("X-Api-Key", "PMAK-6074967126828e003512c5be-39f58b6fe2e02e7018ae9aecfd55112d1a").when()
				.get("/workspaces").then().log().all().assertThat().statusCode(200).body("workspaces.name",
						hasItems("My Workspace", "Athira_workspace"), "workspaces[0].type",
						is(equalTo("personal")),"workspaces[0].type",
				equalTo("personal"),"workspaces.size",
				equalTo(2),"workspaces.name",
				hasItem("My Workspace"));
	}

}

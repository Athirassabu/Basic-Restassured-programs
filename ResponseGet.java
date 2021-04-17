package sample;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResponseGet {
	@Test
	public void Validate_getStatusCode() {
Response response=		given().baseUri("https://api.getpostman.com")
				.header("X-Api-Key", "PMAK-6074967126828e003512c5be-39f58b6fe2e02e7018ae9aecfd55112d1a").when()
				.get("/workspaces").then().log().all().assertThat().statusCode(200).extract().response();
JsonPath jsonPath=new JsonPath(response.asString());
//JsonPath.from(text)

System.out.println("Response is:"+jsonPath.getString("workspaces[0].name"));
System.out.println("Response is:"+response.asString());
System.out.println("Response is:"+response.path("workspaces[0].type"));
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
	//JsonPath.from(res).getString("workspaces[0].type");
//	System.out.println("Response is:"+JsonPath.from(res).getString("workspaces[0].type"));
	}
	
	@Test
	public void Validate_responseBody3() {
	String res=	given().baseUri("https://api.getpostman.com")
				.header("X-Api-Key", "PMAK-6074967126828e003512c5be-39f58b6fe2e02e7018ae9aecfd55112d1a").when()
				.get("/workspaces").then().log().all().assertThat().statusCode(200).extract().response().path("workspaces[0].type");
	//JsonPath.from(res).getString("workspaces[0].type");
	System.out.println("Response is:"+res);
	}
	@Test
	public void Validate_responseBody2() {
	String res=	given().baseUri("https://api.getpostman.com")
				.header("X-Api-Key", "PMAK-6074967126828e003512c5be-39f58b6fe2e02e7018ae9aecfd55112d1a").when()
				.get("/workspaces").then().log().all().assertThat().statusCode(200).extract().response().asString();
	//JsonPath.from(res).getString("workspaces[0].type");
JsonPath.from(res).getString("workspaces[0].type");
System.out.println("Response is:"+JsonPath.from(res).getString("workspaces[0].type"));
	System.out.println("Response is:"+res);
	}
}

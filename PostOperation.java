package sample;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class PostOperation{
	
	
@BeforeClass
public void beforeclass()
{
	RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder()
			.setBaseUri("https://api.getpostman.com")
			.addHeader("X-Api-Key","PMAK-6074967126828e003512c5be-39f58b6fe2e02e7018ae9aecfd55112d1a")
			.setContentType(ContentType.JSON)
			.log(LogDetail.ALL);
	RestAssured.requestSpecification=requestSpecBuilder.build();
	ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder()
			.expectStatusCode(200)
			.expectContentType(ContentType.JSON)
			.log(LogDetail.ALL);
	RestAssured.responseSpecification=responseSpecBuilder.build();
	
}
//given(requestSpecification) can be used
	@Test
	public void Validate_getStatusCode() {
given()
.when()
.get("/workspaces")
.then();
	}

	

}

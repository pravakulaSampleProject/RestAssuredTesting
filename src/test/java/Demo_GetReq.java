import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Demo_GetReq {

	@Test
	void getSpaceXdateDetails() {
		
		RestAssured.baseURI ="https://api.spacexdata.com/v4/launches/latest";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET);
		
		
		//Print response in console
		String resBody = response.getBody().asString();
		System.out.println("Respone Body Is:" +resBody);
		
		//status Code validation
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200);
		System.out.println("Status Code is:" + status);
		
		//status line
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		
		//SuccessCode
		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println(successCode);
		
		//verify flight number
		JsonPath  path = response.jsonPath();
		System.out.println(path.get("flight_number"));
		System.out.println(path.get("name"));
		System.out.println(path.get("date_utc"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

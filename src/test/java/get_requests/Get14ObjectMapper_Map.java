package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;


import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper_Map extends JsonplaceholderBaseUrl {
      /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */
    @Test
    public void get14Map(){
        //Set the Url
        spec.pathParams("first","todos","second",198);

        //Set the expected data

       String expectedDataInstring= new JsonPlaceHolderTestData().expectedDataInString(10,"quis eius est sint explicabo",true);

        Map<String,Object>expectedData= ObjectMapperUtils.convertJsonToJava(expectedDataInstring,Map.class);

        System.out.println("expectedData = " + expectedData);
//Send the Request and the response data

        Response response=given().spec(spec).when().get("/{first}/{second}");
response.prettyPrint();

//Do assertion

Map actualsData= ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);
assertEquals(200,response.getStatusCode());
assertEquals(expectedData.get("userId"),actualsData.get("userId"));
assertEquals(expectedData.get("title"),actualsData.get("title"));
assertEquals(expectedData.get("completed"),actualsData.get("completed"));


    }
}
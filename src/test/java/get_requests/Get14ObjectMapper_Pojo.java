package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
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

    //ObjectMapper + Pojo = En İyi Yöntem
    @Test
    public void get14Pojo(){

        //Set the Url
        spec.pathParams("first","todos","second",198);

        //Set the Expected Data


        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(10,"quis eius est sint explicabo",true);


        //Send the request and the response


        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

//Do Assertion

JsonPlaceHolderPojo actualDats= ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);

assertEquals(200,response.getStatusCode());
assertEquals(expectedData.getTitle(),actualDats.getTitle());
assertEquals(expectedData.getUserId(),actualDats.getUserId());
assertEquals(expectedData.getCompleted(),actualDats.getCompleted());








    }
}
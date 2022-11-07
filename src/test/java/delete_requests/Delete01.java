package delete_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjecMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01 extends JsonplaceholderBaseUrl {
      /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01() {
        //Set the Url
        spec.pathParams("first", "todos", "second", 198);

        //Set the expected data

        Map<String, String> expectedData = new HashMap<>();
//Send the request and the response

        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();


//Do Assertion

        Map<String, Object> actualData = ObjecMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.getStatusCode());
//1.yol
        assertEquals(expectedData, actualData);
        //2.yol
        assertTrue(actualData.isEmpty());

        //3.yol

        assertEquals(0, actualData.size());

    }
}
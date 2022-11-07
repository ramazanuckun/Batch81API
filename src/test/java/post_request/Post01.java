package post_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonplaceholderBaseUrl {


/*
    Given
      1)  https://jsonplaceholder.typicode.com/todos
      2{
    "userId": 155,
    "title": "ramazan rahmi uckun",
    "completed": true,
    "id": 201
}
   When
    I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/

    @Test
    public void post01() {

        //Set the url

        spec.pathParam("first","todos");

        //Set the expected Data

        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();

   Map<String,Object>expectedData=     obj.expectedDataMethod(55,"Tidy your room",false);


   //set the request and the response

        //postmanda ne yapiyorsam burada onu yaptim otel icin post diyerek yeni bir kullanici olustrdum


      Response response= given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
   response.prettyPrint();
   //Do aseertion


        Map<String,Object>actualData=response.as(HashMap.class);


        assertEquals(expectedData.get("completed"),actualData.get("completed"));

        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));














    }
}

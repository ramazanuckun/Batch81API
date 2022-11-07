package post_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjecMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
         /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
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
    public void post05ObjeMapper() {

        //Set the url

        spec.pathParam("first","todos");

        //Set the expected data


        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);
        //Send the tequest and get the response


        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

//Do assertion

     JsonPlaceHolderPojo actualData=   ObjecMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
assertEquals(201,response.getStatusCode());
assertEquals(expectedData.getUserId(),actualData.getUserId());
assertEquals(expectedData.getCompleted(),actualData.getCompleted());
assertEquals(expectedData.getTitle(),actualData.getTitle());

    }
}
package post_request;

import base_urls.JsonplaceholderBaseUrl;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

public class Post01 extends JsonplaceholderBaseUrl {


/*
    Given
      1)  https://jsonplaceholder.typicode.com/todos
      2)  {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
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


   //Do aseertion















    }
}

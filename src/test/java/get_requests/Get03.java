package get_requests;


import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class Get03 extends JsonplaceholderBaseUrl {

 /*
      Given            base Url                  1    2
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
And
    "completed" is false
And
    "userId" is 2
   */

    @Test
    public void get01() {


        //Set The Url

        spec.pathParams("first","todos","second",23);

        //Expected Data

        //Send The Request and Get Responce
//1.yol hard assert hard assert=herhangi bir yerde hata verirse durur buna hard assert
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();//ayrintili getirir

        //Do assertion

        response.then().assertThat().statusCode(200).contentType("application/json").
            body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed",equalTo(false))
                .body("userId",equalTo(2));
//2.yol  sadece body icerisinde gecerli bir soft assert   hata olursada kod tamami calisir hatayi bildirir soft assert

        response.then()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),"userId",equalTo(2));


    }



}

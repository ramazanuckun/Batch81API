package homeCalisma;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class home_01 {

    @Test
    public void name01() {

        //  i)  Set the URL,

        String url="https://restful-booker.herokuapp.com/booking/101";
        // ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)

        // iii) Type code to send request ( Talep gondermek icin kod yazimi)

        Response response=given().when().get(url);
        response.prettyPrint();

        // iv) Do Assertion (dogrulama yapmak)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
        // Status Code konsola yazdiralim
        System.out.println("status code="+response.getStatusCode());
        // Content Type konsola yazdiralim
        System.out.println("content="+response.getContentType());
        //header consola yazdiralim
        System.out.println("header="+response.getHeader("Server"));
        //headers
        System.out.println("headers="+response.getHeaders());
        //time
        System.out.println("time="+response.getTime());
    }

    @Test
    public void name02() {
        //  i)  Set the URL,

        String url="https://restful-booker.herokuapp.com/booking/101";
        // ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)

        // iii) Type code to send request ( Talep gondermek icin kod yazimi)

        Response response=given().when().get(url);
        response.prettyPrint();


        // iv) Do Assertion (dogrulama yapmak)
       // response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

    }
}

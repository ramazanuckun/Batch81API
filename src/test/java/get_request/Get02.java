package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {

   /*
    * Given
    https://restful-booker.herokuapp.com/booking/1
    When
    User send a GET Request to the url
    Then
    HTTP Status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found
    And
    Response body contains "Not Found"
    And
    Response body does not contain "TechProEd"
    And
    Server is "Cowboy"
            */

    @Test
    public void get02(){

        //i-set the url
        String url="https://restful-booker.herokuapp.com/booking/1";
        //  ii-set the expected data (beklenene datanin olusturlmasi,post,put,patch)


        //  iii-Type code ro send reguest(talep gondermek icin kod yazimi)

        Response response = given().when().get(url);

        response.prettyPrint();

        //  iv-Do Assertion(dogrulama yazimi)

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
//Body Not found iceriyormu test yapiliyor
assertTrue(response.asString().contains("Not Found"));
//Body Techproed icermedigi testi yapiliyor
assertFalse(response.asString().contains("TechProEd"));
//Server in covboy olmadigini test ediyoruz
assertEquals("Cowboy",response.getHeader("Server"));



    }


}

package homeCalisma;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class home_02 {
    @Test
    public void name() {

        //i-set the url
        String url="https://restful-booker.herokuapp.com/booking/1";
        //  ii-set the expected data (beklenene datanin olusturlmasi,post,put,patch)


        //  iii-Type code ro send reguest(talep gondermek icin kod yazimi)

        Response response = given().when().get(url);

        response.prettyPrint();
response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

assertTrue(response.asString().contains("Not Found"));

assertFalse(response.asString().contains("TechProEd"));

assertEquals("Cowboy",response.getHeader("Server"));


    }
}

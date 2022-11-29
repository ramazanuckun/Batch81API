package delete_Requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDeletePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyRestApiBaseUrl {


    /*
     URL: https://dummy.restapiexample.com/api/v1/delete/2
     HTTP Request Method: DELETE Request
     Test Case: Type by using Gherkin Language
     Assert:     i) Status code is 200
                 ii) "status" is "success"
                 iii) "data" is "2"
                 iv) "message" is "Successfully! Record has been deleted"
       */

    /*
    Given
         URL: https://dummy.restapiexample.com/api/v1/delete/2
         When
          HTTP Request Method: DELETE Request
         Then
             i) Status code is 200
             And
                 ii) "status" is "success"
                And
                 iii) "data" is "2"
                And
                 iv) "message" is "Successfully! Record has been deleted"


     */

    @Test
    public void delete02() {
spec.pathParams("first","delete","second",2);
        DummyDeletePojo expectedData=new DummyDeletePojo("success","2","Successfully! Record has been deleted");
        System.out.println("expectedData = " + expectedData);
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).delete("/{first}/{second}");
    response.prettyPrint();
    DummyDeletePojo actualData=    ObjectMapperUtils.convertJsonToJava(response.asString(),DummyDeletePojo.class);
        System.out.println("actualData = " + actualData);

assertEquals(200,response.getStatusCode());
assertEquals(expectedData.getData(),actualData.getData());
assertEquals(expectedData.getMessage(),actualData.getMessage());
assertEquals(expectedData.getMessage(),actualData.getMessage());



    }
}

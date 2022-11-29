package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get17 extends DummyRestApiBaseUrl {

    /*
    Given
        URL: https://dummy.restapiexample.com/api/v1/employee/1
    When
        User sends GET Request
    Then
        Status code is 200
    And
        "employee_name" is "Tiger Nixon"
    And
        "employee_salary" is 320800
    And
        "employee_age" is 61
    And
        "status" is "success"
    And
        "message" is "Successfully! Record has been fetched."
     */

    @Test
    public void get17() {

        spec.pathParams("first","employee","second",1);
        DummyRestApiDataPojo expected=new DummyRestApiDataPojo("Tiger Nixon",320800,61,"");
        System.out.println("expected = " + expected);
        DummyRestApiResponseBodyPojo expectedData=new DummyRestApiResponseBodyPojo("success",expected,"Successfully! Record has been fetched.");
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

      DummyRestApiResponseBodyPojo actualData=  ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiResponseBodyPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals(expected.getProfile_image(),actualData.getData().getProfile_image());
        assertEquals(expected.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expected.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expected.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expectedData.getMessage(),actualData.getMessage());
        assertEquals(expectedData.getStatus(),actualData.getStatus());




    }
}

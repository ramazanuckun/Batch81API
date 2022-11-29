package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15 extends RestfulBaseUrl {
//pojo class ve opje mapper ile yapalim
    /*
        Given
	            https://restful-booker.herokuapp.com/booking/
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
         {
    "firstname": "Guoqiang",
    "lastname": "Morante Briones",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */
    @Test
    public void get15(){

//Set the url

        spec.pathParams("first","booking","second",22);

        //Set the expected

        BookingDatesPojo obj=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("Guoqiang","Morante Briones",111,true,obj,"Breakfast");
        System.out.println("expectedData = " + expectedData);

//Send Request and the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
      //  response.prettyPrint();


//Do assertion
//1.yol pojo ile
        //BookingPojo actualData=response.as(BookingPojo.class);
        //2.yol obje mapper ile
        BookingPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),BookingPojo.class);

        System.out.println("actualData = " + actualData);

        //Soft Asserrtion  bunun farki once actual sonra expected ve sonuna mesaj yazilabilir

        //1.adim obje olustr
        SoftAssert softAssert=new SoftAssert();
        //2.adim Assertion yap

        softAssert.assertEquals(actualData.getFirstname(),expectedData.getLastname(),"hata var firstname");
        softAssert.assertEquals(actualData.getLastname(),expectedData.getLastname(),"hata var lastname");
        softAssert.assertEquals(actualData.getTotalprice(),expectedData.getTotalprice(),"hata var totalprice");
        softAssert.assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid(),"hata var depositpoid");
        softAssert.assertEquals(actualData.getAdditionalneeds(),actualData.getAdditionalneeds(),"hata var Addinoal");
        softAssert.assertEquals(actualData.getBookingdates().getCheckin(),obj.getCheckin(),"hata var checkin");
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(),obj.getCheckout(),"hata var checkout");

        //3.adim asserAll methodu kullan




//Hard Assertion
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());

/*
assertEquals(obj.getCheckin(),actualData.getBookingdates().getCheckin());
assertEquals(obj.getCheckout(),actualData.getBookingdates().getCheckin());

bu da olur bir kod eksik ===>      assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
 */
        softAssert.assertAll();

    }
}

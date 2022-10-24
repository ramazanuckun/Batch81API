import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
    1-Postman ,manuel API testleri icin kullandik
    2-Otomasyon testleri icin de Rest Assured Library kullanancagiz
    3-Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz
        a-Gereksimleri anlamak
        b-Test case yaziyoruz
            i-Test Case yaziminda "Gherkin" dilini kullaniyoruz(Karsi tarafin ne yaptigimini
            anlamasi icin gerkin dilini kullaniyoruz.Bizler yazilim diline hakim olsakta karsimizdaki  kisiler hakim olmayabilir.
            Ama gerkin ile yazilan testleri anlamakta zorluk cekmezler.Gerkin dilinde kullanacagimiz keywordlaer)
            -Given=On kosullar
            -When=Yapilacak aksiyonlar ici n kullanacagiz(get(),Put(),post(),patch(), ve delete())
            -Then=Istek yaptiktan sonra dogrulama(reguest gonderdikten sonra)
            And=Coklu islemlerde kullanacagiz
        c-Test kodlarimizi yazmaya baslayacagiz

           i-Set the url
           ii-set the expected data (beklenene datanin olusturlmasi,post,put,patch)
           iii-Type code ro send reguest(talep gondermek icin kod yazimi)
           iv-Do Assertion(dogrulama yazimi)
     */



    /*
Given
        https://restful-booker.herokuapp.com/booking/101
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
 */


    @Test
    public void get01() {


//i-set the url
        String url="https://restful-booker.herokuapp.com/booking/101";
      //  ii-set the expected data (beklenene datanin olusturlmasi,post,put,patch)
      //  iii-Type code ro send reguest(talep gondermek icin kod yazimi)

 Response response= given().when().get(url);// Response=cevap

response.prettyPrint();
      //  iv-Do Assertion(dogrulama yazimi)


        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

    }
}



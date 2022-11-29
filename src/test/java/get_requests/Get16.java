package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get16 extends DummyRestApiBaseUrl {
/*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
"                   ii) There are 24 employees"
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */
/*
Gıven
URL: https://dummy.restapiexample.com/api/v1/employees
When
User Sends get request
Then
 i) Status code is 200
               And
                   ii) There are 24 employees
              And
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
               And


               And
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                And
                   vi) Total salary of all employees is 6,644,770

 */





    @Test
    public void get16() {

  spec.pathParam("first","employees");
  //mumkun oldugunca sade olmasi lazim
        //2.adim yok
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //       ii) There are 24 employees, iii) "Tiger Nixon" and "Garrett Winters" are among the employees
response.then().assertThat().body("data.id",hasSize(24),"data.employee_name",hasItems("Garrett Winters"));
//Not body methodunda disariya datayi alamiyorum onun icin jsonPath kullaniyorum
       // v) The name of the lowest age is "Tatyana Fitzpatrick" tum yaslari alirim

   List<Integer>ages= response.jsonPath().getList("data.employee_age");
        System.out.println(ages);//yaslari aldi
        Collections.sort(ages);
        System.out.println(" Sorted ages = " + ages);//yaslari siralar list immutabledir
        System.out.println(ages.get(ages.size()-1));
        assertEquals(66,(int)ages.get(ages.size()-1));//datalar arasi fark old. icin int==INteger uydurduk

       // v) The name of the lowest age is "Tatyana Fitzpatrick"
       // response.jsonPath().getString("data.findAll{it.employee_age==19}.employee_name");dinamik degil 19 degisebilir
    String lowestAgeEmployee=    response.jsonPath().getString("data.findAll{it.employee_age=="+ages.get(0)+"}.employee_name");

        System.out.println("lowestAgeEmployee = " + lowestAgeEmployee);
        //        vi) Total salary of all employees is 6,644,770

        List<Integer>salaries=response.jsonPath().getList("data.employee_salary");
        System.out.println("salaries = " + salaries);
//1.yol

     int sumlambda=   salaries.stream().reduce(0,(t,u)->t+u);//reduce sayiyi azaltma methodu idi lambdada
        System.out.println("sumlambda = " + sumlambda);
//2.yol
        int sumlamda1=   salaries.stream().reduce(0,Integer::sum);//reduce sayiyi azaltma methodu idi lambdada
        System.out.println("sumlamda1 = " + sumlamda1);
        //3.yol
        int sumlamda2=   salaries.stream().reduce(0,Math::addExact);//reduce sayiyi azaltma methodu idi lambdada
        System.out.println("sumlamda2 = " + sumlamda2);

//4.yol


        int sum=0;
        for (int w:salaries
             ) {
            sum+=w;
        }
        System.out.println("sum = " + sum);
        assertEquals(6644770,sum);
    }
}

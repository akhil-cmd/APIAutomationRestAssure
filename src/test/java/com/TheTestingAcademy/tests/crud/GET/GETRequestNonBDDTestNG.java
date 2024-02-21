package com.TheTestingAcademy.tests.crud.GET;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETRequestNonBDDTestNG {

    @Test
    public void testGetAllBookingPositive(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/5566");
        r.when().get();
        r.then().log().all().statusCode(200);
    }

    @Test
    public void testGetAllBookingNegative(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1");
        r.when().get();

        r.then().log().all().statusCode(404);
    }

    @Test
    public void testGetAllBookingNegative2(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/abc");
        r.when().get();

        r.then().log().all().statusCode(404);
    }



}

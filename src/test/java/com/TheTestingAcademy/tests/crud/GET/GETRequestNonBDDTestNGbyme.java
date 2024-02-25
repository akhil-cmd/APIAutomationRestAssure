package com.TheTestingAcademy.tests.crud.GET;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETRequestNonBDDTestNGbyme {

    @Test
    public void testGetAllBookingPositive(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/5566").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);
    }

    @Test
    public void testGetAllBookingNegative(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when().get();

        r.then().log().all().statusCode(404);
    }

    @Test
    public void testGetAllBookingNegative2(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/abc").log().all();
        r.when().get();

        r.then().log().all().statusCode(404);
    }



}

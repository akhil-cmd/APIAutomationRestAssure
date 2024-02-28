package com.TheTestingAcademy.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test002 {

    RequestSpecification r;
    String token;


    @BeforeTest
    public void getToken(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        Response response = r.when().post();

        ValidatableResponse validatableResponse = response.then().log().all();
        String responseString = response.asString();
        System.out.println("Getting Token" + responseString);

        validatableResponse.body("token", Matchers.notNullValue());
        token = response.then().log().all().extract().path(token);

        Assert.assertNotNull(token);    // same as line 40
        System.out.println(token);




    }

    @Test
    public void testNonBDDStylePUTReq(){


        String jsonString = "{\r\n" + "    \"firstname\" : \"Akhil\",\r\n" + "    \"lastname\" : \"Cineha\",\r\n"
                + "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
                + "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
                + "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";


        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2576");


        r.contentType(ContentType.JSON);
        r.cookie("token", token);

        r.body(jsonString);

        Response response = r.when().put();
        System.out.println(response.asString());
        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Akhil"));
        validatableResponse.body("lastname", Matchers.equalTo("Cineha"));

    }
}

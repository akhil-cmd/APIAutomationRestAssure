package com.TheTestingAcademy.tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDStylePost {

    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    @Test
    public void testBDDStylePositive(){

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth").contentType(ContentType.JSON).log().all()

                .body(payload).when().post().then().log().all().statusCode(200);

    }
}

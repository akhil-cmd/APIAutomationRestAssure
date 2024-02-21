package com.TheTestingAcademy.tests.crud.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {
    public static void main(String[] args) {

        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/124001")

                .when().log().all()

                .get()

                .then().log().all().statusCode(200);
    }
}

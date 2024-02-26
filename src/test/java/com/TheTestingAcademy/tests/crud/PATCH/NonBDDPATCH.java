package com.TheTestingAcademy.tests.crud.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPATCH {


    @Test
    public void testPATCHRequest(){

        String token = "a6249eceaba21f2";

        String payload = "{\n" +
                "    \"firstname\" : \"Zim\",\n" +
                "    \"lastname\" : \"Leons\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/747");
        r.contentType(ContentType.JSON);
        r.cookie("token", token);

        r.body(payload).log().all();

        Response response = r.when().patch();
        ValidatableResponse validatableResponse = response.then().log().all();
        //String reponseString = response.asString();
        //System.out.println(reponseString);

        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Akhil"));
        validatableResponse.body("lastname", Matchers.equalTo("James"));





    }


}

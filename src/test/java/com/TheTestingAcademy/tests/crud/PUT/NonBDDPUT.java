package com.TheTestingAcademy.tests.crud.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPUT {



    @Test
    public void testPUTRequest(){

        String token = "5e4d81755213d97";

        String payload = "{\n" +
                "    \"firstname\" : \"Akhil\",\n" +
                "    \"lastname\" : \"James\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/387");
        r.contentType(ContentType.JSON);
        r.cookie("token", token);

        r.body(payload).log().all();

        Response response = r.when().put();
        ValidatableResponse validatableResponse = response.then().log().all();
        //String reponseString = response.asString();
        //System.out.println(reponseString);

        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Akhil"));
        validatableResponse.body("lastname", Matchers.equalTo("James"));





    }


}

package com.TheTestingAcademy.tests.crud.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDDELETE {


    @Test
    public void testDELTERequest(){

        String token = "a6249eceaba21f2";


        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/747");
        r.contentType(ContentType.JSON);
        r.cookie("token", token);


        Response response = r.when().delete();
        ValidatableResponse validatableResponse = response.then().log().all();
        //String reponseString = response.asString();
        //System.out.println(reponseString);

        validatableResponse.statusCode(404);





    }


}

package com.TheTestingAcademy.misc.gson;

import com.TheTestingAcademy.misc.gson.example.BookingResponse;
import com.TheTestingAcademy.misc.gson.example.Employee;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class PostReqTC {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPositive(){

        Booking booking = new Booking();

        booking.setFirstname("Akhil");
        booking.setLastname("John");
        booking.setTotalprice(685);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-02-05");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println("Booking Details " + booking);

        // Object to Json

        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println("Converted Object to Json " + jsonStringBooking);


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Json to Object

        BookingResponse bookingResponseObject = gson.fromJson(jsonResponseString, BookingResponse.class);

        assertThat(bookingResponseObject.getBookingid()).isNotNull();

        assertThat(bookingResponseObject.getBooking().getFirstname()).isEqualTo("Akhil");
        assertThat(bookingResponseObject.getBooking().getLastname()).isEqualTo("John");

       // Assert.assertEquals(bookingResponseObject.getFirstname(), "Akhil");
        //Assert.assertEquals(bookingResponseObject.getLastname(), "John");

        // Get Validatable response to perform validation


    }
}

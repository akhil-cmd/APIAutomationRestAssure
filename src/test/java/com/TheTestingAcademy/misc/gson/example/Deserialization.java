package com.TheTestingAcademy.misc.gson.example;

import com.google.gson.Gson;
import org.testng.Assert;

public class Deserialization {

    String jsonString = "{\r\n" + "  \"firstName\" : \"Akhil\",\r\n" + "  \"lastName\" : \"John\",\r\n"
            + "  \"gender\" : \"M\",\r\n" + "  \"age\" : 23,\r\n" + "  \"salary\" : 3422.33,\r\n"
            + "  \"married\" : false\r\n" + "}";

    Gson gson = new Gson();
    Employee employeeObject = gson.fromJson(jsonString, Employee.class);

    String firstName = employeeObject.getFirstname();
    String lastName = employeeObject.getLastname();






}

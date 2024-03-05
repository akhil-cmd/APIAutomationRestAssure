package com.TheTestingAcademy.misc.gson.example;

import com.google.gson.Gson;
import org.testng.annotations.Test;

public class Simpleser {

//    {
//        "firstname" : "Jim",
//            "lastname" : "Brown",
//            "age" : 21,
//            "gender" : M,
//            "salary" : 500.00
//    }


    @Test
    public void test1(){

        Employee employeeObject = new Employee();

        employeeObject.setFirstname("Akhil");
        employeeObject.setLastname("John");
        employeeObject.setAge(21);
        employeeObject.setGender("Male");
        employeeObject.setSalary(500.00);


        Gson gson = new Gson();
        String jsonEmployee = gson.toJson(employeeObject);
        System.out.println(jsonEmployee);
    }
}



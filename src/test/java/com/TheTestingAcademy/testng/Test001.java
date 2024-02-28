package com.TheTestingAcademy.testng;

import org.testng.annotations.*;

public class Test001 {

    @BeforeSuite
    void Demo1(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    void Demo2(){
        System.out.println("Before Test");
    }

    @BeforeClass
    void Demo3(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    void Demo4(){
        System.out.println("Before");
    }

    @Test
    void Demo5(){
        System.out.println("test");
    }

    @AfterMethod
    void Demo6(){
        System.out.println("After");
    }

    @AfterClass
    void Demo7(){
        System.out.println("After Class");
    }

    @AfterTest
    void Demo8(){
        System.out.println("After Test");
    }

    @AfterSuite
    void Demo9(){
        System.out.println("After Suite");
    }

}

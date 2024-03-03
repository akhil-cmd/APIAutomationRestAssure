package com.TheTestingAcademy.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test013 {

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password12"},
                new Object[]{"admin", "password123"}
        };
    }


    @Test(dataProvider = "getData")
    public void loginTest(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }
}

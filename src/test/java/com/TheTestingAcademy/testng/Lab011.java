package com.TheTestingAcademy.testng;
import org.testng.annotations.Test;

public class Lab011 {

        @Test(groups = { "init" })
        public void getToken() {
            System.out.println("serverStartedOk");
        }

        @Test(groups = { "init" })
        public void getBookingID() {
            System.out.println("initEnvironment");
        }


        @Test(dependsOnGroups = { "init.*" })
        public void testPutReq() {
            System.out.println("Now I will run");
        }
    }

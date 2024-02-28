package com.TheTestingAcademy.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test007 {

    @Test(groups = {"sanity", "QA"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
    }

    @Test(groups = {"sanity", "reg", "e2e"})
    public void RegRun(){
        System.out.println("Reg");
    }

    @Test(groups = {"sanity", "Smoke", "Dev"})
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}

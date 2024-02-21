package com.TheTestingAcademy.bpdemo;

public class BuilderPatternDesign {
    public BuilderPatternDesign stage1(){
        System.out.println("Stage 1");
        return this;
    }

    public BuilderPatternDesign stage2(String str){
        System.out.println("Stage 2 " + str);
        return this;
    }

    public BuilderPatternDesign stage3(){
        System.out.println("Stage 3");
        return this;
    }

    public static void main(String[] args) {
        BuilderPatternDesign bp = new BuilderPatternDesign();
        bp.stage1().stage2("test").stage3();
    }


}

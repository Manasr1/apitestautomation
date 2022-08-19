package com.test.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.reflect.Method;

public final class ExtentReport {

    private static ExtentSparkReporter spark;
    private static ExtentReports extent;

    private static ExtentTest test;// not thread safe

    private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

    private ExtentReport(){}

    public static ExtentTest getTest() {
        return exTest.get();
    }

    public static void setExtent(ExtentTest test)
    {
        exTest.set(test);
    }

    public static void initReport(){
        spark = new ExtentSparkReporter("index.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static void teardownReport(){
       extent.flush();
    }

    public static void createTest(String name){
        test = extent.createTest(name);
        ExtentManager.setExtent(test);
    }

    public static void addAuthor(String[] authors){
        for(String author: authors){
            ExtentManager.getTest().assignAuthor(author);
        }
    }

    public static void addCategory(String[] categories){
        for(String category: categories){
            ExtentManager.getTest().assignCategory(category);
        }
    }
}

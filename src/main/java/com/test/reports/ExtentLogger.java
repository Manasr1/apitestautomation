package com.test.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;
import io.restassured.internal.SpecificationMerger;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){

        ExtentManager.getTest().pass(message);
    }

    public static void fail(String message){

        ExtentManager.getTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void info(String message){

        ExtentManager.getTest().info(MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void logResponse(String message){
        ExtentManager.getTest().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    }

    public static void logRequest(RequestSpecification requestSpecification){
        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
        info("request details");
        info(query.getBody());
        for(Header header : query.getHeaders()){
                info(header.getName()+":"+header.getValue());
        }
    }

}

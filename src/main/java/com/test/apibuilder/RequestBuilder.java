package com.test.apibuilder;

import com.test.enums.PropertiesType;
import com.test.utils.PropertyUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class RequestBuilder {

    public static RequestSpecification buildGetRequest(){
        return given()
                .log()
                .all()
                .baseUri(PropertyUtils.readValue(PropertiesType.BASEURL));
    }

    public static RequestSpecification buildPOSTRequest(){
        return given()
                .header("Content-Type", ContentType.JSON)
                .log()
                .all()
                .baseUri(PropertyUtils.readValue(PropertiesType.BASEURL));
    }

    public static RequestSpecification buildRequest1(){
        return given()
                .header("Content-Type", ContentType.JSON)
                .log()
                .all()
                .baseUri(PropertyUtils.readValue(PropertiesType.BASEURL1));
    }



}

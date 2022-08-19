package com.test.tests;

import com.test.annotations.FrameworkAnnotations;
import com.test.apibuilder.RequestBuilder;
import com.test.reports.ExtentLogger;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GetTests extends BaseTest{

    @FrameworkAnnotations(author = {"Manas","Ram"},category={"smoke","regression"})
    @Test
    public void getTravellerDetails()  {

       Response response = RequestBuilder.buildGetRequest()
                .get("/booking");

        ExtentLogger.logResponse(response.asPrettyString());

       assertThat(response.getStatusCode())
                .as("validating response code")
                .isEqualTo(200);

       JSONArray jsonarray = new JSONArray(response.prettyPrint());
        assertThat(jsonarray)
                .as("validate response size")
                .hasSizeGreaterThan(1);
    }

    @FrameworkAnnotations(author = {"Manas"},category={"getCall"})
    @Test(dataProvider = "getData")
    public void getPhotoDetails(Integer id,Integer albumId) {
        Response response = RequestBuilder.buildRequest1()
                .pathParam("id",id)
                .get("/photos/{id}");

        ExtentLogger.logResponse(response.asPrettyString());

        assertThat(response.getStatusCode())
                .as("validating response code")
                .isEqualTo(200);

        JSONObject jsonobject = new JSONObject(response.asString());
        assertThat(jsonobject.get("albumId"))
                .as("validate albumId")
                .isEqualTo(albumId);
    }

    @FrameworkAnnotations(author = {"Ram"},category={"smoke"})
    @Test(dataProvider = "getData1")
    public void getPhotoDetailsUsingDataProvider(Map<String,Integer> data) {
        Response response = RequestBuilder.buildRequest1()
                .pathParam("id",data.get("id"))
                .get("/photos/{id}");

        ExtentLogger.logResponse(response.asPrettyString());

        assertThat(response.getStatusCode())
                .as("validating response code")
                .isEqualTo(200);

        JSONObject jsonobject = new JSONObject(response.asString());
        assertThat(jsonobject.get("albumId"))
                .as("validate albumId")
                .isEqualTo(data.get("albumId"));
    }

    @DataProvider
    public Object[][] getData1(){

        Object[][] data = new Object[3][1];

        Map<String,Integer> map1 = new HashMap<>();

        map1.put("id",1);
        map1.put("albumId",1);

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("id",2);
        map2.put("albumId",1);

        Map<String,Integer> map3 = new HashMap<>();
        map3.put("id",3);
        map3.put("albumId",1);

        data[0][0] = map1;
        data[1][0] = map2;
        data[2][0] = map3;

        return data;
    }

    @DataProvider
    public Object[][] getData(){

        return new Object[][] {
                {1,1},
                {2,1},
                {3,1}
        };

    }
}

package com.test.tests;

import com.test.annotations.FrameworkAnnotations;
import com.test.constants.FrameworkConstants;
import com.test.pojo.BookingDates;
import com.test.pojo.BuildTraveller;
import com.test.reports.ExtentLogger;
import com.test.utils.FileUtils;
import com.test.utils.RandomUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.ZoneId;

import static com.test.apibuilder.RequestBuilder.buildPOSTRequest;
import static com.test.utils.RandomUtils.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PostTest extends BaseTest {

    @FrameworkAnnotations(author = {"Manas"}, category = {"postCall"})
    @Test
    public void bookTicketTest() {

        BookingDates bookingDate = BookingDates.builder()
                .setCheckin(String.valueOf(LocalDate.now(ZoneId.systemDefault()).plusDays(3)))
                .setCheckout(String.valueOf(LocalDate.now(ZoneId.systemDefault()).plusDays(5)))
                .build();

        BuildTraveller createBooking = BuildTraveller
                .builder()
                .setFirstname(getFirstName())
                .setLastname(getLastName())
                .setTotalprice(getPrice())
                .setBookingdates(bookingDate)
                .setAdditionalneeds(getAdditionalNeed())
                .build();


        RequestSpecification requestSpecification = buildPOSTRequest()
                .body(createBooking);
        ExtentLogger.logRequest(requestSpecification);
        Response response = requestSpecification.post("/booking");

        ExtentLogger.logResponse(response.asPrettyString());

        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @FrameworkAnnotations(author = {"Manas"}, category = {"postCall"})
    @Test
    public void bookTicketUsingJSONFile(Method method) {
        String resource = FileUtils.readJSONAndConvertIntoString
                (FrameworkConstants.getRequestJsonFolderPath() + "request.json");
        resource
                .replace("firstname", RandomUtils.getFirstName())
                .replace("lastname", RandomUtils.getLastName())
                .replace("additionalneeds", RandomUtils.getAdditionalNeed())
                .replace("totalprice", String.valueOf(RandomUtils.getPrice()));

        Response response = buildPOSTRequest().body(resource).post("/booking");
        ExtentLogger.logResponse(response.asPrettyString());

        FileUtils.writeBytesArrayToJSON
                (FrameworkConstants.getResponseJsonFolderPath() + method.getName() + "response.json", response);

        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @FrameworkAnnotations(author = {"Ram"}, category = {"regression"})
    @Test
    public void bookTicketUsingJSONFile1(Method method) {
        String resource = FileUtils.readJSONAndConvertIntoString
                (FrameworkConstants.getRequestJsonFolderPath() + "request.json");
        resource
                .replace("firstname", RandomUtils.getFirstName())
                .replace("lastname", RandomUtils.getLastName())
                .replace("additionalneeds", RandomUtils.getAdditionalNeed())
                .replace("totalprice", String.valueOf(RandomUtils.getPrice()));

        Response response = buildPOSTRequest().body(resource).post("/booking");
        ExtentLogger.logResponse(response.asPrettyString());

        FileUtils.writeBytesArrayToJSON
                (FrameworkConstants.getResponseJsonFolderPath() + method.getName() + "response.json", response);

        assertThat(response.getStatusCode()).isEqualTo(200);
    }
}

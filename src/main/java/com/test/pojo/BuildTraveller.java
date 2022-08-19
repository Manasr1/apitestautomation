package com.test.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class BuildTraveller {
    private String firstname;
    private String lastname;
    private Double totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

}


package com.test.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(setterPrefix = "set")
@Getter
public class BookingDates {
    private String checkin;
    private String checkout;
}

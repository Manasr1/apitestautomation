package com.test.utils;

public final class RandomUtils {

    private RandomUtils(){}

    public static String getFirstName(){
        return FakerUtils.getFirstName();
    }

    public static String getLastName(){
        return FakerUtils.getLastName();
    }

    public static String getAdditionalNeed(){
        return FakerUtils.additionalNeeds();
    }

    public static Double getPrice(){
        return FakerUtils.getPrice(2,4000,5000);
    }
}

package com.test.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils(){

    }

    private static final Faker faker = new Faker();

    static String getFirstName(){
        return faker.name().firstName();
    }

    static String getLastName(){
        return faker.name().lastName();
    }

    static Double getPrice(int decimalPlace,int minimumRange,int maximumRange ){
        return faker.number().randomDouble(decimalPlace,minimumRange,maximumRange);
    }

    static String additionalNeeds(){
        return faker.food().fruit();
    }
}

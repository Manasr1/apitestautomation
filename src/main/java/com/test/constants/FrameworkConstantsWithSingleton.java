package com.test.constants;

import lombok.Getter;
import lombok.Synchronized;

public class FrameworkConstantsWithSingleton { //singleton

    private String requestJsonFolderPath =System.getProperty("user.dir")+"/src/test/resources/json/";
    private String responseJsonFolderPath =System.getProperty("user.dir")+"/output/";

    private static FrameworkConstantsWithSingleton instance = null;

    private FrameworkConstantsWithSingleton() {}

    public static synchronized FrameworkConstantsWithSingleton getInstance(){
        if (instance==null){
            instance = new FrameworkConstantsWithSingleton();
        }
        return instance;
    }
}

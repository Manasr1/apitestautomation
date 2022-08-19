package com.test.constants;

import lombok.Getter;

public class FrameworkConstants {

    private static @Getter String requestJsonFolderPath =System.getProperty("user.dir")+"/src/test/resources/json/";
    private static @Getter String responseJsonFolderPath =System.getProperty("user.dir")+"/output/";
    private static @Getter String configProperties =System.getProperty("user.dir")+"/src/test/resources/config.properties";
}

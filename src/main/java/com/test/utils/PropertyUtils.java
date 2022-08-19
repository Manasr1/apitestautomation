package com.test.utils;

import com.test.enums.PropertiesType;
import com.test.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {
    }

    private static Properties properties = new Properties();
    private static Map<String, String> map = new HashMap<>();

    static {

        try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigProperties());) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        properties.entrySet().forEach(o -> map.put(String.valueOf(o.getKey()), String.valueOf(o.getValue())));
    }

    public static String readValue(PropertiesType key) {
       return  map.get(key.name().toLowerCase());
    }
}

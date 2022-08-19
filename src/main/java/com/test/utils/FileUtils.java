package com.test.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class FileUtils {

    private FileUtils(){}

    @SneakyThrows
    public static String readJSONAndConvertIntoString(String path){
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    @SneakyThrows
    public static void writeBytesArrayToJSON(String path, Response response) {
       Files.write(Paths.get(path),response.asByteArray());
    }

}

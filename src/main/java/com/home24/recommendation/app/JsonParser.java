package com.home24.recommendation.app;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

/**
 * Created by VIVEK VERMA on 1/14/2017.
 */
public class JsonParser {
    static Map parseFile(String fileName) throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(fileName), Map.class);
    }
}

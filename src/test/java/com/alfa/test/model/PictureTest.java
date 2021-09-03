package com.alfa.test.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PictureTest {

    public static Picture getPicture(String testString){
        return new Picture(new PictureData("url", testString), new LinkedHashMap());
    }
}
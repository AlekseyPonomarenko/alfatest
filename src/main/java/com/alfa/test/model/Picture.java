package com.alfa.test.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedHashMap;


@Data
@AllArgsConstructor
public class Picture {

    private PictureData data;
    private LinkedHashMap meta;

}


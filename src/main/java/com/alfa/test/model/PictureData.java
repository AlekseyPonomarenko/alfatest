package com.alfa.test.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PictureData {

    private String url;

    @JsonAlias("embed_url")
    private String embedUrl;
}

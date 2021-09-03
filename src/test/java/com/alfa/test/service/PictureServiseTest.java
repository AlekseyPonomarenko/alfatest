package com.alfa.test.service;

import com.alfa.test.feign.PictureFeignClient;
import com.alfa.test.model.PictureTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class PictureServiseTest {

    @MockBean
    private PictureFeignClient pictureFeignClient;

    @Value("${giphy.api_key}")
    private String api_key;

    @Autowired
    private PictureServiseImpl pictureServise;

    @Test
    void getPictureByTag() {

        String tag = "tag";
        given(pictureFeignClient.getPicture(tag, api_key)).willReturn(PictureTest.getPicture(tag));
        assertEquals(pictureServise.getPictureByTag(tag).getData().getEmbedUrl(), tag);
    }
}
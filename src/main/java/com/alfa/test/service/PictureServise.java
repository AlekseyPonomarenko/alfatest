package com.alfa.test.service;
import com.alfa.test.feign.PictureFeignClient;
import com.alfa.test.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class PictureServise implements PictureServiseImpl{

    @Autowired
    private PictureFeignClient pictureFeignClient;

    @Value("${giphy.api_key}")
    private String api_key;

    @Override
    public Picture getPictureByTag(String tag){
         return pictureFeignClient.getPicture(tag, api_key);
    };

}

package com.alfa.test.feign;
import com.alfa.test.model.Picture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="giphy", url="${giphy.url}")
public interface PictureFeignClient {

    @GetMapping(path = "/v1/gifs/random", consumes = "application/json")
    public Picture getPicture(@RequestParam("tag") String tag, @RequestParam("api_key") String api_key);

}

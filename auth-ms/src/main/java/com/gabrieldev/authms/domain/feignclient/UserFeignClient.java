package com.gabrieldev.authms.domain.feignclient;

import com.gabrieldev.authms.app.dto.UserDTO;
import feign.Headers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "user-ms", url = "${gabrieldev.user-ms.url}")
public interface UserFeignClient {

    @GetMapping
    @Headers(value = "Authorization: Basic " + "${gabrieldev.user-ms.headers.data}")
    public UserDTO getUserByUsername(@RequestParam("username") String username);

}

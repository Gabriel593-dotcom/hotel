package com.gabrieldev.authms.domain.feignclient.utils;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.Base64;

public class AuthInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "Basic " + Base64.getEncoder().encodeToString("username:password".getBytes()));
    }
}
package com.superwind.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RestService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackRemoteCall")
    public <T1,T2> T1 remoteCall(String apiName, T2 reqObj, Class<T1> rspType, Class... parameterClasses) {
        String url = "http://provider-service" + apiName;
        //设置请求的header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type","application/json;charset=utf-8");
        headers.set("Accept","application/json");

        //设置请求参数
        HttpEntity<T2> request = new HttpEntity<T2>(reqObj, headers);

        //发送请求，由于restTemplate的responseType不支持嵌套的泛型，直接返回String，下面统一内部处理
        String jsonStr = restTemplate.postForObject(url, request, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JavaType rspJavaType = objectMapper.getTypeFactory().constructParametricType(rspType,parameterClasses);
        T1 rspObj = null;
        try {
            rspObj = (T1)objectMapper.readValue(jsonStr, rspJavaType);
        } catch (IOException e) {

        }
        return rspObj;
    }

    public <T1,T2> T1 fallbackRemoteCall(String apiName, T2 reqObj, Class<T1> rspType, Class... parameterClasses){
        System.out.println("fallbackRemoteCall===");
        T1 rsp = (T1)getDefaultValue();
        return rsp;
    }

    private Integer getDefaultValue(){
        return 0;
    }
}

package com.superwind.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.superwind.conf.ProviderProperties;
import com.superwind.pojo.QryUserRsp;
import com.superwind.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProviderService {
    @Autowired
    Environment env;

//    @Value("${person.name}")
    String name;

    public int addUser(UserInfo userInfo) {
        System.out.println("addUser id="+userInfo.getId()+"  name="+name+"  sex="+userInfo.getSex());
        int result = insertUser();
        return result;
    }

//    @HystrixCommand(fallbackMethod = "insertUserFallBack")
    public int insertUser(){
        System.out.println("insertUser====");
        /*try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            return -1;
        }*/
        return 1;
        /*throw new RuntimeException("error");*/
    }

    private int insertUserFallBack(){
        System.out.println("insertUserFallBack====");
        return -1;
    }

    public QryUserRsp qryUser(UserInfo userInfo) {
        System.out.println("qryUser id="+userInfo.getId());
        QryUserRsp qryUserRsp = new QryUserRsp();
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(userInfo);
        qryUserRsp.setUserInfoList(userInfoList);
        return qryUserRsp;
    }
}

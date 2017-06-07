package com.superwind.service;

import com.superwind.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RibbonCallService {
    @Autowired
    private RestService restService;

    public int addUser(UserInfo userInfo) {
        //QryCommonRsp<UserAdvice>
        //restService.remoteCall("/api/data/addUser",qryUserAdviceReq,QryCommonRsp.class,UserAdvice.class);
        int result = restService.remoteCall("/provider/addUser",userInfo,int.class);
        System.out.println("addUser end===");
        return result;
    }
}

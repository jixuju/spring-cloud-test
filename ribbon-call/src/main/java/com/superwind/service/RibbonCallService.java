package com.superwind.service;

import com.superwind.pojo.QryUserRsp;
import com.superwind.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public QryUserRsp qryUser(UserInfo userInfo) {
        System.out.println("qryUser id="+userInfo.getId());
        QryUserRsp qryUserRsp = new QryUserRsp();
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(userInfo);
        qryUserRsp.setUserInfoList(userInfoList);
        return qryUserRsp;
    }
}

package com.superwind.service;

import com.superwind.conf.ProviderProperties;
import com.superwind.pojo.QryUserRsp;
import com.superwind.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProviderService {
    @Autowired
    Environment env;
    @Autowired
    private ProviderProperties providerProperties;

    public int addUser(UserInfo userInfo) {
        System.out.println("addUser id="+userInfo.getId()+"  name="+userInfo.getName()+"  sex="+userInfo.getSex());
        System.out.println(providerProperties.getTestA());
        System.out.println(providerProperties.getTestB());
        System.out.println(providerProperties.getOps().getAccessLog());
        System.out.println(providerProperties.getOps().getErrorLog());
        return 1;
    }

    public QryUserRsp qryUser(UserInfo userInfo) throws Exception {
        System.out.println("qryUser id="+userInfo.getId());
        QryUserRsp qryUserRsp = new QryUserRsp();
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(userInfo);
        qryUserRsp.setUserInfoList(userInfoList);
//        throw new Exception("sdf");
        return qryUserRsp;
    }
}

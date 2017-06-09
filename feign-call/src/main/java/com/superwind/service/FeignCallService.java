package com.superwind.service;

import com.superwind.feign.IAddUserService;
import com.superwind.feign.IQryUserService;
import com.superwind.pojo.QryUserRsp;
import com.superwind.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignCallService {
    @Autowired
    private IAddUserService iAddUserService;
    @Autowired
    private IQryUserService iQryUserService;

    public int addUser(UserInfo userInfo) {
        int result = iAddUserService.addUser(userInfo);
        System.out.println("==addUser end");
        return result;
    }

    public QryUserRsp qryUser(UserInfo userInfo) {
        System.out.println("==qryUser begin");
        return iQryUserService.qryUser(userInfo);
    }
}

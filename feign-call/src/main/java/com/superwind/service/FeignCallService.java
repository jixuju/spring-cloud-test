package com.superwind.service;

import com.superwind.feign.IUserService;
import com.superwind.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignCallService {
    @Autowired
    private IUserService iUserService;

    public int addUser(UserInfo userInfo) {
        int result = iUserService.addUser(userInfo);
        System.out.println("==addUser end");
        return result;
    }
}

package com.superwind.web;

import com.superwind.pojo.QryUserRsp;
import com.superwind.pojo.UserInfo;
import com.superwind.service.FeignCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeignCallController {

    @Autowired
    private FeignCallService feignCallService;

    @PostMapping("/feign/addUser")
    public int addUser(@RequestBody UserInfo userInfo) {
        return feignCallService.addUser(userInfo);
    }

    @PostMapping("/feign/qryUser")
    public QryUserRsp qryUser(@RequestBody UserInfo userInfo) {
        return feignCallService.qryUser(userInfo);
    }
}

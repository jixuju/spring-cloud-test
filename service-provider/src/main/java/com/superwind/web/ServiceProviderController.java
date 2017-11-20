package com.superwind.web;

import com.superwind.pojo.QryUserRsp;
import com.superwind.pojo.UserInfo;
import com.superwind.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @PostMapping("/provider/addUser")
    public int addUser(@RequestBody UserInfo userInfo) {
        return serviceProviderService.addUser(userInfo);
    }

    @PostMapping("/provider/qryUser")
    public QryUserRsp qryUser(@RequestBody UserInfo userInfo) throws Exception {
        return serviceProviderService.qryUser(userInfo);
    }
}

package com.superwind.web;

import com.superwind.pojo.QryUserRsp;
import com.superwind.pojo.UserInfo;
import com.superwind.service.RibbonCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonCallController {

    @Autowired
    private RibbonCallService ribbonCallService;

    @PostMapping("/ribbon/addUser")
    public int addUser(@RequestBody UserInfo userInfo) {
        return ribbonCallService.addUser(userInfo);
    }

    @PostMapping("/provider/qryUser")
    public QryUserRsp qryUser(@RequestBody UserInfo userInfo) {
        return ribbonCallService.qryUser(userInfo);
    }
}

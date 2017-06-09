package com.superwind.feign;


import com.superwind.pojo.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class UserServiceHystrix implements IAddUserService{
    @Override
    public int addUser(@RequestBody UserInfo userInfo) {
        return 0;
    }
}

package com.superwind.feign;

import com.superwind.pojo.QryUserRsp;
import com.superwind.pojo.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="provider-service"/*,fallback = UserServiceHystrix.class*/)
public interface IQryUserService {
    @RequestMapping(method = RequestMethod.POST, value = "/provider/qryUser")
    public QryUserRsp qryUser(@RequestBody UserInfo userInfo);
}

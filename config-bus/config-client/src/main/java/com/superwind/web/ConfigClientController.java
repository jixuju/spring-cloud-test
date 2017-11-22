package com.superwind.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientController {

    @Autowired
    Environment env;

    @Value("${person.name}")
    String name;

    @PostMapping("/config/qryUser")
    public String qryUser() {
        System.out.println("person.name="+name+" in the config-repo");
        return name;
    }

    @PostMapping("/config/delUser")
    public Integer delUser() {
        System.out.println("del person.name="+name);
        return 1;
    }
}

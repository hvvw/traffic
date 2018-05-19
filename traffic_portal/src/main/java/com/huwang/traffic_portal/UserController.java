package com.huwang.traffic_portal;


import com.huwang.traffic_portal.entity.*;
import com.huwang.traffic_portal.service.*;
import com.huwang.traffic_portal.util.CommonUtils;
import com.huwang.traffic_portal.util.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService service;

    @RequestMapping("/submitLoginData")
    @ResponseBody
    public ResponseEntity submitLoginData(@RequestParam(value = "username", required = false) String account,
                          @RequestParam(value = "password", required = false) String passwd) {
        log.info("[GET User Data]Start get account=[{}]",account);
        ResponseEntity responseEntity=new ResponseEntity();
        UserEntity user=service.login(account,passwd);
        if(user==null) {
            responseEntity.setFlag(false);
            responseEntity.setObject("账号密码输入错误");
        }
        else {
            responseEntity.setFlag(true);
            String token=CommonUtils.GetGUID();
            user.setToken(token);
            user.setLastLoginTime(new Date(System.currentTimeMillis()));
            service.updateEntity(user);
            responseEntity.setObject(token);
        }
        log.info("[Response User Data]Start response user=[{}]",responseEntity.getObject());
        return responseEntity;
    }

    @RequestMapping("/home")
    public String index() {
        return "index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public boolean test()
    {
        return service.verifyToken("3a09570b24d149cda5ee4e984ab5222c");
    }

}

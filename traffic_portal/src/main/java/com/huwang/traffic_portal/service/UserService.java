package com.huwang.traffic_portal.service;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwang.traffic_portal.MapController;
import com.huwang.traffic_portal.dao.UserDao;
import com.huwang.traffic_portal.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao dao;

    public UserEntity login(String account, String passwd) {
        List<UserEntity> responses = dao.getUsers(account, passwd);
        List<UserEntity> users = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String mapJakcson = mapper.writeValueAsString(responses);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, UserEntity.class);
            users = mapper.readValue(mapJakcson, javaType);
        } catch (Exception e) {
        }
        if (users.isEmpty())
            return null;
        else return users.get(0);
    }

    public void updateEntity(UserEntity user) {
        dao.updateEntity(user);
    }

    public boolean verifyToken(String token) {
        List<UserEntity> responses = dao.getUsersByToken(token);
        List<UserEntity> users = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String mapJakcson = mapper.writeValueAsString(responses);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, UserEntity.class);
            users = mapper.readValue(mapJakcson, javaType);
            log.info(users.toString());
        } catch (Exception e) {
            log.error("exception");
        }
        if (users.isEmpty()) {
            log.error("error");
            return false;
        } else {
            UserEntity user = users.get(0);
            long lastLoginTime = user.getLastLoginTime().getTime();
            long nowTime = System.currentTimeMillis();
            log.info(lastLoginTime + "sd" + nowTime);
            if (nowTime - lastLoginTime >= 1000 * 3600)
                return false;
            else return true;
        }
    }

}

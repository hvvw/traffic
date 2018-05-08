package com.huwang.traffic_portal.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwang.traffic_portal.dao.AgencyDao;
import com.huwang.traffic_portal.dao.PointDao;
import com.huwang.traffic_portal.entity.AgencyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgencyService {

    private static final Logger log = LoggerFactory.getLogger(AgencyService.class);
    @Autowired
    private AgencyDao dao;
    @Autowired
    private PointDao pointDao;

    public List<AgencyEntity> getAgency(double lat, double lng, int unit)
    {
        List<AgencyEntity> response=dao.getAgency(lat,lng,unit);
        List<AgencyEntity> agencys=new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String mapJakcson = mapper.writeValueAsString(response);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, AgencyEntity.class);
            agencys = mapper.readValue(mapJakcson, javaType);
        }catch (Exception e){}
        return agencys;
    }
}

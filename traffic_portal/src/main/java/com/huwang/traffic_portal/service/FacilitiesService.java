package com.huwang.traffic_portal.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwang.traffic_portal.dao.FacilitiesDao;
import com.huwang.traffic_portal.dao.PointDao;
import com.huwang.traffic_portal.entity.FacilitiesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacilitiesService {

    private static final Logger log = LoggerFactory.getLogger(FacilitiesService.class);
    @Autowired
    private FacilitiesDao dao;
    @Autowired
    private PointDao pointDao;

    public List<FacilitiesEntity> getFacilities(double lat, double lng, int unit)
    {
        List<FacilitiesEntity> response=dao.getFacilities(lat,lng,unit);
        List<FacilitiesEntity> facilities=new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String mapJakcson = mapper.writeValueAsString(response);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, FacilitiesEntity.class);
            facilities = mapper.readValue(mapJakcson, javaType);
        }catch (Exception e){}
        return facilities;
    }

    public List<FacilitiesEntity> searchFacilities(double lat, double lng, int unit,String str)
    {
        List<FacilitiesEntity> response=dao.searchFacilities(lat,lng,unit,str);
        List<FacilitiesEntity> facilities=new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String mapJakcson = mapper.writeValueAsString(response);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, FacilitiesEntity.class);
            facilities = mapper.readValue(mapJakcson, javaType);
        }catch (Exception e){}
        return facilities;
    }
}

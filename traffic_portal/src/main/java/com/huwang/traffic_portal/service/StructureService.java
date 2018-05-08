package com.huwang.traffic_portal.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwang.traffic_portal.dao.PointDao;
import com.huwang.traffic_portal.dao.StructureDao;
import com.huwang.traffic_portal.entity.StructureEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StructureService {

    private static final Logger log = LoggerFactory.getLogger(StructureService.class);
    @Autowired
    private StructureDao dao;
    @Autowired
    private PointDao pointDao;

    public List<StructureEntity> getStructures(double lat, double lng, int unit)
    {
        List<StructureEntity> response=dao.getStructures(lat,lng,unit);
        List<StructureEntity> structrures=new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String mapJakcson = mapper.writeValueAsString(response);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, StructureEntity.class);
            structrures = mapper.readValue(mapJakcson, javaType);
        }catch (Exception e){}
        return structrures;
    }
}

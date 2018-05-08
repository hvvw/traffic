package com.huwang.traffic_portal.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwang.traffic_portal.dao.MaintenanceDao;
import com.huwang.traffic_portal.dao.PointDao;
import com.huwang.traffic_portal.entity.LoadEntity;
import com.huwang.traffic_portal.entity.MaintenanceEntity;
import com.huwang.traffic_portal.entity.Point;
import com.huwang.traffic_portal.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceService {

    private static final Logger log = LoggerFactory.getLogger(MaintenanceService.class);
    @Autowired
    private MaintenanceDao dao;
    @Autowired
    private PointDao pointDao;

    public List<MaintenanceEntity> getMaintenance(double lat, double lng, int unit)
    {
        List<MaintenanceEntity> response=dao.getMaintenance(lat,lng,unit);
        List<MaintenanceEntity> maintenances=new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String mapJakcson = mapper.writeValueAsString(response);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, MaintenanceEntity.class);
            maintenances = mapper.readValue(mapJakcson, javaType);
        }catch (Exception e){}
        for (MaintenanceEntity maintenance : maintenances) {
            List<Point> points = pointDao.getPoints(maintenance.getId(), CommonUtils.MAINTENANCETYPE);
            maintenance.setPoints(points);
        }
        return maintenances;
    }
}

package com.huwang.traffic_portal;


import com.huwang.traffic_portal.dao.PointDao;
import com.huwang.traffic_portal.entity.LoadEntity;
import com.huwang.traffic_portal.entity.Point;
import com.huwang.traffic_portal.service.LoadService;
import com.huwang.traffic_portal.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MapController {

    private static final Logger log = LoggerFactory.getLogger(MapController.class);
    @Autowired
    private LoadService service;

    @RequestMapping("/map")
    public String Map() {
        return "maps";
    }

    @RequestMapping("/loadData")
    @ResponseBody
    public List<LoadEntity> getLoad() {
        List<LoadEntity> loads = service.getLoads(11, 11, 12);
        return loads;
    }


}

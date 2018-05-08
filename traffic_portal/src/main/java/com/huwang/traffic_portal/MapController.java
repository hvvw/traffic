package com.huwang.traffic_portal;


import com.huwang.traffic_portal.entity.LoadEntity;
import com.huwang.traffic_portal.entity.StructureEntity;
import com.huwang.traffic_portal.service.LoadService;
import com.huwang.traffic_portal.service.StructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MapController {

    private static final Logger log = LoggerFactory.getLogger(MapController.class);
    @Autowired
    private LoadService loadService;
    @Autowired
    private StructureService structureService;

    @RequestMapping("/map")
    public String Map() {
        return "maps";
    }

    @RequestMapping("/loadData")
    @ResponseBody
    public List<LoadEntity> getLoad(@RequestParam(value = "lat", required = false) Double lat,
                                    @RequestParam(value = "lng", required = false) Double lng,
                                    @RequestParam(value = "zoom", required = false) Integer zoom) {
        log.info("[GET Load Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<LoadEntity> loads = loadService.getLoads(11,11,14);
        log.info("[Response Load Data]Start return loads size=[{}].", loads.size());
        return loads;
    }

    @RequestMapping("/structureData")
    @ResponseBody
    public List<StructureEntity> getStructure(@RequestParam(value = "lat", required = false) Double lat,
                                               @RequestParam(value = "lng", required = false) Double lng,
                                               @RequestParam(value = "zoom", required = false) Integer zoom)
    {
        log.info("[GET Structure Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<StructureEntity> structures = structureService.getStructures(11,11, 14);
        log.info("[Response Structure Data]Start return structures size=[{}].", structures.size());
        return structures;
    }

}

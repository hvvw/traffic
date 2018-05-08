package com.huwang.traffic_portal;


import com.huwang.traffic_portal.entity.*;
import com.huwang.traffic_portal.service.*;
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
    @Autowired
    private FacilitiesService facilitiesService;
    @Autowired
    private MaintenanceService maintenanceService;
    @Autowired
    private AgencyService agencyService;

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
        List<StructureEntity> structures = structureService.getStructures(lat,lng, zoom);
        log.info("[Response Structure Data]Start return structures size=[{}].", structures.size());
        return structures;
    }

    @RequestMapping("/facilitiesData")
    @ResponseBody
    public List<FacilitiesEntity> getFacilities(@RequestParam(value = "lat", required = false) Double lat,
                                              @RequestParam(value = "lng", required = false) Double lng,
                                              @RequestParam(value = "zoom", required = false) Integer zoom)
    {
        log.info("[GET Facilities Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<FacilitiesEntity> facilities = facilitiesService.getFacilities(lat,lng, zoom);
        log.info("[Response Facilities Data]Start return facilities size=[{}].", facilities.size());
        return facilities;
    }

    @RequestMapping("/maintenanceData")
    @ResponseBody
    public List<MaintenanceEntity> getMaintenance(@RequestParam(value = "lat", required = false) Double lat,
                                                  @RequestParam(value = "lng", required = false) Double lng,
                                                  @RequestParam(value = "zoom", required = false) Integer zoom)
    {
        log.info("[GET Maintenances Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<MaintenanceEntity> maintenances = maintenanceService.getMaintenance(lat,lng, zoom);
        log.info("[Response Maintenances Data]Start return maintenances size=[{}].", maintenances.size());
        return maintenances;
    }

    @RequestMapping("/agencyData")
    @ResponseBody
    public List<AgencyEntity> getAgency(@RequestParam(value = "lat", required = false) Double lat,
                                             @RequestParam(value = "lng", required = false) Double lng,
                                             @RequestParam(value = "zoom", required = false) Integer zoom)
    {
        log.info("[GET Agency Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<AgencyEntity> agencys = agencyService.getAgency(lat,lng, zoom);
        log.info("[Response Agency Data]Start return agencys size=[{}].", agencys.size());
        return agencys;
    }

}

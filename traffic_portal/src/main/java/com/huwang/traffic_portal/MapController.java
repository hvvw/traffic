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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/addPoint")
    @ResponseBody
    public String getData(@RequestParam(value = "lat", required = false) Double lat,
                          @RequestParam(value = "lng", required = false) Double lng,
                          @RequestParam(value = "pid", required = false) Integer pid) {
        log.info("[GET point Data]Start get lat=[{}],lng =[{}].", lat, lng,pid);
        loadService.addPoint(lat,lng,pid);
        return "addpoint";
    }

    @RequestMapping("/loadData")
    @ResponseBody
    public List<LoadEntity> getLoad(@RequestParam(value = "lat", required = false) Double lat,
                                    @RequestParam(value = "lng", required = false) Double lng,
                                    @RequestParam(value = "zoom", required = false) Integer zoom) {
        log.info("[GET Load Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<LoadEntity> loads = loadService.getLoads(lat,lng,zoom);
        log.info("[Response Load Data]Start return loads size=[{}].", loads.size());
        return loads;
    }

    @RequestMapping("/searchLoad")
    @ResponseBody
    public List<LoadEntity> searchLoad(@RequestParam(value = "lat", required = false) Double lat,
                                       @RequestParam(value = "lng", required = false) Double lng,
                                       @RequestParam(value = "zoom", required = false) Integer zoom,
                                       @RequestParam(value = "searchData", required = false) String searchData) {
        log.info("[GET Load Data]Start get lat=[{}],lng =[{}],zoom=[{}],searchData=[{}].", lat, lng, zoom,searchData);
        List<LoadEntity> loads = loadService.searchLoad(lat,lng,zoom,searchData);
        log.info("[Response Load Data]Start return loads size=[{}].", loads.size());
        return loads;
    }

    @RequestMapping("/structureData")
    @ResponseBody
    public Map getStructure(@RequestParam(value = "lat", required = false) Double lat,
                            @RequestParam(value = "lng", required = false) Double lng,
                            @RequestParam(value = "zoom", required = false) Integer zoom)
    {
        log.info("[GET Structure Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<StructureEntity> structures = structureService.getStructures(lat,lng, zoom);
        List<LoadEntity> loads = loadService.getLoads(lat,lng,zoom);
        Map map=new HashMap();
        map.put("structures",structures);
        map.put("loads",loads);
        log.info("[Response Structure Data]Start return structures size=[{}].", structures.size());
        return map;
    }

    @RequestMapping("/searchStructure")
    @ResponseBody
    public Map searchStructure(@RequestParam(value = "lat", required = false) Double lat,
                               @RequestParam(value = "lng", required = false) Double lng,
                               @RequestParam(value = "zoom", required = false) Integer zoom,
                               @RequestParam(value = "searchData", required = false) String searchData)
    {
        log.info("[GET Structure Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<StructureEntity> structures = structureService.searchStructures(lat,lng, zoom,searchData);
        List<LoadEntity> loads = loadService.getLoads(lat,lng,zoom);
        Map map=new HashMap();
        map.put("structures",structures);
        map.put("loads",loads);
        log.info("[Response Structure Data]Start return structures size=[{}].", structures.size());
        return map;
    }

    @RequestMapping("/facilitiesData")
    @ResponseBody
    public Map getFacilities(@RequestParam(value = "lat", required = false) Double lat,
                                              @RequestParam(value = "lng", required = false) Double lng,
                                              @RequestParam(value = "zoom", required = false) Integer zoom)
    {
        log.info("[GET Facilities Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<FacilitiesEntity> facilities = facilitiesService.getFacilities(lat,lng, zoom);
        List<LoadEntity> loads = loadService.getLoads(lat,lng,zoom);
        Map map=new HashMap();
        map.put("facilities",facilities);
        map.put("loads",loads);
        log.info("[Response Facilities Data]Start return facilities size=[{}].", facilities.size());
        return map;
    }

    @RequestMapping("/searchFacilities")
    @ResponseBody
    public Map searchFacilities(@RequestParam(value = "lat", required = false) Double lat,
                                       @RequestParam(value = "lng", required = false) Double lng,
                                       @RequestParam(value = "zoom", required = false) Integer zoom,
                                       @RequestParam(value = "searchData", required = false) String searchData) {
        log.info("[GET Load Data]Start get lat=[{}],lng =[{}],zoom=[{}],searchData=[{}].", lat, lng, zoom,searchData);
        List<FacilitiesEntity> facilities = facilitiesService.searchFacilities(lat,lng, zoom,searchData);
        List<LoadEntity> loads = loadService.getLoads(lat,lng,zoom);
        Map map=new HashMap();
        map.put("facilities",facilities);
        map.put("loads",loads);
        log.info("[Response Facilities Data]Start return facilities size=[{}].", facilities.size());
        return map;
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

    @RequestMapping("/searchMaintenance")
    @ResponseBody
    public List<MaintenanceEntity> searchMaintenance(@RequestParam(value = "lat", required = false) Double lat,
                                                     @RequestParam(value = "lng", required = false) Double lng,
                                                     @RequestParam(value = "zoom", required = false) Integer zoom,
                                                     @RequestParam(value = "searchData", required = false) String searchData)
    {
        log.info("[GET Maintenances Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<MaintenanceEntity> maintenances = maintenanceService.searchMaintenance(lat,lng, zoom,searchData);
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

    @RequestMapping("/searchAgency")
    @ResponseBody
    public List<AgencyEntity> searchAgency(@RequestParam(value = "lat", required = false) Double lat,
                                           @RequestParam(value = "lng", required = false) Double lng,
                                           @RequestParam(value = "zoom", required = false) Integer zoom,
                                           @RequestParam(value = "searchData", required = false) String searchData)
    {
        log.info("[GET Agency Data]Start get lat=[{}],lng =[{}],zoom=[{}].", lat, lng, zoom);
        List<AgencyEntity> agencys = agencyService.searchAgency(lat,lng, zoom,searchData);
        log.info("[Response Agency Data]Start return agencys size=[{}].", agencys.size());
        return agencys;
    }

}

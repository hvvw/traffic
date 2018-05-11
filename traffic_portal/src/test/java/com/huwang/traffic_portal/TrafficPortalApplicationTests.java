package com.huwang.traffic_portal;

import com.huwang.traffic_portal.config.DatabaseConfig;
import com.huwang.traffic_portal.config.ServerConfig;
import com.huwang.traffic_portal.entity.LoadEntity;
import com.huwang.traffic_portal.entity.StructureEntity;
import com.huwang.traffic_portal.service.LoadService;
import com.huwang.traffic_portal.service.StructureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureAfter(value = {DatabaseConfig.class,ServerConfig.class})
public class TrafficPortalApplicationTests {

	private static  Logger logger=LoggerFactory.getLogger(TrafficPortalApplicationTests.class);
	@Autowired
	private LoadService service;
	@Autowired
	private StructureService structureService;

	@Test
	public void contextLoads() {
		List<StructureEntity> structures = structureService.getStructures(28.68019,115.850539, 14);
		List<LoadEntity> loads = service.getLoads(28.68019,115.850539, 14);
		Map map=new HashMap();
		map.put("structures",structures);
		map.put("loads",loads);
		System.out.print(map);
	}

}

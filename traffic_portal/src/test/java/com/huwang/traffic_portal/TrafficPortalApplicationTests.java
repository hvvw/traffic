package com.huwang.traffic_portal;

import com.huwang.traffic_portal.config.DatabaseConfig;
import com.huwang.traffic_portal.config.ServerConfig;
import com.huwang.traffic_portal.service.LoadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureAfter(value = {DatabaseConfig.class,ServerConfig.class})
public class TrafficPortalApplicationTests {

	@Autowired
	private LoadService service;

	@Test
	public void contextLoads() {
		System.out.print(service.getLoads(11,11,12));
	}

}

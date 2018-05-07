package com.huwang.traffic_portal;

import com.huwang.traffic_portal.config.DatabaseConfig;
import com.huwang.traffic_portal.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigureAfter(value = {DatabaseConfig.class,ServerConfig.class})
public class TrafficPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficPortalApplication.class, args);
	}
}

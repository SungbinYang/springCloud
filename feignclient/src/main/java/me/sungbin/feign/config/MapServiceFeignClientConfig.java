package me.sungbin.feign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "me.sungbin.feign.mapService")
public class MapServiceFeignClientConfig {
}

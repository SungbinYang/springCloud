package me.sungbin.photoapp.config;

import me.sungbin.photoapp.api.MDCFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new MDCFilter());
        registrationBean.setUrlPatterns(List.of("/v1/*"));

        return registrationBean;
    }
}

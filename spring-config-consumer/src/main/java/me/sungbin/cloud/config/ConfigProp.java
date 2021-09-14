package me.sungbin.cloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@Data
@ConfigurationProperties("mongodbserver")
public class ConfigProp {

    private String url;

    private String username;

    private String password;
}

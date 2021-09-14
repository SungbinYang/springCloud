package me.sungbin.cloud.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConfigChangeListener implements ApplicationListener<EnvironmentChangeEvent> {

    final ConfigProp configProp;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        log.info("event key: {}", event.getKeys().toString());
    }
}

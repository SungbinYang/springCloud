package me.sungbin.cloud.config;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ConfigController {

    private final ConfigMgmt configMgmt;

    @GetMapping("/v1/check/prop")
    public String findPropMessage() {
        return configMgmt.getConfigProperty().toString();
    }
}

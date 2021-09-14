package me.sungbin.cloud.app;

import me.sungbin.cloud.config.MySqlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MySqlConfig.class)
public class SpringVaultApp implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(SpringVaultApp.class);

    private final MySqlConfig mySqlConfig;

    public SpringVaultApp(MySqlConfig mySqlConfig) {
        this.mySqlConfig = mySqlConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringVaultApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("properties: {}, {}", mySqlConfig.getUserName(), mySqlConfig.getPassword());
    }
}

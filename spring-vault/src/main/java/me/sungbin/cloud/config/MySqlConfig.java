package me.sungbin.cloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mysql")
public class MySqlConfig {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MySqlConfig{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

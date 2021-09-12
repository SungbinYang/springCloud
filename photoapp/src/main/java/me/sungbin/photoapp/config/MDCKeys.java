package me.sungbin.photoapp.config;

public enum MDCKeys {

    REQUEST_ID("requestId"),
    REQUEST_URL("requestUrl"),
    USER_AGENT("userAgent"),
    CLIENT_IP("clientIP");

    MDCKeys(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    private String propertyKey;

}

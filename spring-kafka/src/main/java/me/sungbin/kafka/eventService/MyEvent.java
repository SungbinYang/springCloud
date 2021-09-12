package me.sungbin.kafka.eventService;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@ToString
public class MyEvent {

    private String eventId;

    private Map<String, Object> myData;

    public MyEvent(Map<String, Object> myData) {
        this.eventId = UUID.randomUUID().toString();
        this.myData = myData;
    }
}

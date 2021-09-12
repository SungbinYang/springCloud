package me.sungbin.kafka.eventService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventController {

    final MyEventService myEventService;

    @GetMapping("/event")
    public String getEvent() {
        myEventService.sendMsg();
        return "OK";
    }
}

package com.aasa.tluspring.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
@RequestMapping(value = "/time")
public class TimeController {
    TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping(produces = "text/plain")
    public String getTime() {
        return timeService.getTime();
    }
}

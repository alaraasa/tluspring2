package com.aasa.tluspring.Time;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class TimeService {
    public String getTime() {
        Calendar calendar = Calendar.getInstance();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.format(calendar.getTime());
    }
}

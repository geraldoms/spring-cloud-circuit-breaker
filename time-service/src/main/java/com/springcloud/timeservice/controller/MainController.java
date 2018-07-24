package com.springcloud.timeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class MainController {

    @GetMapping("/current/time")
    public String getTime() {

        final Calendar now = Calendar.getInstance();
        final String[] strDays =
            new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday" };
        final String date = (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR);
        final String time =
            now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);

        return String.format("Hello, today is %s, the date is %s and the time right now is %s.",
            strDays[now.get(Calendar.DAY_OF_WEEK) - 1], date, time);
    }
}

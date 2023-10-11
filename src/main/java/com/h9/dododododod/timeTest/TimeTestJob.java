package com.h9.dododododod.timeTest;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
@Component
public class TimeTestJob {


    //@Scheduled(cron = "0/2 * * * * ?")
    void demo1() {
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        String timeZoneId = timeZone.getID();
        System.out.println("timeZoneId："+timeZoneId);
        System.out.println("timestamp："+Instant.now().getEpochSecond());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String utcTime = sdf.format(date);

        System.out.println("utcTime："+utcTime);
        System.out.println("Date："+date);
        System.out.println("================================================");
    }

    @Scheduled(cron = "0 0 15 * * ?")
    void demo2() {
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        String timeZoneId = timeZone.getID();
        System.out.println("timeZoneId："+timeZoneId);
        System.out.println("timestamp："+Instant.now().getEpochSecond());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String utcTime = sdf.format(date);

        System.out.println("utcTime："+utcTime);
        System.out.println("Date："+date);
    }


}

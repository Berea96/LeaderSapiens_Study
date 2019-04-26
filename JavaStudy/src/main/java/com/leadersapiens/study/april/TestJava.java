package com.leadersapiens.study.april;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;

public class TestJava {

    public static void main(String[] args) throws Exception {

        String a = "a";

        String b = "b";

        String nullString = null;

        ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        if (a.equals(b)) {
            System.out.println("a equals b");
        } else {
            System.out.println("a not equals b");
        }

        if (a.equals(nullString)) {
            System.out.println("a equals nullString");
        } else {
            System.out.println("a not equals nullString");
        }

        System.out.println(System.currentTimeMillis());
        System.out.println(seoulDateTime.toEpochSecond() * 1000);
        System.out.println(seoulDateTime.toEpochSecond() * 1000 + (1000 * 60 * 60 * 24));
        System.out.println((seoulDateTime.toEpochSecond() * 1000) - (1000 * 60 * 60 * 4));

//        System.out.println(String.format("%s", (char) 20) + "asd");
//        TestTimerTask timerTask = new TestTimerTask();
//        Timer timer1 = new Timer();
//        timer1.scheduleAtFixedRate(timerTask, 0, 10);

//        dateCalculator();

        System.out.println(System.currentTimeMillis());

    }


    public static void dateCalculator() throws ParseException {
        SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //2015,05,27,09,00,0

        Date secondDateTime = dbDateFormat.parse("2019-01-01 23:00:00");

        Calendar secondDateTime_calendar = Calendar.getInstance();
        secondDateTime_calendar.setTime(secondDateTime);
        secondDateTime_calendar.add(Calendar.HOUR, 1);

        int year =  secondDateTime_calendar.get(Calendar.YEAR);
        int month =  secondDateTime_calendar.get(Calendar.MONTH) + 1;
        int day =  secondDateTime_calendar.get(Calendar.DAY_OF_MONTH);

        int hour =  secondDateTime_calendar.get(Calendar.HOUR_OF_DAY);
        int minute =  secondDateTime_calendar.get(Calendar.MINUTE);
        int second =  secondDateTime_calendar.get(Calendar.SECOND);

        String monthString = month < 10 ? "0" + month : month + "";
        String dayString = day < 10 ? "0" + day : day + "";

        String hourString = hour < 10 ? "0" + hour : hour + "";
        String minuteString = minute < 10 ? "0" + minute : minute + "";
        String secondString = second < 10 ? "0" + second : second + "";

        System.out.println("Date : " + year + "-" + monthString + "-" + dayString + " " + hourString + ":" + minuteString + ":" + secondString);

        Date date = dbDateFormat.parse(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);

        System.out.println(date);

    }
}

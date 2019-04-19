package com.leadersapiens.study.april;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class TestJava {

    public static void main(String[] args) {

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

        System.out.println(String.format("%s", (char) 20) + "asd");
    }

}

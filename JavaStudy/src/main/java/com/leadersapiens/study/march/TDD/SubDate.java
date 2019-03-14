package com.leadersapiens.study.march.TDD;

public class SubDate {

    static final int[] monthDays = {
            31, 28, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public static int getYearDay(int year) {
        int result = 0;

        for(int i = 1; i < year; i++) {
            if (isLeapYear(i)) result += 366;
            else result += 365;
        }
        return result;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        else return false;
    }

    public static int getMonthDay(int month, boolean isLeap) {
        int result = 0;
        for(int i = 1; i < month; i++) {
            result += monthDays[i - 1];
        }

        if(isLeap && month > 2) result += 1;

        return result;
    }

    public static int getTotalDay(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        return getYearDay(year) + getMonthDay(month, isLeapYear(year)) + day;
    }

    public static int sub(String date1, String date2) {
        return Math.abs(getTotalDay(date1) - getTotalDay(date2));
    }

}

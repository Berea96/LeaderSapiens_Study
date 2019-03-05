package com.leadersapiens.study.march.parserTest;

import java.util.Timer;

//2019-03-05
//Parse class 들을 실행 시켜주는 Main class 이다.
public class ParserMain {
    public static void main(String[] args) {
        FootballScheduleParser scheduleParser = new FootballScheduleParser();

        Timer timer1 = new Timer();

        timer1.scheduleAtFixedRate(scheduleParser, 0, 1000 * 3);
    }
}

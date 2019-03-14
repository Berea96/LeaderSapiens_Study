package com.leadersapiens.study.march.parserTest.main;

import com.leadersapiens.study.march.parserTest.parser.FootballScheduleParser;
import com.leadersapiens.study.march.parserTest.parser.OddsportalSitesParser;

import java.util.Timer;

//2019-03-05
//Parse class 들을 실행 시켜주는 main class 이다.
public class ParserMain {
    public static void main(String[] args) {
        OddsportalSitesParser oddsportalSitesParser = new OddsportalSitesParser();
        FootballScheduleParser scheduleParser = new FootballScheduleParser();

        Timer timer1 = new Timer();
        Timer timer2 = new Timer();

        timer1.scheduleAtFixedRate(oddsportalSitesParser, 0, 1000 * 10);
        timer2.scheduleAtFixedRate(scheduleParser, 1000 * 5, 1000 * 10);
    }
}

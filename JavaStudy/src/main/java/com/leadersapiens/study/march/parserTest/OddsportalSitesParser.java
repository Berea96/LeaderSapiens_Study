package com.leadersapiens.study.march.parserTest;

import java.util.Timer;
import java.util.TimerTask;

/**
 * oddsportal사이트에서의 배팅사이트 정보를 가져오는 클래스
 */
public class OddsportalSitesParser extends TimerTask {

    private String url = "";

    @Override
    public void run() {
        oddsportalParser();
    }

    public void oddsportalParser() {

    }

    public void getHtmlBody() {

    }

    public static void main(String[] args) {
        OddsportalSitesParser oddsportalSitesParser = new OddsportalSitesParser();

        Timer timer1 = new Timer();

        timer1.scheduleAtFixedRate(oddsportalSitesParser, 0, 1000 * 10);
    }
}

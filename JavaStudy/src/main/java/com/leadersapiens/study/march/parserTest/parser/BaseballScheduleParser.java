package com.leadersapiens.study.march.parserTest.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.leadersapiens.study.march.parserTest.crawling.CrawlingMain;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class BaseballScheduleParser {

    private Logger logger = Logger.getLogger(BaseballScheduleParser.class.getName());

    private String scheduleUrl = "https://sports.news.naver.com/kbaseball/schedule/index.nhn";

    public void crawligSchduleCrwaler() {
        try {

            Map<String, String> header = new HashMap<>();

            String responseString = CrawlingMain.getBody(scheduleUrl, header);

            Pattern patter = Pattern.compile("");

            Document doc = Jsoup.parse(responseString);

            Element el = doc.getElementById("calendarWrap");

            Elements div = Jsoup.parse(el.html().replace("sch_tb2", "sch_tb")).getElementsByClass("sch_tb");

            logger.debug(div.get(1));

            int cnt = 0;
            for(Element element : div) {
                logger.debug(++cnt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        BaseballScheduleParser baseballScheduleParser = new BaseballScheduleParser();

        baseballScheduleParser.crawligSchduleCrwaler();
    }

}

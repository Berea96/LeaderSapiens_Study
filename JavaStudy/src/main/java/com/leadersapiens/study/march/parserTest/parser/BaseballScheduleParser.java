package com.leadersapiens.study.march.parserTest.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.leadersapiens.study.march.parserTest.bean.baseball.BaseballSchedule;
import com.leadersapiens.study.march.parserTest.crawling.CrawlingMain;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * TODO 경기정보 가져오기
 */
//https://sports.news.naver.com/ajax/game/relayData.nhn?gameId=20190312KTSS02019&_=

public class BaseballScheduleParser {

    private Logger logger = Logger.getLogger(BaseballScheduleParser.class.getName());

    static Map<String, BaseballSchedule> baseballScheduleMap = new HashMap<>();

    private String scheduleUrl = "https://sports.news.naver.com/kbaseball/schedule/index.nhn";

    public void crawligSchduleCrwaler() {
        try {

            Map<String, String> header = new HashMap<>();

            String responseString = CrawlingMain.getBody(scheduleUrl, header);

            Pattern patter = Pattern.compile("");

            Document doc = Jsoup.parse(responseString);

            Element el = doc.getElementById("calendarWrap");

            Elements baseGameSchedule = Jsoup.parse(el.html().replace("sch_tb2", "sch_tb")).getElementsByClass("sch_tb");

            logger.debug(baseGameSchedule.get(0));
            logger.debug(baseGameSchedule.get(1).getElementsByClass("td_date").get(0).getElementsByTag("strong").html());
            logger.debug(baseGameSchedule.get(16));

            String hour = "";
            String date = "";
            String a_team = "";
            String h_team = "";
            String point[];
            String stadium = "";
            int[] array = {1, 3, 5, 7, 9};

            int id = 0;

            for(Element element : baseGameSchedule) {
                BaseballSchedule baseballSchedule = new BaseballSchedule();

                Elements trs = element.getElementsByTag("tr");

                for(int i = 0; i < trs.size(); i++) {
                    hour = element.getElementsByClass("td_hour").get(i).html();

                    if(hour.equals("-")) continue;

                    date = element.getElementsByClass("td_date").get(0).getElementsByTag("strong").html().replace(".", "-");
                    a_team = element.getElementsByClass("team_lft").get(i).html();
                    h_team = element.getElementsByClass("team_rgt").get(i).html();
                    point = element.getElementsByClass("td_score").get(i).html().split("<em>:</em>");
                    stadium = element.getElementsByClass("td_stadium").get(array[i]).html();

                    baseballSchedule.setGtime(hour + ":00");
                    baseballSchedule.setGdate("2019-" + date);
                    baseballSchedule.setA_team(a_team);
                    baseballSchedule.setH_team(h_team);
                    baseballSchedule.setStadium(stadium);

                    if(point.length != 1) {
                        baseballSchedule.setA_point(point[0]);
                        baseballSchedule.setH_point(point[1]);
                    }
                    else {
                        baseballSchedule.setA_point("0");
                        baseballSchedule.setH_point("0");
                    }

                    logger.debug(baseballSchedule);

                    baseballScheduleMap.put(id++ + "", baseballSchedule);
                }
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

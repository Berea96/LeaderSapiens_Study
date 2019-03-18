package com.leadersapiens.study.march.parserTest.parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leadersapiens.study.march.parserTest.bean.bookmaker.Bookmaker;
import com.leadersapiens.study.march.parserTest.crawling.CrawlingMain;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * oddsportal사이트에서의 배팅사이트 정보를 가져오는 클래스
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OddsportalSitesParser extends TimerTask {
    private static Logger logger = Logger.getLogger(OddsportalSitesParser.class.getName());

    private Map<String, Bookmaker> bookmakerMap = new HashMap<>();

    private String url = "https://www.oddsportal.com/res/x/bookies-190305102620-" + System.currentTimeMillis() + ".js";

    @Override
    public void run() {
        crawlingBookmakerCrawler();
    }

    public void crawlingBookmakerCrawler() {
        logger.info("odds portal bookmaker crawling start");

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

            Map<String, String> headerMap = new HashMap<String, String>();

            headerMap.put("referer", "https://www.oddsportal.com/bookmaker/1xbet");
            headerMap.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");

            String getBody = CrawlingMain.getBody(url, headerMap);

            logger.debug(getBody);

            getBody = getBody.replace("\"", "'");
            getBody = getBody.replace("\\\\", "\\");

            logger.debug(getBody);

            Matcher matcher = Pattern.compile("var bookmakersData=(\\{('.+':\\{.+\\}){1,}\\}).+").matcher(getBody);

            if(!matcher.find()) {
                logger.debug("불통..");
                return;
            } else {
                logger.debug("통과");
                logger.debug(matcher.group(1));
            }

            bookmakerMap = mapper.readValue(matcher.group(1), new TypeReference<Map<Object, Bookmaker>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.debug(bookmakerMap);
    }

    public void oddsportalParser() {

    }

    public static void main(String[] args) {
        OddsportalSitesParser oddsportalSitesParser = new OddsportalSitesParser();

        Timer timer1 = new Timer();

        timer1.scheduleAtFixedRate(oddsportalSitesParser, 0, 1000 * 10);
    }
}

//자만하지말자.
//오만하지말자.
//항상겸손하자.
//매일매일배우자.
package com.leadersapiens.study.march.parserTest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//2019-03-05
public class FootballScheduleParser extends TimerTask {

    private static Logger logger = Logger.getLogger(FootballScheduleParser.class.getName());

    static final String nextGame = "https://fb.oddsportal.com/feed/match/1-1-xUeJGqJk-2-2-yjcbf.dat?_=" + System.currentTimeMillis();
    static final String nextGameOdds = "https://fb.oddsportal.com/ajax-next-games-odds/1/0/X0/20190305/1/yj9d4.dat?_=" + System.currentTimeMillis() / 1000L;

    @Override
    public void run() {
        parsingLiveGame();
    }

    //데이터를 파싱해 오는 메소드
    private void parsingLiveGame() {
        //System.out.println("파싱시작");
        logger.debug("Parsing start");
        logger.debug(nextGame);

        logger.debug(System.getProperty("server_instance"));

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(10000)
                .setSocketTimeout(15000).build();

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();

        String responseString = null;
        int responseCode = 0;

        HttpGet httpGet = new HttpGet(nextGame);
        httpGet.addHeader("Referer", "https://www.oddsportal.com/soccer/cameroon/elite-one/dragon-de-yaounde-apejes-academy-xUeJGqJk/");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");

        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);

            HttpEntity httpEntity = httpResponse.getEntity();

            responseString = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        parsingData(responseString);
    }

    private void parsingData(String responseString) {
        System.out.println(responseString);
        Map<String, Object> map = new HashMap<>();

        Pattern pattern = Pattern.compile("dat', (\\{.+\\}){1}.+");
        Matcher matcher = pattern.matcher(responseString);

        if(matcher.find()) {
            System.out.println("통과!" + matcher.group(1));
        }
        else {
            System.out.println("안 된단말이다.");
        }
        try {
            ObjectMapper mapper = new ObjectMapper();

            String splitString = responseString.split("dat', ")[1].split("\\);")[0];

            System.out.println(splitString);
            map = mapper.readValue(splitString, new TypeReference<Map<Object, Object>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String key : map.keySet()) {
            logger.debug(map.get(key));
        }
    }

    public static void main(String[] args) {
        FootballScheduleParser footballScheduleParser = new FootballScheduleParser();
        Timer timer1 = new Timer();

        timer1.scheduleAtFixedRate(footballScheduleParser, 0, 1000 * 10);
    }
}

/**
 * oddzpotal 배팅사이트에 따른 id값
 * 14 = 10Bet
 * 80 = 12Bet
 * 424 = 138
 * 56 = 188BET
 * 416 = 18Bet
 * 417 = 1xBet
 * 471 = 1xBet.kz
 * 453 = 1xStavka.ru
 * 500 = 22Bet
 * 154 = 32Red Bet
 * 20 = 5Dimes
 * 422 = 5plusbet
 * 27 = 888sport
 * 388 = 90dakika
 * 369 = Admiral
 * 146 = AllYouBet
 * 476 = Asianodds
 * 469 = Babibet
 * 488 = Bahis Arena
 * 127 = Bestake
 * 125 = Bestbet
 * 137 = Bet Victor
 * 436 = Bet-52
 * 3 = bet-at-home
 * 384 = bet-at-home.it
 * 459 = Bet.pt
 * 367 = Bet1128.it
 * 54 = Bet24
 * 412 = BET2Be
 * 16 = bet365
 * 419 = bet365.it
 * 115 = Bet770
 * 86 = Bet7days
 * 405 = Bet9
 * 123 = Bet911
 * 509 = Bet9ja
 * 421 = Betadonis
 * 171 = Betako
 * 464 = Bethard
 * 2 = bwin
 * ...
 */
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
import java.util.TimerTask;

public class FootballScheduleParser extends TimerTask {

    private static Logger logger = Logger.getLogger(FootballScheduleParser.class.getName());

    static final String nextGame = "https://fb.oddsportal.com/feed/match/1-1-drIMAWEU-5-3-yjf3d.dat?_=" + System.currentTimeMillis() / 1000L;
    static final String nextGameOdds = "https://fb.oddsportal.com/ajax-next-games-odds/1/0/X0/20190305/1/yj9d4.dat?_=" + System.currentTimeMillis() / 1000L;

    @Override
    public void run() {
        parsingLiveGame();
    }

    private void parsingLiveGame() {
        //System.out.println("파싱시작");
        logger.debug("Parsing start");

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(10000)
                .setSocketTimeout(15000).build();

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();

        String responseString = null;
        int responseCode = 0;

        HttpGet httpGet = new HttpGet(nextGame);
        httpGet.addHeader("Referer", "https://www.oddsportal.com/soccer/mexico/liga-mx-women-2018-2019/toluca-club-america-drIMAWEU/");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");

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
        new FootballScheduleParser().parsingLiveGame();
    }
}

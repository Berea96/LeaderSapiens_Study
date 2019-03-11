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

    static final String nextGame = "https://fb.oddsportal.com/feed/match/1-1-drIMAWEU-5-3-yjf5c.dat?_=" + System.currentTimeMillis();
    static final String nextGameOdds = "https://fb.oddsportal.com/ajax-next-games-odds/1/0/X0/20190305/1/yj9d4.dat?_=" + System.currentTimeMillis() / 1000L;

    @Override
    public void run() {
        parsingLiveGame();
    }

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
        httpGet.addHeader("Referer", "https://www.oddsportal.com/soccer/mexico/liga-mx-women-2018-2019/toluca-club-america-drIMAWEU/?r=2");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");

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

        Pattern pattern = Pattern.compile("dat', (\\{.+\\}){1}\\);");
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

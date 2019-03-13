package com.leadersapiens.study.march.parserTest.parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leadersapiens.study.march.parserTest.bean.Bookmaker;
import com.leadersapiens.study.march.parserTest.bean.Bookmakers;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * oddsportal사이트에서의 배팅사이트 정보를 가져오는 클래스
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OddsportalSitesParser extends TimerTask {
    private static Logger logger = Logger.getLogger(OddsportalSitesParser.class.getName());

    private ArrayList<Bookmaker> bookmakers = new ArrayList<>();

    private static final String url = "https://www.oddsportal.com/res/x/bookies-190305102620-" + System.currentTimeMillis() + ".js";

    @Override
    public void run() {
        oddsportalParser();
    }

    public void oddsportalParser() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        String getBody = getHtmlBody();

        System.out.println(getBody);

        Matcher matcher = Pattern.compile("var bookmakersData=\\{\".+\":(\\{.+\\}){1,}\\}.+").matcher(getBody);

        if(!matcher.find()) {
            System.out.println("불통..");
            return;
        } else {
            System.out.println("통과");
            System.out.println(matcher.group(1));
        }

        Bookmaker bookmaker = null;
        try {
            bookmaker = mapper.readValue(matcher.group(1), Bookmaker.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bookmaker);
    }

    public String getHtmlBody() {

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(10000)
                .setSocketTimeout(15000).build();

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();

        String responseString = "";

        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("referer", "https://www.oddsportal.com/bookmaker/1xbet");
        httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");

        HttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpGet);

            HttpEntity httpEntity = httpResponse.getEntity();

            responseString = EntityUtils.toString(httpEntity);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseString;
    }

    public static void main(String[] args) {
        OddsportalSitesParser oddsportalSitesParser = new OddsportalSitesParser();

        Timer timer1 = new Timer();

        timer1.scheduleAtFixedRate(oddsportalSitesParser, 0, 1000 * 10);
    }
}

package com.leadersapiens.study.march.parserTest;

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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * oddsportal사이트에서의 배팅사이트 정보를 가져오는 클래스
 */
public class OddsportalSitesParser extends TimerTask {
    private static Logger logger = Logger.getLogger(OddsportalSitesParser.class.getName());

    static final String url = "https://www.oddsportal.com/res/x/bookies-190305102620-1552279100.js";

    @Override
    public void run() {
        oddsportalParser();
    }

    public void oddsportalParser() {
        ObjectMapper mapper = new ObjectMapper();

        String getBody = getHtmlBody();

        System.out.println(getBody);

        Matcher matcher = Pattern.compile("var bookmakersData = \\{(\\{.*\\}){1,}\\};").matcher(getBody);

        if(matcher.find()) {
            System.out.println("불통..");
        } else {
            System.out.println("통과");
            System.out.println(matcher);
        }
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

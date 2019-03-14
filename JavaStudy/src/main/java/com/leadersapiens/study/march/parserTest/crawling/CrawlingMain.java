package com.leadersapiens.study.march.parserTest.crawling;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

public class CrawlingMain {
    public static String getBody(String url, Map<String, String> headerMap) throws Exception {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(10000)
                .setSocketTimeout(15000).build();

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();

        String responseString = "";

        HttpGet httpGet = new HttpGet(url);

        for(String keySet : headerMap.keySet()) {
            httpGet.addHeader(keySet, headerMap.get(keySet));
        }

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
}

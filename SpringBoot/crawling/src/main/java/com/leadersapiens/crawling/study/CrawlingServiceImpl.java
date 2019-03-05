package com.leadersapiens.crawling.study;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

//crawling Service
@Service
public class CrawlingServiceImpl implements CrawlingService {
    @Override
    public String getData() {

        String url = "https://fb.oddsportal.com/feed/match/1-1-drIMAWEU-1-2-yjab3.dat";
        Document doc = null;
        try {
            doc = Jsoup.connect(url)
                    .data("_", System.currentTimeMillis() / 1000L + "")
                    .header("Remote Address", "188.92.41.44:433")
                    .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36")
                    .get();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc.html();
    }

    private String crawlingSite() {



        return "";
    }
}

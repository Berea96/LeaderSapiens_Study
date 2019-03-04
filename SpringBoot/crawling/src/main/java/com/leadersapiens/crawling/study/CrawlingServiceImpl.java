package com.leadersapiens.crawling.study;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CrawlingServiceImpl implements CrawlingService {
    @Override
    public String getData() {

        String url = "https://fb.oddsportal.com/feed/match/1-1-E3UHKunj-5-2-yjce6.dat";
        Document doc = null;
        try {
            doc = Jsoup.connect(url)
                    .data("_", System.currentTimeMillis() + "")
                    .header("Referer", "https://www.oddsportal.com/soccer/algeria/ligue-1/oran-cr-belouizdad-E3UHKunj/?r=1")
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

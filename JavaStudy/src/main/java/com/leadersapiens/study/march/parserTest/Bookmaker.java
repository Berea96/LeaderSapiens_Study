package com.leadersapiens.study.march.parserTest;

import lombok.Data;

//Oddsportal bookmaker에 대한 Bean
@Data
public class Bookmaker {
    private String idProvider;
    private String webName;
    private String webUrl;
    private String isBookmaker;
    private String isBettingExchange;
    private String url;
    private String defaultBetslipUrl;
    private String active;
    private String newTo;
    private String setNew;
    private String preferredCountryId;
    private String sr;
    private String isPremium;
    private String sortKey;
    private String isNew;
    private Bonus bonus;
}

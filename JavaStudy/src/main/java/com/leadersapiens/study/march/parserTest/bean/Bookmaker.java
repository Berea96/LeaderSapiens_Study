package com.leadersapiens.study.march.parserTest.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

//Oddsportal bookmaker에 대한 bean
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bookmaker {
    private String idProvider;
    private String WebName;
    private String WebUrl;
    private String IsBookmaker;
    private String IsBettingExchange;
    private String Url;
    private String DefaultBetslipUrl;
    private String Active;
    private int NewTo;
    private int SetNew;
    private int PreferredCountryID;
    private int sr;
    private String IsPremium;
    private int sortKey;
    private boolean isNew;
//    private Bonus bonus;
}

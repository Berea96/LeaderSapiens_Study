package com.leadersapiens.study.march.parserTest.bean.schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {
    private Event event;
    private Odds odds;
    private int cnt;
    private boolean[] highlight;
}

package com.leadersapiens.study.march.parserTest.bean.baseball;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaseballSchedule {
    private String gdate;
    private String gtime;
    private String a_team;
    private String h_team;
    private String a_point;
    private String h_point;
    private String stadium;
}

package com.leadersapiens.study.march.parserTest.bean.schedule;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Odd {
    private boolean active;
    private double max;
    private double avg;
    private int res;
    private String oid;
}

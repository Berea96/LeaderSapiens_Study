package com.leadersapiens.study.april;

import java.util.TimerTask;

public class TestTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("timer start");
        forMillionData();
        System.out.println("timer end");
    }

    private void forMillionData() {
        System.out.println("for start...");
        for(int i = 0; i < 1000000000; i++) {

        }
        System.out.println("for end...");
    }
}

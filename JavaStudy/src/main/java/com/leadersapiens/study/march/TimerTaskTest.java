package com.leadersapiens.study.march;

import java.util.Timer;
import java.util.TimerTask;

//2019-03-04일자
public class TimerTaskTest {

    public static int count;

    public static void main(String[] args) {

        count = 0;

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {

                if(count < 5)
                    System.out.println("안녕" + count++);
                else {
                    System.out.println("끝이야");

                    timer.cancel();
                }
            }
        };

        timer.schedule(timerTask, 0, 1000 * 1);
    }
}

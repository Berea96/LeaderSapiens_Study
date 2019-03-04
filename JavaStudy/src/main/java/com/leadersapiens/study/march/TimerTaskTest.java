package com.leadersapiens.study.march;

import java.util.Timer;
import java.util.TimerTask;

//2019-03-04일자
public class TimerTaskTest {

    //반복된 횟수를 출력해주기위한 카운트
    public static int count;

    public static void main(String[] args) {

        count = 0;

        //타이머 라이브러리는 타이머 테스크에 따른 쓰레드를 만들어준다?
        //어쨋든 쓰레드가 생성되어 실행 된다고 생각하면 편할 것이다.
        Timer timer = new Timer();
        //타이머에 들어갈 타이머 테스크
        //추상클래스로 오버라이드를 받아주어야한다
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

        //이 부분이 타이머의 스케줄 메소드를 통해 타이머 테스크의 런메소드를 실행 시켜준다.
        timer.schedule(timerTask, 0, 1000 * 1);
    }
}
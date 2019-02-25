package com.leadersapiens.study.february;


//2019_02_25

public class ProcessTest {

    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("이것은 익명 객체");
            }
        };
        Runnable r2 = () -> System.out.println("이것은 그냥 람다");

        process(r1);
        process(r2);
        process(() -> System.out.println("이것은 바로 람다!"));
    }
}

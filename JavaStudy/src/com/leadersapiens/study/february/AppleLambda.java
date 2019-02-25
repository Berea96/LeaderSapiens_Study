package com.leadersapiens.study.february;

import java.util.ArrayList;
import java.util.List;

//2019_02_22

interface AppleObject {
    Apple getApple();
}

interface ListEmpty {
    boolean isEmpty(List<String> list);
}

interface ApplePrint {
    void printAppleWeight(Apple apple);
}

public class AppleLambda {
    public static void main(String[] args) {
        AppleObject appleObject = () -> new Apple(10);
        System.out.println("Apple Info : " + appleObject.getApple());

        System.out.println("\n=================================\n");

        ListEmpty listEmpty = (stringList) -> stringList.isEmpty();

        List<String> stringList = new ArrayList<String>();

        System.out.println("stringList is Empty? : " + listEmpty.isEmpty(stringList));

        System.out.println("\n=================================\n");

        Apple apple = new Apple(15);

        ApplePrint applePrint = (app) -> System.out.println("Apple Weight : " + app.getWeight());

        applePrint.printAppleWeight(apple);
    }
}

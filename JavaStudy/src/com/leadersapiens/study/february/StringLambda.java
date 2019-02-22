package com.leadersapiens.study.february;

interface StringLength {
    int getLength(String str);
}

interface StringLengthOver {
    boolean getLengthOver(String str);
}

public class StringLambda {

    public static void getLength(String str, StringLength stringLength) {
        System.out.println("String의 길이를 구해보는 람다");
        System.out.println("String Length : " + stringLength.getLength(str));
    }

    public static void getLengthOver(String str, StringLengthOver stringLengthOver) {
        System.out.println("String Length > 10 ? : " + stringLengthOver.getLengthOver(str));
    }

    

    public static void main(String[] args) {
        getLength("This is Lambda", (str) -> str.length());

        System.out.println("\n=================================\n");

        getLengthOver("ThisLambda", (str) -> str.length() > 10);

        System.out.println("\n=================================\n");


    }
}

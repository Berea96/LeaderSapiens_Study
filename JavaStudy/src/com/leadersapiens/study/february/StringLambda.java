package com.leadersapiens.study.february;

interface StringLength {
    int getLength(String str);
}

public class StringLambda {

    public static void getLength(String str, StringLength stringLength) {
        System.out.println("String Length : " + stringLength.getLength(str));
    }

    public static void main(String[] args) {
        getLength("This is Lambda", (str) -> str.length());
    }
}

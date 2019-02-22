package com.leadersapiens.study.february;

interface StringLength {
    int getLength(String str);
}

interface StringLengthOver {
    boolean getLengthOver(String str);
}

interface StringLengthPlus {
    int getLengthPlus(String str1, String str2);
}

interface StringPrint {
    void printString();
}

public class StringLambda {

    public static void getLength(String str, StringLength stringLength) {
        System.out.println("String의 길이를 구해보는 람다");
        System.out.println("String Length : " + stringLength.getLength(str));
    }

    public static void getLengthOver(String str, StringLengthOver stringLengthOver) {
        System.out.println("String Length > 10 ? : " + stringLengthOver.getLengthOver(str));
    }

    public static void getLengthPlus(String str1, String str2, StringLengthPlus stringLengthPlus) {
        System.out.println("String1 Length : " + str1.length());
        System.out.println("String2 Length : " + str2.length());

        System.out.println("String Length Plus : " + stringLengthPlus.getLengthPlus(str1, str2));
    }

    public static void main(String[] args) {
        getLength("This is Lambda", (str) -> str.length());

        System.out.println("\n=================================\n");

        getLengthOver("ThisLambda", (str) -> str.length() > 10);

        System.out.println("\n=================================\n");

        getLengthPlus("This is Lambda", "ThisLambda", (str1, str2) -> str1.length() + str2.length());

        System.out.println("\n=================================\n");

        StringPrint stringPrint = () -> System.out.println("헬로우");

        stringPrint.printString();
    }
}

package com.leadersapiens.study.april.binary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BinaryTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);;

        while(true) {
            try {
                System.out.println("2진수로 변환할 정수를 입력해주세요.");

                int number = sc.nextInt();
                int orginal_number = number;

                if(number == 0) break;

                String binary = "";

                while (true) {
                    int trash = number % 2;
                    number = (int) (number / 2.0);

                    binary = trash + "" + binary;

                    if (number == 1) {
                        binary = number + binary;
                        break;
                    } else if (number == 0) {
                        binary = number + binary;
                    }

                }

                System.out.println(orginal_number + " : " + binary);
            } catch (InputMismatchException e) {
                System.out.println("똑바로 입력해라");
            } catch (NumberFormatException e) {
                System.out.println("똑바로 입력해라");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sc.close();
            }
        }
    }
}

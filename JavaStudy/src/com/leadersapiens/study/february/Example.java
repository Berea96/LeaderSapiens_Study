package com.leadersapiens.study.february;

import java.util.ArrayList;
import java.util.List;

//2019_02_22
public class Example {
    public static void findChicagoImperative(final List<String> cities) {
        for(String city : cities) {
            if(city.equals("Chicago")) {
                System.out.println("Found chicago? : True");
                return;
            }
        }
    }

    public static void findChicagoImperative2(final List<String> cities) {
        System.out.println("Found chicago? : " + cities.contains("Chicago"));
    }

    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("NewYork");
        cities.add("Chicago");
        cities.add("Hawaii");
        List<String> cities2 = new ArrayList<>();
        cities.add("NewYork");
        cities.add("California");
        cities.add("Hawaii");

        findChicagoImperative(cities);
        findChicagoImperative2(cities2);
    }
}

package com.leadersapiens.study.february;

import java.util.ArrayList;
import java.util.List;

public class PredicateTest {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for(T t : list) {
            if(predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.add(new Apple(150, 1000, "red"));
        inventory.add(new Apple(130, 1200, "blue"));

        List<Apple> filterApple = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(filterApple);
    }
}
package com.leadersapiens.study.february;

import java.util.ArrayList;
import java.util.List;

class Apple {
    private int weight;
    private int price;
    private String color;

    public Apple() {
    }

    public Apple(int weight, int price, String color) {
        this.weight = weight;
        this.price = price;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }
    public int getPrice() {
        return price;
    }
    public String getColor() {
        return color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setColor(String color) {
        this.color = color;
    }
}

interface ApplePredicate {
    public boolean test(Apple apple);
}

class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

public class Predicate_ex_1 {

    public static List<Apple> filterApplePredicate(List<Apple> inventory, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Apple apple = new Apple(100, 1000, "red");
        Apple apple2 = new Apple(160, 1000, "blue");

        AppleHeavyWeightPredicate appleHeavyWeightPredicate = new AppleHeavyWeightPredicate();

        System.out.println(appleHeavyWeightPredicate.test(apple));
        System.out.println(appleHeavyWeightPredicate.test(apple2));

        System.out.println("\n===========================================\n");

        List<Apple> appleList = new ArrayList<>();

        appleList.add(new Apple(160, 1000, "red"));
        appleList.add(new Apple(130, 1000, "blue"));
        appleList.add(new Apple(120, 1000, "green"));
        appleList.add(new Apple(170, 1000, "yellow"));

        List<Apple> resultApple =
            filterApplePredicate(appleList, new AppleHeavyWeightPredicate());

        for(Apple app : resultApple) {
            System.out.println(app.getColor());
        }
    }

}

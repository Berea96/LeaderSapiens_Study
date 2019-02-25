package com.leadersapiens.study.february;

import java.util.ArrayList;
import java.util.List;

//2019_02_22

class Apple {
    private int weight;
    private int price;
    private String color;

    public Apple() {
    }

    public Apple(int weight) {
        this.weight = weight;
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

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
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

        List<Apple> inventory = new ArrayList<>();

        inventory.add(new Apple(160, 1000, "red"));
        inventory.add(new Apple(130, 1000, "blue"));
        inventory.add(new Apple(120, 1000, "green"));
        inventory.add(new Apple(170, 1000, "yellow"));

        List<Apple> resultApple =
            filterApplePredicate(inventory, new AppleHeavyWeightPredicate());

        for(Apple app : resultApple) {
            System.out.println(app.getColor());
        }

        System.out.println("\n===========================================\n");

        List<Apple> filterAnonymousPredicate = filterApplePredicate(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        for(Apple app : filterAnonymousPredicate) {
            System.out.println(app.getColor());
        }

        List<Apple> filterLambdaPredicate = filterApplePredicate(inventory, (apple3) -> "red".equals(apple3.getColor()));
        System.out.println(filterLambdaPredicate);
    }

}

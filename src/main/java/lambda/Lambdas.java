package lambda;

import java.util.ArrayList;
import java.util.List;

public class Lambdas {

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    static class Apple {
        private int weight;
        private String color;

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    @FunctionalInterface
    interface ApplePredicate{
        boolean test(Apple a);
    }
}
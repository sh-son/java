package lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LambdasTest {

    @Test
    public void ApplePredicate() {
        Lambdas lambdas = new Lambdas();

        Runnable r = () -> System.out.println("Hello!");
        r.run();


        List<Lambdas.Apple> inventory = Arrays.asList(new Lambdas.Apple(80,"green"), new Lambdas.Apple(155, "green"), new Lambdas.Apple(120, "red"));

        List<Lambdas.Apple> greenApples = lambdas.filter(inventory, (Lambdas.Apple a) -> "green".equals(a.getColor()));

        List<String> testList = new ArrayList<>();
        for(Lambdas.Apple item : greenApples) {
            testList.add(item.getColor());
        }
        assertThat(testList, contains("green", "green"));


        Comparator<Lambdas.Apple> c = (Lambdas.Apple a1, Lambdas.Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        inventory.sort(c);

        assertEquals((int)inventory.get(0).getWeight(), 80);
    }

}
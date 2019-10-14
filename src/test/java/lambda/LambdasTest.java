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
    public void testPredicate() {

        Runnable r = () -> System.out.println("Hello!");
        r.run();


        List<Lambdas.Apple> inventory = Arrays.asList(new Lambdas.Apple(80,"green"), new Lambdas.Apple(155, "green"), new Lambdas.Apple(120, "red"));

        List<Lambdas.Apple> greenApples = Lambdas.filter(inventory, a -> "green".equals(a.getColor()));

        List<String> testList = new ArrayList<>();
        for(Lambdas.Apple item : greenApples) {
            testList.add(item.getColor());
        }
        assertThat(testList, contains("green", "green"));


        Comparator<Lambdas.Apple> c = (a1, a2) -> new Integer(a1.getWeight()).compareTo(a2.getWeight());
        inventory.sort(c);

        assertEquals(inventory.get(0).getWeight(), 80);
    }

}
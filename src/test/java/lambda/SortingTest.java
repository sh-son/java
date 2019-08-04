package lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    public void AppleComparator(){
        // 1
        List<Sorting.Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Sorting.Apple(80,"green"), new Sorting.Apple(155, "green"), new Sorting.Apple(120, "red")));

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        inventory.sort(new Sorting.AppleComparator());
        assertEquals((int)inventory.get(0).getWeight(), 80);


        // 2
        inventory.set(1, new Sorting.Apple(30, "green"));

        // [Apple{color='green', weight=30}, Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        inventory.sort(new Comparator<Sorting.Apple>() {
            public int compare(Sorting.Apple a1, Sorting.Apple a2){
                return a1.getWeight().compareTo(a2.getWeight());
            }});
        assertEquals((int)inventory.get(0).getWeight(), 30);


        // 3
        inventory.set(1, new Sorting.Apple(20, "red"));

        // [Apple{color='red', weight=20}, Apple{color='green', weight=30}, Apple{color='green', weight=155}]
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        assertEquals((int)inventory.get(0).getWeight(), 20);


        // 4
        inventory.set(1, new Sorting.Apple(10, "red"));

        // [Apple{color='red', weight=10}, Apple{color='red', weight=20}, Apple{color='green', weight=155}]
        inventory.sort(comparing(Sorting.Apple::getWeight));
        assertEquals((int)inventory.get(0).getWeight(), 10);
    }

}
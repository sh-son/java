package stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

public class TraderAndTransactionTest {

    @Test
    public void testStream() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오
        List<Transaction> tr2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        assertAll(
                () -> assertEquals(tr2011.get(0).getYear(), 2011),
                () -> assertEquals(tr2011.get(0).getValue(), 300));


        // 거래자가 근무하는 모든 도시를 중복 없이 나열하시오. (test 를 위해 출력대신 count 체크)
        long trCount = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .count();

        assertEquals(trCount, 2);


        // 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오
        List<Trader> cambridgeNameList = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        assertEquals(cambridgeNameList.get(0).getName(), "Alan");


        // 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오
        String sortedTraderName = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(a, b) -> a + b);

        assertAll(
                () -> assertTrue(sortedTraderName.startsWith("Alan")),
                () -> assertTrue(sortedTraderName.endsWith("Raoul")));


        // 밀라노에 거래자가 있는가?
        boolean milanBased = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        assertTrue(milanBased);


        // 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);


        // 전체 트랜잭션 중 최댓값은 얼마인가?
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        assertEquals(Optional.of(max.get()), Optional.of(1000));


        // 전체 트랜잭션 중 최솟값을 얼마인가?
        Optional<Integer> min = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);

        assertEquals(Optional.of(min.get()), Optional.of(300));


        // 피보나치 연습
        Stream.iterate(new int[] {0,1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        long a = Stream.iterate(new int[] {0,1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(a);
    }
}

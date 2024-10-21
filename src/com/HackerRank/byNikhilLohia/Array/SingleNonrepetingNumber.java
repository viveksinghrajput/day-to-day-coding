package com.HackerRank.byNikhilLohia.Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleNonrepetingNumber {

    public static void main(String[] args) {

       List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,2,3,4,6,7,8,9);
       List<Integer> nonRepetingNum  = findSingleNonRepetingNum(list);
       System.out.println(nonRepetingNum);
    }

    private static List<Integer> findSingleNonRepetingNum(List<Integer> list) {

        Map<Integer, Long> frequencyMap
                = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> integerList = frequencyMap.entrySet().stream().filter(val -> val.getValue() ==1)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        return integerList;
    }
}

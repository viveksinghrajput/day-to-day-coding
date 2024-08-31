package com.string;

import java.util.*;
import java.util.stream.Collectors;

public class SortPeople {
    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
      List<String> str=  findSortPeople(names,heights);
      System.out.println(str);
    }

    private static List<String> findSortPeople(String[] names, int[] heights) {
        int numOfPeople = names.length;
        Map<Integer,String> heightToNameMap = new HashMap<>();
        if (numOfPeople!=heights.length){
            return new ArrayList<>(Arrays.asList("Not a valid combination"));
        }
        for (int i=0; i<numOfPeople;i++){
            heightToNameMap.put(heights[i],names[i]);
        }
        List<String> collect = heightToNameMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return collect;
    }
}

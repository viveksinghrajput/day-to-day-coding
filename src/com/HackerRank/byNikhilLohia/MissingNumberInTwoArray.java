package com.HackerRank.byNikhilLohia;

import java.util.*;
import java.util.stream.Collectors;

public class MissingNumberInTwoArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3,4,5,6,7,1,7,8};
        int[] arr2 = {2,3,5,7,8};
      int[] arr=  findMissingNum(arr1,arr2);
      for (int i : arr){
          System.out.print(i+" ");
      }
    }

    private static int[] findMissingNum(int[] arr1, int[] arr2) {
        Map<Integer,Integer> arrMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr2){
            if (arrMap.containsKey(num)){
                arrMap.put(num,arrMap.get(num)+1);
            }else{
                arrMap.put(num,1);
            }
        }
         for (int num : arr1)
         {
             if (arrMap.containsKey(num) && arrMap.get(num)>0){
                arrMap.put(num,arrMap.get(num)-1);
             }else{
                 list.add(num);
             }
         }


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

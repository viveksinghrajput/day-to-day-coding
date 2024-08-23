package com.string;

import java.util.ArrayList;
import java.util.List;

public class FindWordContaingCharacter {
    public static void main(String[] args) {
        String[] str = {"leet","code","aab","aef"};
        char x = 'e';
        List<Integer> findWordContaining = findWordContaining(str,x);
        System.out.print(findWordContaining);
    }

    private static List<Integer> findWordContaining(String[] str, char x) {
        List<Integer> al = new ArrayList<>();
        for (int i=0;i<str.length;i++){
            if(str[i].indexOf(x) !=-1){
                al.add(i);
            }
        }
        return al;
    }
}

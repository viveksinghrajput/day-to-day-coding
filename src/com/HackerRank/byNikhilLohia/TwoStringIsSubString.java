package com.HackerRank.byNikhilLohia;

import com.sun.xml.internal.ws.policy.subject.WsdlBindingSubject;

import java.util.HashSet;
import java.util.Set;

public class TwoStringIsSubString {
    public static void main(String[] args) {
        String str1 ="barbell";
        String str2 ="trapper";

        String subString = checkTwoStringIsSubstring(str1,str2);
        System.out.println("Substring is "+ subString);
    }

    private static String checkTwoStringIsSubstring(String str1, String str2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char chr :str1.toCharArray()){
            set1.add(chr);
        }
        for (char chr :str2.toCharArray()){
            set2.add(chr);
        }
    // store the set intersection in set1
        set1.retainAll(set2);
        if(!set1.isEmpty()){
            return "Yes";
        }else{
            return "No";
        }
    }
}

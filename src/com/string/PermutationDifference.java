package com.string;

public class PermutationDifference {
    public static void main(String[] args) {
        String s= "abcde";
        String t = "edbac";
      int output =  findPermutationDiff(s,t);
      System.out.println(output);
    }

    private static int findPermutationDiff(String s, String t) {
        int res = 0;
        for (int i=0;i<s.length();i++){
            for (int j=0;j<t.length();j++){
                if (s.charAt(i)==t.charAt(j)){
                    res+= Math.abs(i-j);
                }
            }
        }

        return res;
    }
}

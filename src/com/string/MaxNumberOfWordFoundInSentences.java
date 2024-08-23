package com.string;

public class MaxNumberOfWordFoundInSentences {
    public static void main(String[] args) {
        String[] str = {"alice and bob love leetcode","i think so too","this is great thanks very much"};
        int count = mostWordFound(str);
        System.out.print(count);
    }

    private static int mostWordFound(String[] sentences) {
        int ans =0;
        for (int i=0; i<sentences.length;i++){
            String str = sentences[i];
            String[] arr = str.split(" ");
            if (ans<arr.length){
                ans = arr.length;
            }
        }

        return ans;
    }
}

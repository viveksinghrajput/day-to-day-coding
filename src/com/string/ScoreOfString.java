package com.string;

import sun.text.normalizer.UTF16;

public class ScoreOfString {
    public static void main(String[] args) {
        String str = "hello";
       int score= findScoreOfString(str);
       System.out.println("score is ::"+score);
    }
    public static int findScoreOfString(String str) {
        //     str=hello
        //     |e-h|+|l-e|+|l-l|+|o-l|
        int score =0;
        for (int i=1;i<str.length();i++){
            score += Math.abs(str.charAt(i)- str.charAt(i - 1));
        }
        return score;
    }
}

package com.string;

public class FirstPalindromeNumber {
    public static void main(String[] args) {


        String[] words ={"abc","car","ada","racecar","cool"};

        String str = firstPalindrome(words);
        System.out.println(str);


    }

    private static String firstPalindrome(String[] words) {
        for (String word : words){
            if(palindromeNumber(word)){
                return word;
            }
        }
        return "";
    }

    private static boolean palindromeNumber(String word) {
        int left =0;
        int right = word.length()-1;
        while (left<=right){
            if (word.charAt(left)!=word.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

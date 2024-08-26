package com.string;

public class ReversePrefixWord {
    public static void main(String[] args) {
        String inputStr = "abcdefd"; // abcd efd
        char ch = 'd';
        String reversePrefix = reversePrefix(inputStr,ch);
        System.out.println(reversePrefix);
    }

    private static String reversePrefix(String inputStr, char ch) {
        int left = 0;
        int right = inputStr.indexOf(ch);
        StringBuffer sb = new StringBuffer(inputStr);
        while (left<right){
            char temp = sb.charAt(left);
            sb.setCharAt(left,inputStr.charAt(right));
            sb.setCharAt(right,temp);
            left++;
            right--;
        }
        return sb.toString();
    }
}

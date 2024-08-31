package com.string;

public class PangramCheck {
    public static void main(String[] args) {
       // String str ="thequickbrownfoxjumpsoverthelazydog";
        String str ="leetcode";

        boolean b = checkIfPangram(str);
        System.out.println(b);
    }
    public static boolean checkIfPangram(String sentence) {

        int size = sentence.length();
        int[] arr= new int[26];
        for(char chr : sentence.toCharArray()){
            arr[chr - 'a']++;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                return false;
            }
        }
        return true;
    }
}

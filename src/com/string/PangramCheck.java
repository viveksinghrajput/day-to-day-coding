package com.string;

public class PangramCheck {
    public static void main(String[] args) {
       String str = "thequickbrownfoxjumpsoverthelazydog";
      // String str = "leetcode";
        boolean b = ifPangram(str);
        System.out.println(b);
    }

    private static boolean ifPangram(String str) {
        int[] arr = new int[26];
        for (char chr : str.toCharArray()){
            arr[chr-'a']++;
        }
        for (int i=0;i< arr.length;i++){
            if(arr[i]==0){
                return false;
            }
        }

        return true;
    }

}

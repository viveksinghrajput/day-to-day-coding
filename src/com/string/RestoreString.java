package com.string;

public class RestoreString {
    public static void main(String[] args) {
        String input = "abc";
        int[] indices = {0,1,2};
        String str= restoreString(input,indices);
        System.out.println(str);

    }
    public static String restoreString(String s, int[] indices) {

        int length=s.length();
        StringBuilder sb=new StringBuilder("");
        char c[]=new char[length];
        for(int i=0;i<length;i++){
            c[indices[i]]=s.charAt(i);
        }
        sb.append(c);
        return sb.toString();
    }
}

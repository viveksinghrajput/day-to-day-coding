package com.string;

public class LowerCase {
    public static void main(String[] args) {
        String str = "PiTAs";
        String toLower = toLowerCase(str);
        System.out.println(toLower);
    }
    public static String toLowerCase(String s) {
        StringBuffer sb = new StringBuffer();
        for (char chr : s.toCharArray()){
            if (chr >='A' && chr <= 'Z'){
                sb.append(Character.toLowerCase(chr));
            }else {
                sb.append(chr);
            }
        }
        return sb.toString();
    }
}

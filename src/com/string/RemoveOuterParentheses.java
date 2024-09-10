package com.string;

public class RemoveOuterParentheses {
    public static void main(String[] args) {
        String str = "(()())(())";
        String string = removeOuterParentheses(str);
        System.out.println(string);
    }

    private static String removeOuterParentheses(String str) {
        StringBuffer sb = new StringBuffer();
        int count =0;
        for (char chr : str.toCharArray()){
            if (chr == '(' && count++ > 0){
                sb.append(chr);
            }
            if (chr == ')' && count-- >1){
                sb.append(chr);
            }
        }
        return sb.toString();
    }


}

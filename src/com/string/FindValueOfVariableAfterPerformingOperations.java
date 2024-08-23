package com.string;

public class FindValueOfVariableAfterPerformingOperations {

    public static void main(String[] args) {
        String[] str ={"--X","X--","X++","++X","X++"};
        int finalValue = finalValueAfterOperation(str);
        System.out.println("Final value :: "+finalValue);

    }

    private static int finalValueAfterOperation(String[] str) {
        int a =0;
        for (int i=0;i<str.length;i++){
            if (str[i].equals("--X")||str[i].equals("X--")){
               -- a;
            } else if (str[i].equals("++X")||str[i].equals("X++")) {
                ++a;
            }
        }
        return a;
    }
}

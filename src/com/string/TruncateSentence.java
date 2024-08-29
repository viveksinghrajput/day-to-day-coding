package com.string;

public class TruncateSentence {
    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k=4;
        String[] str = s.split(" ");
      String truncateSent=  truncateSentence(str,k);
      System.out.println(truncateSent);
    }

    private static String truncateSentence(String[] s, int k) {
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<s.length;i++){
            if (i==k){
                break;
            }else {
                sb.append(s[i]).append(" ");
            }
        }

        return sb.toString().trim();
    }
}

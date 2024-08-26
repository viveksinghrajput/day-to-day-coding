package com.string;

public class DefangingIpAddress {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        //output = "1[.]1[.]1[.]1"
        String defangIpAddress = defangIpAddress(address);
        System.out.println(defangIpAddress);
    }

    private static String defangIpAddress(String address) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i=0 ; i<address.length();i++){
            if (address.charAt(i) !='.'){
                stringBuffer.append(address.charAt(i));
            }else {
                stringBuffer.append("[.]");
            }
        }

        return stringBuffer.toString();
    }
}

package com.HackerRank.byNikhilLohia;

public class MissingNumbers {
    public static void main(String[] args) {
        int[] arr = {6,1,2,8,3,4,7,10,5};
        int size =10;
        //if only one number is missing from the given array and array have serial number
      int missingNum =  findMissingNumber(arr,size);
      System.out.println(missingNum);

    }

    private static int findMissingNumber(int[] arr, int size) {
        int sumOfNumber = (size*(size+1))/2;
        int sum=0;
        for (int num :arr){
            sum = sum+num ;
        }

        return sumOfNumber-sum;
    }
}

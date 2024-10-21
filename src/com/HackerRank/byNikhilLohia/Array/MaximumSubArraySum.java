package com.HackerRank.byNikhilLohia.Array;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2,-5,6,-2,-3,1,5,6};
        int maxSubArr = findMaxSubArray(arr);
        System.out.println(maxSubArr);
    }

    private static int findMaxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int curr_max = nums[0];

        for (int i=0;i<nums.length;i++){

            curr_max = Math.max(nums[i],nums[i]+curr_max);

            max_so_far = Math.max(curr_max,max_so_far);
        }
        return max_so_far;
    }
}

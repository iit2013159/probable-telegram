package leetcode;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7};
        rotate(a,3);
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));
    }
    public static void rotate(int[] nums, int k) {
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public static void reverse(int[] nums,int start,int end){
        if(start >= end){
            return;
        }
        int n = end;
        for(int i = start ; i <= (start+end)/2;i++){
            int temp = nums[start + n-i];
            nums[start +n-i] = nums[i];
            nums[i] = temp;
        }
    }
}

package leetcode;

import java.util.Iterator;
import java.util.Map;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        char[] c =String.valueOf(x).toCharArray();
        if(x > 0){
            reverse(c,0,c.length-1);
        }else{
            reverse(c,1,c.length-1);
        }
        return Integer.parseInt(String.valueOf(c));
    }
    public static void reverse(char[] nums,int start,int end){
        if(start >= end){
            return;
        }
        int n = end;
        for(int i = start ; i <= (start+end)/2;i++){
            char temp = nums[start + n-i];
            nums[start +n-i] = nums[i];
            nums[i] = temp;
        }
        Map a;
    }
}

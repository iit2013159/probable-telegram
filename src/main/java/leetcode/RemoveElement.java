package leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
       // process(new int[]{0,1,2,2,3,0,4,2},2);
        process(new int[]{1},1);

    }
    public static int process(int[] nums,int val){
        int rs = removeElement(nums,val);
        Arrays.stream(nums).limit(rs).forEach(j -> System.out.print(" "+j));
        System.out.println(rs);
return rs;
    }
    public static int removeElement(int[] nums, int val) {
        int r = nums.length -1 ,i = 0;
        int count = 0;
        while(i <= r){
            if(nums[i] == val){
                nums[i] = nums[r];
                nums[r] = 0;
                r--;
                count++;
                continue;
            }
            i++;
        }
        return nums.length - count;
    }
}

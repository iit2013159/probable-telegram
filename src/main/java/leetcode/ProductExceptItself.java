package leetcode;

import java.util.Arrays;

public class ProductExceptItself {
    public static void main(String[] args) {
        Arrays.stream(productExceptSelf(new int[]{1, 2, 3, 4}))
                .forEach(System.out::println);
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int[] rs = new int[nums.length];
        rs[nums.length - 1] = nums[nums.length - 1];
        for (int i = rs.length - 2; i > 0; i--) {
            rs[i] = nums[i] * rs[i + 1];
        }
        //rs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] *= nums[i - 1];
        }

        for (int i = 0; i < rs.length; i++) {
            if (i == 0) {
                rs[i] = rs[i + 1];
            } else if (i == nums.length - 1) {
                rs[i] = nums[i - 1];
            } else {
                rs[i] = nums[i - 1] * rs[i + 1];
            }

        }
        return rs;
    }
}

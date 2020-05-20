package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{3, 2, 3}, 6)).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ar = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (ar.containsKey(target - nums[i])) {
                int index = ar.get(target - nums[i]);
                if (index != i) {
                    int[] rt = {index, i};
                    return rt;
                }
            } else {
                //int def = ar.getOrDefault(nums[i], 0);
                ar.put(nums[i], i);
            }
        }
        return null;
    }
}

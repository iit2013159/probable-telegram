package leetcode;

import java.util.Arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(search(new int[]{4, 5, 1, 2, 3}, 1));
        System.out.println(search(new int[]{2, 3, 4, 5, 1}, 1));
        System.out.println(search(new int[]{8, 1, 2, 3, 4, 5, 6, 7}, 6));


    }

    public static int search(int[] nums, int target) {
        Arrays.stream(nums).forEach(i -> System.out.print(" " + i));
        if (nums.length <= 3) {
            for (int n = 0; n < nums.length; n++) {
                if (nums[n] == target) {
                    return n;
                }
            }
            return -1;
        }
        int point = rotatedAt(nums);
        System.out.println("converged at index" + point);
        int searchFirst = Arrays.binarySearch(nums, 0, point + 1, target);
        if (searchFirst < 0) {
            searchFirst = Arrays.binarySearch(nums, point + 1, nums.length, target);
        }
        return searchFirst < 0 ? -1 : searchFirst;
    }

    public static int rotatedAt(int[] nums) {
        int lo = 0;
        final int len = nums.length;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (mid - 1 >= 0 && nums[mid] > nums[mid - 1] && nums[mid] > nums[(mid + 1) % len]) {
                return mid;
            } else if (mid == lo && lo == 0 && hi != 0) {
                lo = hi;
                hi = len - 1;
            } else if (nums[mid] <= nums[len - 1]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return 0;
    }
}

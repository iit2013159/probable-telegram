package leetcode;

import java.util.Arrays;

/**
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 * Note:
 * <p>
 * Your solution should be in logarithmic complexity.
 */
public class PeakElement {
    public static void main(String[] args) {
        //wrapper(new int[]{1,2,1,3,5,6,4},new int[]{1,5});
        //wrapper(new int[]{2,1,2},new int[]{1});
        wrapper(new int[]{3, 4, 3, 2, 1}, new int[]{1});


    }

    private static void wrapper(int[] nums, int[] expectedAnswer) {
        System.out.println(peakElement(nums));
    }

    private static int peakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int len = nums.length;
        int mid = 0;
        if (len < 3) {
            int maxElement = Arrays.stream(nums).max().getAsInt();
            return Arrays.binarySearch(nums, maxElement);
        }
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (mid + 1 < len && mid - 1 >= 0 && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (mid + 1 < len && mid - 1 >= 0 && nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                hi = mid - 1;
            } else if (mid + 1 < len && mid - 1 >= 0 && nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                lo = mid + 1;
            } else {
                //if(nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1]){
                if (mid + 1 < len && mid - 1 >= 0 && nums[mid - 1] < nums[mid + 1]) {
                    lo = mid + 1;
                } else if (mid + 1 < len && mid - 1 >= 0 && nums[mid - 1] >= nums[mid + 1]) {
                    hi = mid - 1;
                } else {
                    //either mid-1 == 0 or mid +1 == n
                    if (mid - 1 <= 0 && nums[mid + 1] > nums[mid]) {
                        lo = mid + 1;
                    } else if (mid + 1 >= len && nums[mid - 1] > nums[mid]) {
                        hi = mid - 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
}

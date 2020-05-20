package leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class FindMinInSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2, 1}));
        System.out.println(findMin(new int[]{1, 2, 3}));

    }

    public static int findMin(int[] nums) {
        int len = nums.length;
        int rt = rotatedAt(nums);
        if (rt == nums.length - 1) {
            return nums[0];
        }
        if (rt == 0 && nums[rt] > nums[(rt + 1) % len]) {
            return nums[1];
        } else if (rt == 0 && nums[rt] <= nums[(rt + 1) % len]) {
            return nums[0];
        }
        return nums[rt + 1];
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

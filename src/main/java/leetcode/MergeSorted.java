package leetcode;

import java.util.Arrays;

/**
 * Merge Sorted Array
 * Solution
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class MergeSorted {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        //merge(new int[]{1}, 1, new int[]{}, 0);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = 0; //for num1
        int r = 0; //for num2
        while (l < nums1.length && r < n) {
            Arrays.stream(nums1).forEach(j -> System.out.print(j + " "));
            System.out.println();

            if (nums1[l] >= nums2[r] || l == m) {
                for (int i = m; i > l && i < nums1.length; i--) {
                    nums1[i] = nums1[i - 1];
                }
                nums1[l] = nums2[r];
                m++;
                r++;
                l++;
            } else {
                l++;
            }
        }
        Arrays.stream(nums1).forEach(j -> System.out.print(j + " "));
    }
}

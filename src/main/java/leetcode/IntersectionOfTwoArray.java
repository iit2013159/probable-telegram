package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that
 * you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        Arrays.stream(intersect(new int[]{1, 2, 2, 1},
                                new int[]{2, 2}))
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Map<Integer, Long> map = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                                               Collectors.counting()));
       List<Integer> list = new ArrayList();
        for(int i : nums2){
           if(map.containsKey(i)){
               if(map.get(i) > 1){
                   map.put(i,map.get(i)- 1);
               }else {
                   map.remove(i);
               }
               list.add(i);
           }
       }
        return list.stream().mapToInt(Number::intValue).toArray();

    }
}

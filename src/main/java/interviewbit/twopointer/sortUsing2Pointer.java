package interviewbit.twopointer;

import java.util.Arrays;
import java.util.List;

/**
 * Given an unsorted array which has only 3 values of 0,1,2.
 * sort the array in single pass in O(n) time complexity ,
 * avoid counting and O(1) spaces.
 * <p>
 * <p>
 * If counting was allowed just we have to count the occurrence of the elements.
 * If Extra space was allowed than we would have hashtable/hashmap.
 * <p>
 * E.g. 1,1,0,2,2,0,1,2,0
 */
public class sortUsing2Pointer {
    public static void main(String[] args) {
        sort(Arrays.asList(1,
                           1,
                           0,
                           2,
                           2,
                           0,
                           1,
                           2,
                           0)).forEach(j -> System.out.print(j + " "));
        System.out.println();
        sort(Arrays.asList(0,
                           2,
                           0,
                           1,
                           1,
                           0,
                           2,
                           2,
                           0,
                           1,
                           2,
                           0)).forEach(j -> System.out.print(j + " "));
        System.out.println();
        sort(Arrays.asList(0,
                           0,
                           1,
                           1,
                           2,
                           2,
                           1,
                           1,
                           2,
                           0)).forEach(j -> System.out.print(j + " "));
    }

    private static void swap(int a, int b) {
        int temp = b;
        b = a;
        a = b;
    }

    private static List<Integer> sort(List<Integer> a) {
        //Approach 1 --> left 0. right 2 middle 1, if find then shift it.
        int left = 0, mid = 0, right = a.size() - 1;
        while (mid <= right) {
            if (a.get(left) == 0) {
                left++;
                mid++;
            } else if (a.get(mid) == 0) {
                int temp = a.get(mid);
                a.set(mid, a.get(left));
                a.set(left, temp);
                left++;
                mid++;
            } else if (a.get(mid) == 2) {
                int temp = a.get(mid);
                a.set(mid, a.get(right));
                a.set(right, temp);
                right--;
            } else {
                mid++;
            }
            a.forEach(j -> System.out.print(j + " "));
            System.out.println("mid -->" + mid + " left --> " + left + " right-->" + right);
        }
        return a;
    }
}

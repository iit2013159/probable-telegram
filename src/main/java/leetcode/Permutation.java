package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
 /* [[5,4,6,2], -->ok
[5,4,2,6], -->ok
[5,6,4,2], -->ok
[5,6,2,4], -->ok
[5,2,4,6], -->ok
[5,2,6,4], -->ok
[4,5,6,2], -->ok
[4,5,2,6], -->ok
[4,6,5,2], -->ok
[4,6,2,5], -->ok
[4,2,5,6],
[4,2,6,5], -->ok
[6,5,4,2], -->ok
[6,5,2,4], -->ok
[6,4,5,2], -->ok
[6,4,2,5], -->ok
[6,2,5,4],
[6,2,4,5], -->ok
[2,5,4,6], -->ok
[2,5,6,4], -->ok
[2,4,5,6], -->ok
[2,4,6,5], -->ok
[2,6,5,4], -->ok
[2,6,4,5]] -->ok
 */
public class Permutation {
    public static void main(String[] args) {
        System.out.println(process(permute(1,
                                           2,
                                           3)));
        //System.out.println(process(permute(5,4,6,2)));

    }

    private static String process(List<List<Integer>> data) {
        String s = "";
        s = data.stream()
                .map(j -> j.stream()
                        .map(k -> String.valueOf(k))
                        .collect(Collectors.joining(" "))
                    )
                //.sorted()
                .collect(Collectors.joining("\n"));
        //System.out.println(s);
        return s;
    }

    public static List<List<Integer>> permute(int... nums) {
        List<List<Integer>> sol = new ArrayList<>();
        prUtil(nums,
               0,
               nums.length,
               sol);
        return sol;
    }

    private static List<Integer> arraToList(int[] ints) {
        return IntStream.of(ints)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void prUtil(int[] s, int left, int right, List<List<Integer>> sol) {
        if (sol.contains(arraToList(s))) {
            return;
        }
        sol.add(arraToList(s));
        if (left == right) {
            return;
        }
        for (int i = left; i < right; i++) {
            swapCases(s,
                      i,
                      left);
            prUtil(s,
                   left + 1,
                   right,
                   sol);
            swapCases(s,
                      i,
                      left);
        }
    }

    private static void swapCases(int[] nums, int i, int j) {
        if (i > j) {
            int re = i;
            i = j;
            j = re;
        }
        if (j >= nums.length) {
            j = j % nums.length;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

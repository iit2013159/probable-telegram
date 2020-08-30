package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        List<List<Integer>> output = subsetsBacktrack(1,
                                                      2,
                                                      3);
        print(output);
        List<List<Integer>> outp = subsets(1,
                                           2,
                                           3,
                                           4);
        print(outp);
    }

    private static void print(List<List<Integer>> output) {
        output.stream()
                .forEach(j -> {
                    j.stream()
                            .forEach(k -> System.out.print(k + " "));
                    System.out.println();
                });
    }

    public static List<List<Integer>> subsets(int... nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr) {{
                    add(num);
                }});
            }
            output.addAll(newSubsets);
        }
        return output;
    }

    public static List<List<Integer>> subsetsBacktrack(int... nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        backtrack(res,
                  new ArrayList<>(),
                  nums,
                  0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int idx) {
        res.add(new ArrayList<>(cur));
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(res,
                      cur,
                      nums,
                      i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}

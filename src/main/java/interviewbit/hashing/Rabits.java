package interviewbit.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a forest, each rabbit has some color. Some subset of rabbits(possibly all of them)
 * tell you how many rabbits have the same color as them.Those answers are placed
 * in an array .
 * <p>
 * Return the minimum number of rabbits that could be in the forest.
 * e.g.
 * A --> 1,1,2
 * Ans = 5
 */
public class Rabits {
    public static int findMinRabits(List<Integer> inp) {
        int result = 0;
        Map<Integer, Integer> integerHashMap = new HashMap();
        for (Integer a : inp) {
            if (a == 0) {
                result++;
                continue;
            }
            if (integerHashMap.containsKey(a)) {
                integerHashMap.put(a, integerHashMap.get(a) + 1);
            } else {
                integerHashMap.put(a, 1);
            }
        }
        for (int key : integerHashMap.keySet()) {
            int val = integerHashMap.get(key);
            int rem = val % (key + 1);
            int div = val / (key + 1);
            result += (key + 1) * div;
            if (rem != 0) {
                result += key + 1;
            }
        }
        return result;
        //integerHashMap.keySet().stream().forEach(i -> );
    }

    public static void main(String[] args) {
        System.out.println(findMinRabits(Arrays.asList(1, 1, 2)));
        System.out.println(findMinRabits(Arrays.asList(10, 10, 10, 1, 2)));
        System.out.println(findMinRabits(Arrays.asList(10, 10, 10)));
        System.out.println(findMinRabits(Arrays.asList(2, 2, 1, 2, 5, 1, 5)));
        System.out.println(findMinRabits(Arrays.asList(2, 2, 2, 1, 2)));
        System.out.println(findMinRabits(Arrays.asList(3, 3, 3, 3, 3, 3, 1, 2)));

    }
}

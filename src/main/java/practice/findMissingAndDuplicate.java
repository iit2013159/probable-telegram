package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a continuous array of integer we need to find missing number and repeating number in constant space
 */
public class findMissingAndDuplicate {
    public static void main(String[] args) {
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 4, 3));
        processInput(b).stream().forEach(System.out::println);
    }

    private static <T> List<T> processInput(List<Integer> inp) {
        final Integer[] sum = {0};
        final Integer[] sqSum = {0};
        inp.stream().forEach(i -> {
            sum[0] += i;
            sqSum[0] += i * i;
        });
        int n = inp.size();
        int totalSum = n * (n + 1) / 2;
        int eq1 = Math.abs(totalSum - sum[0]);
        return null;
    }
}

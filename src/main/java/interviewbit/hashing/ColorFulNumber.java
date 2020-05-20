package interviewbit.hashing;

import java.util.*;

/**
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245
 * And this number is COLORFUL number , since product of every digit of a contiguous
 * subsequence is different
 * Example
 * N = 23
 * 2 3 23
 * 2 --> 2
 * 3 -> 3
 * 23 --> 6
 * this number is COLORFUL number since product of every digit of subsequence is different
 */
public class ColorFulNumber {
    private static int[] asIntArray(int num) {
        int temp = num;
        int len = 1;
        while (num > 0) {
            num /= 10;
            len++;
        }
        int[] ar = new int[--len];
        num = temp;
        while (num > 0) {
            ar[--len] = num % 10;
            num /= 10;
        }
        return ar;
    }

    public static List<Integer> contiguousList(int num) {
        int[] a = asIntArray(num);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int prod = 0;
            for (int j = i; j < a.length; j++) {
                prod *= 10;
                prod += a[j];
                list.add(prod);
            }
        }
        Collections.sort(list);
        return list;
    }

    private static boolean isColorful(int num) {
        List<Integer> a = contiguousList(num);
        Set<Integer> set = new HashSet<>();
        for (int n : a) {
            final int[] nu = {1};
            Arrays.stream(asIntArray(n)).forEach(i -> {
                nu[0] *= i;
            });
            if (set.contains(nu[0])) {
                return false;
            }
            set.add(nu[0]);
            System.out.println(" for " + n + " --> " + nu[0]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isColorful(1234));
        //Arrays.stream(asIntArray(1234)).forEach(System.out::print);
    }
}

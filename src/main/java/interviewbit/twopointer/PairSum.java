package interviewbit.twopointer;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array .Find the number of pairs of having sum 'K'.
 * e.g. 1,3,7,9,17,19,22  K= 10
 */
public class PairSum {
    public static void main(String[] args) {
        System.out.println(noOfPair(Arrays.asList(1,
                                                  3,
                                                  7,
                                                  9,
                                                  17,
                                                  19,
                                                  22),
                                    10));
        System.out.println(noOfPair(Arrays.asList(1,
                                                  3,
                                                  3,
                                                  7,
                                                  7,
                                                  7,
                                                  9,
                                                  9,
                                                  17,
                                                  19,
                                                  22),
                                    10));
    }

    private static int noOfPair(List<Integer> list, int k) {
        int l = 0;
        int r = list.size() - 1;
        int total = 0;
        while (l < r) {
            if (list.get(l) + list.get(r) < k) {
                l++;
            } else if (list.get(l) + list.get(r) > k) {
                r--;
            } else {
                int curLeft = list.get(l);
                int lcount = 0;
                int curright = list.get(r);
                int rcount = 0;
                while (list.get(l) == curLeft) {
                    lcount++;
                    l++;
                }
                while (list.get(r) == curright) {
                    rcount++;
                    r--;
                }
                total += lcount * rcount;
            }
        }
        return total;
    }
}

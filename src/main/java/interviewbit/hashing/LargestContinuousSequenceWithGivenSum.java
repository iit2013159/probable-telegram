package interviewbit.hashing;

import java.util.*;

/**
 * Given an array. FInd the largest Continous Sequence which
 * sum upto 0
 */
public class LargestContinuousSequenceWithGivenSum {
    static final int INT_MAX = 99999;
    static int currMinSum = INT_MAX;

    public static void main(String[] args) {
        findSol(Arrays.asList(1, 2, -2, 4, -4)).stream().forEach(System.out::print);
        System.out.println();
        System.out.println(currMinSum);

        currMinSum = INT_MAX;
        findSol(Arrays.asList(3, 2, 2, 4, -3, -1, 5, 2, -2, 4, 5, -8, -6, 9)).stream().forEach(System.out::print);
        System.out.println();
        System.out.println(currMinSum);
    }

    static List findSol(List<Integer> inp) {
        List<Integer> sol = new ArrayList<>();
        int prefixSum = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int cur = 0; cur < inp.size(); cur++) {
            prefixSum += inp.get(cur);
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, cur);
            } else {
                int startIndex = map.get(prefixSum);
                List<Integer> curSol = inp.subList(startIndex + 1, cur + 1);
                if (curSol.size() > sol.size()) {
                    sol = curSol;
                }
                currMinSum = map.keySet().iterator().next();
            }
        }
        return sol;
    }

}

package interviewbit.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int solution(int[][] A) {
        // write your code in Java SE 8
        List<Integer> rowSum = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int[] row = A[i];
            int sum = Arrays.stream(row).reduce(0, Integer::sum);
            rowSum.add(sum);
        }
        List<Integer> colSum = new ArrayList();
        for (int i = 0; i < A[0].length; i++) {
            int colsum = 0;
            for (int j = 0; j < A.length; j++) {
                colsum += A[j][i];
            }
            colSum.add(colsum);
        }
        List<Integer> rowPrefix = new ArrayList();
        for (int i = 0; i < rowSum.size(); i++) {
            if (i == 0) {
                rowPrefix.add(rowSum.get(0));
                continue;
            }
            rowPrefix.add(rowSum.get(i) + rowPrefix.get(i - 1));
        }
        List<Integer> colPrefix = new ArrayList();
        for (int i = 0; i < colSum.size(); i++) {
            if (i == 0) {
                colPrefix.add(colSum.get(0));
                continue;
            }
            colPrefix.add(colSum.get(i) + colPrefix.get(i - 1));
        }
        int sumtot = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if ((findRange(rowPrefix, 0, i - 1) == findRange(rowPrefix, i + 1, A.length - 1))
                    && (findRange(colPrefix, 0, j - 1)) == findRange(colPrefix, j + 1, A[0].length - 1))
                    sumtot++;
            }
        }
        return sumtot;
    }

    public int findRange(List<Integer> list, int l, int r) {
        if (l > r)
            return 0;

        if (l == 0) {
            return list.get(r);
        }
        return list.get(r) - list.get(l);

    }

}

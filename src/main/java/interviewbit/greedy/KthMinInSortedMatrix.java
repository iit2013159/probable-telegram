package interviewbit.greedy;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given a sorted matrix in row-wise as well as column-wise in ascending order. Find Kth Minimum Element.
 * Kth Smallest Element in a Sorted Matrix
 * <p>
 * Solution
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class KthMinInSortedMatrix {
    public static void main(String[] args) {
        int[][] ar = {{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};
        System.out.println(kthIndex(ar,
                                    8));

        int[][] abv = {{1, 3, 5}, {6, 7, 12}, {11, 14, 14}};
        System.out.println(kthIndex(abv,
                                    6));
        int[][] an = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {24, 29, 37, 48},
                {32, 33, 39, 50},
        };
        System.out.println(kthIndex(an,
                                    4));

    }

    /**
     * 10 20 30 40
     * 15 25 35 45
     * 24 29 37 48
     * 32 33 39 50
     * <p>
     * Return the Kth minimum Element.
     *
     * @param m
     * @return
     */
    public static int kthIndex(int[][] m, int k) {
        class Triplet implements Comparable {
            final Integer val;
            final int lIndex;
            final int rIndex;

            public Triplet(Integer val, int lIndex, int rIndex) {
                this.val = val;
                this.lIndex = lIndex;
                this.rIndex = rIndex;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Triplet)) return false;
                Triplet triplet = (Triplet) o;
                return lIndex == triplet.lIndex &&
                       rIndex == triplet.rIndex &&
                       val.equals(triplet.val);
            }

            @Override
            public int hashCode() {
                return Objects.hash(val,
                                    lIndex,
                                    rIndex);
            }

            @Override
            public String toString() {
                return "Triplet{" +
                       "val=" + val +
                       ", lIndex=" + lIndex +
                       ", rIndex=" + rIndex +
                       '}';
            }

            @Override
            public int compareTo(Object o) {
                Triplet ot = (Triplet) o;
                int xv = this.val.compareTo(ot.val);
                if (xv == 0) {
                    if (this.equals(ot)) {
                        return 0;
                    }
                    int al = Integer.compare(this.lIndex,
                                             ot.lIndex);
                    int ar = Integer.compare(this.rIndex,
                                             ot.rIndex);
                    if (al == 0 && ar == 0) {
                        return 0;
                    } else if (al == 0 && ar != 0) {
                        return ar;
                    } else if (al != 0 && ar == 0) {
                        return al;
                    } else {
                        return al;//we can return anything that doesn't matter;
                    }
                }
                return xv;

            }
        }
        //m[i-1][j-1] will be the biggest number and m[0][0] will be the smallest.
        //Therefore if we have to find minimum ; we will start with smallest else otherwise.
        //if we choose 10. then 2nd big element will be either on left/right. Here is the thing what
        // you will do whether you will be greedy and choose the minimum among and go. But
        //the solution is to make a heap of size k and pass the probable elements into the heap.
        // and we have to do this k times. now we got the kth minimum.
        SortedSet<Triplet> pq = new TreeSet();
        int l = 0, r = 0;
        pq.add(new Triplet(m[l][r],
                           0,
                           0));
        Triplet top = null;
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                top = pq.first();
                pq.remove(top);
                System.out.println(top.val + " at k  " + (i + 1));
                m[top.lIndex][top.rIndex] = Integer.MAX_VALUE;
            }
            if (top.lIndex + 1 < m[0].length) {
                pq.add(new Triplet(m[top.lIndex + 1][top.rIndex],
                                   top.lIndex + 1,
                                   top.rIndex));
            }
            if (top.rIndex + 1 < m.length) {
                pq.add(new Triplet(m[top.lIndex][top.rIndex + 1],
                                   top.lIndex,
                                   top.rIndex + 1));
            }
        }
        return top.val;
    }
}

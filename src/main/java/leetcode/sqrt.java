package leetcode;

public class sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int lo = 0;
        int hi = x;
        int mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (mid == x / mid ||
                ((mid + 1) > x / (mid + 1) && mid < x / mid)) {
                return mid;
            } else if (mid < x / mid) {
                lo = mid - 1;
            } else {
                hi = mid + 1;
            }
        }
        return mid;
    }
}

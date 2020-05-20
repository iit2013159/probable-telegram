package leetcode;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 */
public class BadVersion {
    static int range, first;

    public static void main(String[] args) {
        //wrapper(5,4);
        wrapper(3, 2);

    }

    private static void wrapper(int r, int f) {
        range = r;
        first = f;
        System.out.println(firstBadVersion(range));
    }

    private static int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        int temp = Math.min(lo, mid);
        mid = Math.max(lo, mid);
        lo = temp;
        for (int i = lo; i <= mid; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isBadVersion(int check) {
        return check >= first && check <= range;
    }
}

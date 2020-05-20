package leetcode;

public class guessNum {
    static Integer pick;

    public static void main(String[] args) {
        pick = 6;
        System.out.println(guessNum(10));
    }

    public static int guessNum(int x) {
        int lo = 1;
        int hi = x;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return 1;
    }

    public static int guess(Integer num) {
        return num.compareTo(pick);
    }
}

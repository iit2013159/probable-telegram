package interviewbit.twopointer;

/**
 * Given a string which has only 2 kind of character a,b
 * Given K number of swap . length of longest same character substring.
 * e.g. abbaa K = 1 --> Output = 3. because after 1 swap it can abbba or abaaa
 */
public class SwapElement {
    public static void main(String[] args) {
        System.out.println(longestSubstring("abbaa",
                                            1));
        System.out.println(longestSubstring("abbaa",
                                            2));
        System.out.println(longestSubstring("bbaabaa",
                                            2));
    }

    private static int longestSubstring(String str, int k) {
        int ac = evaluateCount(str,
                               k,
                               'a');
        int bc = evaluateCount(str,
                               k,
                               'b');
        return Integer.max(ac,
                           bc);
    }

    private static int evaluateCount(String str, int k, char decis) {
        int l = 0, r = 0;
        int count = 0;
        int temp = k;
        while (r < str.length() && l <= r) {
            if (str.charAt(r) == decis) {
                r++;
            } else {
                if (temp > 0) {
                    temp--;
                    r++;
                } else {
                    l++;
                    r = l;
                    temp = k;
                }
            }
            count = Integer.max(count,
                                r - l);
        }
        return count;
    }
}

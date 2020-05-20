package interviewbit.hashing;

import java.util.Arrays;

/**
 * Given a String s and a string T, find the minimum window in S which will contain
 * all the characters in T in linear time complexity. Note that when the count of a
 * character C is N, then count of C in minimum window in S should be at least N.
 * E.g.
 * S ="ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC"
 * <p>
 * If there is no such window in S that covers all characters in T then return empty string
 * If there are multiple such windows,return the first occuring minimum window
 * (with minimum start index)
 */
public class MinWindowWhichContainsAllChars {
    static final int TOTAL_CHAR = 26;
    static final int INT_MAX = 99999;
    static int[] fixed = new int[TOTAL_CHAR];
    static int[] changing = new int[TOTAL_CHAR];


    /**
     * Here both the input array  wil have length of TOTAL_CHAR
     *
     * @return
     */
    private static boolean matches() {
        for (int i = 0; i < TOTAL_CHAR; i++) {
            if (changing[i] >= fixed[i]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findMinWindow("ADOBECODEBANC", "ABC"));
    }

    private static String findMinWindow(String S, String T) {
        for (char c : T.toCharArray()) {
            fixed[c - 'A']++;
        }
        int[] minWindow = new int[S.length()];
        int minIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            minIndex = getMinIndexForSubstring(i, minIndex, S);
            minWindow[i] = minIndex;
            if (minIndex != INT_MAX) {
                changing[S.charAt(minIndex) - 'A']--;
                minWindow[i] = minIndex - i;
            }
        }
        Arrays.stream(minWindow).forEach(i -> System.out.print(i + " "));
        int recievedMin = Arrays.stream(minWindow).min().getAsInt();
        int recievedMinIndex = INT_MAX;
        for (int i = 0; i < minWindow.length; i++) {
            if (minWindow[i] == recievedMin) {
                recievedMinIndex = i;
                break;
            }
        }
        return S.substring(recievedMinIndex, recievedMinIndex + recievedMin + 1);
    }

    private static int getMinIndexForSubstring(int index, int lastIndex, String s) {
        if (lastIndex >= s.length() || lastIndex == INT_MAX) {
            return INT_MAX;
        }
        if (index != 0) {
            changing[s.charAt(index - 1) - 'A']--;
        }
        for (int i = lastIndex; i < s.length(); i++) {
            changing[s.charAt(i) - 'A']++;
            if (matches()) {
                return i;
            }
        }
        return INT_MAX;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation
 * <p>
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * <p>
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        //letterCasePermutation("a1b2").stream().forEach(System.out::println);
        letterCasePermutation("a").stream()
                .forEach(System.out::println);

    }

    public static List<String> letterCasePermutation(String S) {
        List<String> sol = new ArrayList();
        prUtil(S,
               0,
               S.length(),
               sol);
        return sol;
    }

    public static void prUtil(String s, int left, int right, List<String> sol) {
        if (sol.contains(s)) {
            return;
        }
        sol.add(s);
        if (left == right) {
            return;
        }


        char[] chars = s.toCharArray();
        for (int i = left; i < right; i++) {
            if (!Character.isLetter(s.charAt(i))) {
                continue;
            }
            swapCases(chars,
                      i);
            s = String.valueOf(chars);
            prUtil(s,
                   left + 1,
                   right,
                   sol);
            swapCases(chars,
                      i);
            s = String.valueOf(chars);
        }

    }

    private static void swapCases(char[] chars, int i) {
        if (Character.isUpperCase(chars[i])) {
            chars[i] = Character.toLowerCase(chars[i]);
        } else {
            chars[i] = Character.toUpperCase(chars[i]);
        }
    }
}

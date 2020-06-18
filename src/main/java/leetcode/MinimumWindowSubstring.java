package leetcode;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    private static Map<Character, Long> map;

    public static void main(String[] args) {
//        System.out.println(minSubstring("ADOBECODEBANC", "ABC"));
//        System.out.println(minSubstring("ab","a"));
//        System.out.println(minSubstring("bdab","ab"));
//        System.out.println(minSubstring("bba","ab"));
        System.out.println(minSubstring("acbbaca",
                                        "aba"));
        Queue q = new PriorityQueue();


    }

    private static boolean isFullStill(Map<Character, Long> curr) {
        return map.keySet()
                .stream()
                .allMatch(j -> map.get(j) == curr.get(j));
    }

    private static boolean isMapEmpty(Map<Character, Long> curr) {
        return curr.entrySet()
                .stream()
                .allMatch(j -> j.getValue() == 0);
    }

    private static String minSubstring(String str, String t) {
        if (t.length() > str.length()) {
            return "";
        }
        map = getFrequencyMap(t);
        Map<Character, Long> local = getFrequencyMap(t);
        int begin = 0, end = 0;
        String best = str + t;
        while (end < str.length()) {
            char rv = str.charAt(end);
            if (local.containsKey(rv)) {
                if (!isMapEmpty(local)) {
                    local.put(rv,
                              local.get(rv) > 0 ? local.get(rv) - 1 : 0);
                    end++;
                } else {
                    local = getFrequencyMap(t);
                    if (str.substring(begin,
                                      end)
                                .length() < best.length()) {
                        best = str.substring(begin,
                                             end);
                    }
                    end = ++begin;
                }
            } else {
                if (isFullStill(local)) {
                    begin++;
                    if (begin > end) {
                        end++;
                    }
                } else if (isMapEmpty(local)) {
                    local = getFrequencyMap(t);
                    if (str.substring(begin,
                                      end)
                                .length() < best.length()) {
                        best = str.substring(begin,
                                             end);
                    }
                    end = ++begin;
                } else {
                    end++;
                }
            }
        }
        if (str.substring(begin,
                          end)
                    .length() > 0 && str.substring(begin,
                                                   end)
                                             .length() < best.length()) {
            best = str.substring(begin,
                                 end);
        }
        if (best.length() > str.length()) {
            return "";
        }
        int i = 0;
        for (i = 0; i < best.length() - t.length(); i++) {
            if (best.charAt(i) != best.charAt(i + 1)) {
                break;
            }
        }
        if (best == str) {
            return best;
        }
        int v = Stream.of(1,
                          2,
                          3)
                .min(Integer::compareTo)
                .get();
        return minSubstring(best.substring(i),
                            t);
    }

    private static Map<Character, Long> getFrequencyMap(String t) {
        return t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                                               Collectors.counting()));
    }
}

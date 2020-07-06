package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
        ;
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c,
                        map.get(c) + 1);
            } else {
                map.put(c,
                        1);
            }
        }
       char num = map.entrySet()
                .stream()
                .filter(j -> j.getValue()
                        .equals(1))
                .map(k -> k.getKey())
                .findFirst()
                .orElse('-');
       return s.indexOf(num);

    }
}

package practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<String> b = new ArrayList<>(Arrays.asList("code", "doce", "anagram", "angraam"));
        Permutation p = new Permutation();
        p.permutation("abc");
        //cutBamboo(b).stream().forEach(System.out::println);
    }

    public static String sortedString(String i) {
        char[] ar = i.toCharArray();
        Arrays.sort(ar);
        return new String(ar);
    }


    public static List<String> cutBamboo(List<String> s) {
        Map<String, String> map = new HashMap<>();
        s.stream().filter(k -> !map.containsKey(sortedString(k))).forEach(i -> map.put(sortedString(i), i));
        return map.keySet().stream().map(i -> map.get(i)).sorted().collect(Collectors.toList());
    }
}

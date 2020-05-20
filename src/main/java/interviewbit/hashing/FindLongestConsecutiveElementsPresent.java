package interviewbit.hashing;

import java.util.*;
import java.util.stream.Collectors;

public class FindLongestConsecutiveElementsPresent {
    public static int findLen(List<Integer> inp) {
        Set<Integer> inpMap = new HashSet(inp);
        List<Integer> numList = inp.stream().filter(i -> !inpMap.contains(i - 1)).collect(Collectors.toList());
        int curMax = 0;
        for (int a : numList) {
            int cur = 1;
            while (true) {
                if (inpMap.contains(a + 1)) {
                    a++;
                    cur++;
                } else {
                    curMax = Math.max(cur, curMax);
                    break;
                }
            }
        }
        return curMax;
    }

    public static void main(String[] args) {
//        int l =FindLongestConsecutiveElementsPresent.findLen(Arrays.asList(100,5,3,6,80,78,4,99));
//        System.out.println(l);
        NavigableMap<String, Integer> nm =
                new TreeMap<String, Integer>();
        nm.put("C", 888);
        nm.put("Y", 999);
        nm.put("A", 444);
        nm.put("T", 555);
        nm.put("B", 666);
        nm.put("A", 555);
        nm.entrySet().parallelStream()
                .collect(Collectors.groupingByConcurrent(j -> j.getKey(), Collectors.summarizingDouble(k -> k.getValue())));
        Map a = new TreeMap(Map.Entry.comparingByValue());
        System.out.printf("Descending Set : %s%n",
                          nm.descendingKeySet());
        System.out.printf("Floor Entry : %s%n",
                          nm.floorEntry("L"));
        System.out.printf("First Entry : %s%n",
                          nm.firstEntry());
        System.out.printf("Last Key : %s%n",
                          nm.lastKey());
        System.out.printf("First Key : %s%n",
                          nm.firstKey());
        System.out.printf("Original Map : %s%n", nm);
        System.out.printf("Reverse Map : %s%n",
                          nm.descendingMap());
//        nm.values()
    }

}

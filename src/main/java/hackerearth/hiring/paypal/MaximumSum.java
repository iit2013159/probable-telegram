package hackerearth.hiring.paypal;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumSum {
    /**
     * 1
     * 6 7
     * 3 2 5 6 2 6
     * 1 2
     * 1 5
     * 2 6
     * 6 6
     * 5 5
     * 5 5
     * 3 5
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String testCase = s.nextLine();
        // Reading input from STDIN
        int t = Integer.parseInt(testCase);
        while (t-- > 0) {
            testCase = s.nextLine();
            List<Integer> chances = convert(testCase.split(" "));
            List<Integer> array = convert(s.nextLine().split(" "));
            int[] ar = {1, 2, 3};

            List<List<Integer>> ranges = new ArrayList();
            int ch = chances.get(1);
            while (ch-- > 0) {
                testCase = s.nextLine();
                List<Integer> range = Arrays.stream(testCase.split(" "))
                        .map(j -> Integer.parseInt(j) - 1)
                        .collect(Collectors.toList());
                ranges.add(range);
            }
            /*array.stream().forEach(i -> System.out.print(i + " "));
            ranges.stream().forEach(i -> {
                System.out.println();
                i.stream().forEach(j -> System.out.print(j + " "));
            });*/
            calc(array, ranges);
            //System.out.println();
        }
    }

    public static List<Integer> convert(String[] str) {
        return Arrays.stream(str).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static void calc(List<Integer> array, List<List<Integer>> ranges) {
        System.out.println(calcBobSum(array.stream().collect(Collectors.toList()), ranges) - calcAliceSum(array, ranges));
    }

    private static int calcBobSum(final List<Integer> array, List<List<Integer>> ranges) {
        Map<Integer, Integer> valOCcu = new LinkedHashMap();
        ranges.stream()
                .forEach(i -> IntStream.rangeClosed(i.get(0), i.get(1))
                        .forEach(j -> {
                            int val = valOCcu.getOrDefault(j, 0);
                            valOCcu.put(j, val + 1);
                        }));
        Collections.sort(array);
        int[] arrIndex = {1};
        int value = valOCcu.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .sorted(Comparator.reverseOrder())
                .reduce(0, (sum, ele) -> sum + array.get(array.size() - arrIndex[0]++) * ele);
        return value;
    }

    private static int calcAliceSum(List<Integer> array, List<List<Integer>> ranges) {
        List<Integer> accVal = ranges.stream()
                .map(j -> IntStream.rangeClosed(j.get(0), j.get(1))
                        .reduce(0, (acc, ele1) -> acc + array.get(ele1)))
                .collect(Collectors.toList());
        int v = accVal.stream().reduce(0, (sum, ele) -> sum + ele);
        return v;
    }
}

package practice;


import java.util.ArrayList;
import java.util.List;

class Permutation {
    String swap(String str, int l, int r) {
        if (r < l) {
            int temp = l;
            l = r;
            r = temp;
        }
        char[] chars = str.toCharArray();
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
        return String.valueOf(chars);
    }

    private List<String> permute(String str, int left, int right, List<String> res) {
        if (left == right) {
            if (res == null) {
                res = new ArrayList<>();
            }
            res.add(str);
            return res;
        }
        for (int i = left; i <= right; i++) {
            str = swap(str, left, i);
            res = permute(str, left + 1, right, res);
            str = swap(str, left, i);
        }
        return res;
    }

    List<String> permutation(String str) {
        List<String> res;
        res = permute(str, 0, str.length() - 1, null);
        res.stream().forEach(System.out::println);
        return res;
    }
}

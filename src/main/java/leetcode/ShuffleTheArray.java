package leetcode;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        char[] a = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', '1', '2', '3', '4', '5',
                '6',
                '7',
                '8', '9'
        };
        shuffle(a,
                9);
        print(a);
    }

    public static void print(char[] a) {
        for (char c : a) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void swap(char[] nums, int l, int r) {
        char temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static char[] shuffle(char[] nums, int n) {
        int i = 1, r = n;
        while (i < 2 * n - 1) {
            swap(nums, i, r);
            print(nums);

            swap(nums, i + 1, r);
            i += 2;
            r++;
            print(nums);
        }
        System.out.println("---------------------------");
        for(int j = 4;j < 2*n - 2; j+= 2){
            swap(nums,j,2*(j+1));
            print(nums);
        }
        return nums;
    }
}

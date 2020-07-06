package leetcode;

import java.util.Arrays;

public class CheckIfExist {
    public static void main(String[] args) {
       // process(3,1,7,11);
        //process(10,2,5,3);
        process(-2,0,10,-19,4,6,-8);
    }
    public static void process(int ... nums){
        System.out.println(checkIfExist(nums));

    }
    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
       for(int i : arr){
            if(1 != 0 && Arrays.binarySearch(arr, i * 2) > -1){
                return true;
            }
        }
        return false;
    }
}

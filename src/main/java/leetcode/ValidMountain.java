package leetcode;

public class ValidMountain {
    public static void main(String[] args) {
        process(2,1,2,3,5,7,9,10,12,14,15,16,18,14,13);
    }
    public static void process(int ... nums){
        System.out.println(validMountainArray(nums));

    }
    public static boolean validMountainArray(int[] A) {
        if(A.length < 3){
            return false;
        }
        int in = -1;
        for(int i = 1; i< A.length -1 ;i++){
            if(A[i] <= A[i-1]){
                return false;
            }
            if(A[i] > A[i-1] && A[i] > A[i+1]){
                in = i;
                break;
            }
        }
        if(in == -1){
            return false;
        }
        for(int i = in +1; i < A.length;i++){
            if(A[i] >= A[i-1]){
                return false;
            }
        }
        return true;
    }
}

package leetcode;

public class ThirdMax {
    public static void main(String[] args) {
       // System.out.println(thirdMax(new int[]{1,2}));
      //  System.out.println(thirdMax(new int[]{2,2,3,1}));
       // System.out.println(thirdMax(new int[]{1,1,1}));
        System.out.println(thirdMax(new int[]{1,2,-2147483648}));


    }
    public static int thirdMax(int[] nums) {
        Integer f = null , s = null, t = null;
        for(int i = 0; i< nums.length;i++){
            if(f == null || nums[i] > f){
                t = s;
                s = f;
                f = nums[i];
            }
            if((nums[i] > (s == null?Integer.MIN_VALUE:s)) && i>0 && nums[i] < f){
                t = s;
                s = nums[i];
            }
            if((nums[i] > (t == null?Integer.MIN_VALUE:t)) && i > 1 && nums[i] < (s == null?Integer.MIN_VALUE:s)){
                t = nums[i];
            }
        }
        if(t == null) {
            return f;
        }
        return t;
    }
}

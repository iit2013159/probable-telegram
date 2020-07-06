package leetcode;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0,r =s.length()-1;
        while(l < r){
            if(!Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l)) ){
                l++;
                continue;
            }
            if(!Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r))){
                r--;
                continue;
            }
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}

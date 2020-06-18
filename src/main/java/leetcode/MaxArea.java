package leetcode;

public class MaxArea {
    public static void main(String[] args) {
        // System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1, 2, 1}));

    }

    public static int maxArea(int[] height) {
        int currMax = 0;
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Integer.max(maxArea,
                                  Integer.min(height[currMax],
                                              height[i])
                                  * (i - currMax));
            if (height[i] > height[currMax]) {
                currMax = i;
            }
        }
        return maxArea;
    }
}

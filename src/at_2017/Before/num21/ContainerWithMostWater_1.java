package at_2017.Before.num21;

/**
 * Created by zhonghui on 2017/7/26.
 */
public class ContainerWithMostWater_1 {
    public static void main(String[] args) {
        int [] height = {10,14,10,4,10,2,6,1,6,12};
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.maxArea(height));
    }
}

class Solution_1 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, compute(height, left, right));
            if (height[left] <= right) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public int compute(int[] height, int i, int j) {
        int minHigh = Math.min(height[i], height[j]);
        int width = j - i;
        return minHigh * width;
    }
}
/*-----------------------------------------------------------*/
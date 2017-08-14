package num21;

/**
 * Created by zhonghui on 2017/7/24.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int area = compute(height, i, j);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public int compute(int[] height, int i, int j) {
        int minHigh = Math.min(height[i], height[j]);
        int width = j - i;
        return minHigh * width;
    }
}
/*-----------------------------------------------------------*/

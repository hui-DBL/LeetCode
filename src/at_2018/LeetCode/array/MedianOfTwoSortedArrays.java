package at_2018.LeetCode.array;

import java.util.*;

/**
 * Array,Binary Search,Divide and Conquer
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        int len = lenA + lenB;
        ArrayList<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < Math.max(lenA, lenB); i++) {
            if (i < lenA) {
                list.add(nums1[i]);
            }
            if (i < lenB) {
                list.add(nums2[i]);
            }
        }
        Collections.sort(list);
        if (len == 0) {
            return Double.valueOf(0);
        }
        if ((len) % 2 == 0) {
            //偶数
            int indexA = len / 2;
            int indexB = indexA - 1;
            return Double.valueOf(list.get(indexA) + list.get(indexB)) / 2;
        } else {
            //奇数
            int index = len / 2;
            return Double.valueOf(list.get(index));
        }
    }
}

package at_2020.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author libing
 * @Date 2020/11/2
 */
public class Intersection {

    public static void main(String[] args) {
        int[] i = {1, 2, 2, 1};
        int[] j = {2, 2};
        System.out.println(intersection(i, j));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    set.add(num1);
                }
            }
        }
        int[] array = new int[set.size()];
        int index = 0;
        for (int num : set) {
            array[index] = num;
            index++;
        }
        return array;
    }
}

package LeetCode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Math,String
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 3;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        Map<Integer, String> map = initMap();
        int[] bitNums = splitNum(num);
        StringBuilder re = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                for (int j = 0; j < bitNums[i] / 1000; j++) {
                    re.append(map.get(1000));
                }
                continue;
            }
            getRemainRe(re, bitNums[i], i);
        }
        return re.toString();
    }

    private static void getRemainRe(StringBuilder re, int num, int i) {
        int[] scopes = getScope(num);
        if (scopes[0] != num && scopes[1] != num) {
            if (scopes[0] == Math.pow(10, 3 - i)) {
                for (int j = 0; j < num / Math.pow(10, 3 - i); j++) {
                    re.append(initMap().get(scopes[0]));
                }
            } else {
                re.append(initMap().get(scopes[0]));
                getRemainRe(re, num - scopes[0], i);
            }
        }
        if (scopes[0] == num) {
            if (initMap().get(num) != null) {
                re.append(initMap().get(num));
            }
        }
        if (scopes[1] == num) {
            if (initMap().get(num) != null) {
                re.append(initMap().get(num));
            }
        }
    }

    private static int[] getScope(int bitNum) {
        TreeSet<Integer> set = new TreeSet<>(initMap().keySet());
        int[] scopes = new int[2];
        for (Integer i : set) {
            if (bitNum > i) {
                scopes[0] = i;
            } else {
                scopes[1] = i;
                break;
            }
        }
        return scopes;
    }

    private static int[] splitNum(int num) {
        int[] bitNums = new int[4];
        for (int i = 0; i < 4; i++) {
            int max = (int) Math.pow(10, (3 - i));
            int temp = num % max;
            bitNums[i] = num - temp;
            num = num - bitNums[i];
        }
        return bitNums;
    }

    private static Map<Integer, String> initMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        return map;
    }
}

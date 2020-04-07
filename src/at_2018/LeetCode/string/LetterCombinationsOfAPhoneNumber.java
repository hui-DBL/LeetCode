package at_2018.LeetCode.string;

import java.util.*;

/**
 * String,Backtracking
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) {
            return new ArrayList<>();
        }
        digits.replaceAll("1", "");
        int[] bitNum = new int[digits.length() + 1];
        List<String> re = new ArrayList<String>();
        // 4进制
        while (bitNumSum(bitNum) <= maxBitNumSum(digits.length())) {
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (int i = 0; i < digits.length(); i++) {
                char temp = initMap().get(Integer.valueOf(digits.charAt(i)) - 48).charAt(bitNum[i]);
                if (temp != ' ') {
                    sb.append(temp);
                } else {
                    flag = false;
                    continue;
                }
            }
            if (flag) {
                re.add(sb.toString());
            }
            addBitNum(bitNum, 0);
        }
        Collections.sort(re);
        return re;
    }

    private static int maxBitNumSum(int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += 3 * Math.pow(4, i);
        }
        return sum;
    }

    private static void addBitNum(int[] bitNum, int i) {
        int temp = bitNum[i] + 1;
        if (temp > 3) {
            bitNum[i] = 0;
            addBitNum(bitNum, ++i);
        } else {
            bitNum[i] = temp;
        }
    }

    private static int bitNumSum(int[] bitNum) {
        int sum = 0;
        for (int i = 0; i < bitNum.length; i++) {
            sum += bitNum[i] * Math.pow(4, i);
        }
        return sum;
    }

    private static Map<Integer, String> initMap() {
        Map<Integer, String> map = new HashMap<>(8);
        map.put(2, "abc ");
        map.put(3, "def ");
        map.put(4, "ghi ");
        map.put(5, "jkl ");
        map.put(6, "mno ");
        map.put(7, "pqrs");
        map.put(8, "tuv ");
        map.put(9, "wxyz");
        return map;
    }
}

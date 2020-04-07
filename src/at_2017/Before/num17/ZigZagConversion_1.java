package at_2017.Before.num17;

/**
 * Created by zhonghui on 2017/7/14.
 */
public class ZigZagConversion_1 {
    public static void main(String[] args) {
        String s = "ABC";
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.convert(s, 2));
    }
}

class Solution_1 {
    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows == 0 || s == null) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int size = 2 * numRows - 2;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<numRows;i++) {
            for(int j=i;j<s.length();j+=size) {
                res.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    int temp = j + size - 2 * i;
                    if (temp < s.length()) {
                        res.append(j + temp);
                    }
                }
            }
        }
        return res.toString();
    }
}

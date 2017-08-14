package num17;

/**
 * Created by zhonghui on 2017/7/12.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "ABC";
        Solution solution = new Solution();
        System.out.println(solution.convert(s, 2));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int num;
        int flag = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            int count = 1;
            if (i == numRows - 1 || i == 0) {
                flag = 2 * numRows - 3;
            } else {
                flag = 2 * (numRows - i) - 3;
            }
            while (j < s.length()) {
                stringBuilder.append(s.charAt(j));
                if (i == numRows - 1 || i == 0) {
                    j = j + flag + 1;
                } else {
                    if (count % 2 == 1) {
                        j = j + flag + 1;
                    } else {
                        j = j + 2 * (numRows - (numRows - i - 1)) - 3 + 1;
                    }
                    count++;
                }
            }
        }
        return stringBuilder.toString();
    }
}
/*-----------------------------------------------------------*/
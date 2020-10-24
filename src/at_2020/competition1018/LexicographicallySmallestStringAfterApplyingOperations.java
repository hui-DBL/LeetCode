package at_2020.competition1018;

/**
 * @author hui.zhong
 * @date 2020/10/18
 */
public class LexicographicallySmallestStringAfterApplyingOperations {

    public static void main(String[] args) {
        System.out.println(findLexSmallestString("74", 5, 1));
    }

    public static String findLexSmallestString(String s, int a, int b) {
        // 每翻转一次，累加出本次的最小值
        int min = Integer.parseInt(s);
        String minStr = s;

        boolean flag = false;
        do {
            flag = false;

            for (int i = 0; i < 10; i++) {
                s = methodA(s, a);
                if (Integer.parseInt(s) < min) {
                    min = Integer.parseInt(s);
                    minStr = s;
                    flag = true;
                }
            }
            s = methodB(s, b);
            for (int i = 0; i < 10; i++) {
                s = methodA(s, a);
                if (Integer.parseInt(s) < min) {
                    min = Integer.parseInt(s);
                    minStr = s;
                    flag = true;
                }
            }
        } while (flag);

        return minStr;
    }

    public static String methodA(String s, int a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int val = Integer.parseInt(s.substring(i, i + 1));
            if (i % 2 != 0) {
                val = val + a;
                if (val >= 10) {
                    val = val - 10;
                }
            }
            sb.append(val);
        }
        return sb.toString();
    }

    public static String methodB(String s, int b) {
        char[] strs = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int tmpIndex = i + b;
            if (tmpIndex >= s.length()) {
                tmpIndex = tmpIndex - s.length();
            }
            strs[tmpIndex] = s.charAt(i);
        }
        return String.valueOf(strs);
    }
}

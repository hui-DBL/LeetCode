package at_2018.LeetCode.string;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "6913259244";
        String num2 = "71103343";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        int[][] result = new int[num1.length() + num2.length() + 2][num1.length() + num2.length() + 2];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int tmp = Integer.valueOf(num1.charAt(i) - 48) * Integer.valueOf(num2.charAt(j) - 48);
                result[num1.length() - i - 1][num2.length() - j - 1] += tmp;
                int val = result[num1.length() - i - 1][num2.length() - j - 1] / 10;
                if (val > 0) {
                    result[num1.length() - i - 1][num2.length() - j - 1] = result[num1.length() - i - 1][num2.length() - j - 1] % 10;
                    result[num1.length() - i - 1][num2.length() - j - 1 + 1] += val;
                }
            }
        }

        int[] re = new int[num1.length() + num2.length() + 2];
        for (int i = 0; i < result[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < result.length; j++) {
                if (j <= i) {
                    sum += result[j][i - j];
                }
            }
            re[i] += sum;
            int val = re[i] / 10;
            if (val > 0) {
                re[i] = re[i] % 10;
                re[i + 1] += val;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = re.length - 1; i >= 0; i--) {
            if (flag) {
                if (re[i] == 0) {
                    continue;
                } else {
                    sb.append(re[i]);
                    flag = false;
                }
            } else {
                sb.append(re[i]);
            }
        }

        if (sb.toString().length() < 1) {
            return String.valueOf(0);
        }

        return sb.toString();
    }
}

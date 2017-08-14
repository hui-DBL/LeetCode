package num02;

/**
 * 判断溢出，幂
 *
 * Created by zhonghui on 2017/6/29.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int i = 1;
        Solution solution = new Solution();
        System.out.println(solution.reverse(i));
    }
}

class Solution {
    public int reverse(int x) {
        int[] chars = new int[20];
        int result=0;
        int temp1;
        int temp = x;
        if (temp < 0) {
            temp = -temp;
            chars[0] = 1;
        } else if (temp == 0) {
            result = 0;
            return result;
        }

        int i=1;
        while (temp > 0) {//拆分
            temp1 = temp % 10;
            chars[i]=temp1;//接收不对
            i++;
            temp=temp/10;
        }
        if (i > 20) {//溢出处理不对，反转之后溢出
            result = 0;
            return result;
        } else {
            double result1=0;
            int k=i-2;
            double b;
            for (int j=1;j<i;j++) {
                b=(chars[j] * Math.pow(10, k));
                result1= result1 + b;
                k--;
                if (result1 > Math.pow(2, 31) - 1) {
                    return 0;
                }
            }
            result=(int)result1;
            if (chars[0] == 1) {
                result=-(int)result1;
            }
            return result;
        }
    }
}
/*-----------------------------------------------------------*/

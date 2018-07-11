package Before.num02;

/**
 * Created by zhonghui on 2017/6/29.
 */
public class ReverseInteger_1 {
    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.reverseInteger(123));
    }
}

class Solution_1 {
    public int reverseInteger(int n) {
        int result = 0;

        while (n != 0) {
            int temp = result * 10 + n % 10;
            n=n/10;
            if (temp / 10 != result) {//验证是否溢出
                result=0;
                return result;
            }
            result=temp;//和上面的验证对应，下一层循环的时候*10
        }
        return result;
    }
}
/*-----------------------------------------------------------*/

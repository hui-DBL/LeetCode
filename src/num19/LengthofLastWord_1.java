package num19;

/**
 * Created by zhonghui on 2017/7/17.
 */
public class LengthofLastWord_1 {
    public static void main(String[] args) {
        String s = "a  ";
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.lengthOfLastWord(s));
    }
}
class Solution_1 {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        int length=0;
        char[] c = s.toCharArray();
        for(int i=s.length()-1;i>=0;i--) {
            if (length == 0) {
                if (c[i] == ' ') {
                    continue;
                } else {
                    length++;
                }
            } else {
                if (c[i] == ' ') {
                    break;
                } else {
                    length++;
                }
            }
        }
        return length;
    }
}
/*-----------------------------------------------------------*/




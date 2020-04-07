package at_2017.Before.num19;

/**
 * Created by zhonghui on 2017/7/17.
 */
public class LengthofLastWord {
    public static void main(String[] args) {
        String s = "a  ";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord(s));
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int[] index = new int[s.length()];
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                index[count] = i;
                count++;
            }
        }
        int min=s.trim().length();
        int len;
        for (int j=0;j<count;j++) {
            String temp = s.substring(index[j], s.length());
            len = temp.trim().length();
            if (len > 0 && len < min) {
                min = temp.trim().length();
            }
        }
        return min;
    }
}
/*-----------------------------------------------------------*/

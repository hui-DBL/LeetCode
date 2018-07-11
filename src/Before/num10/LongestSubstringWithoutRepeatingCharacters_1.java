package Before.num10;

/**
 * Created by zhonghui on 2017/7/5.
 */
public class LongestSubstringWithoutRepeatingCharacters_1 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.lengthOfLongestSubstring(s));
    }
}

class Solution_1 {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];// map from character's ASCII to its last occured index
        int i=0;
        int j=0;
        int ans=0;
        for(i=0;i<s.length();i++) {
            while (j < s.length() && map[s.charAt(j)] == 0) {
                ans = Math.max(ans, j - i + 1);
                map[s.charAt(j)] = 1;//标志位，j已存在
                j++;
            }
            map[s.charAt(i)] = 0;//注意这里是i，计数位i往前移动,i++
        }
        return ans;
    }
}
/*-----------------------------------------------------------*/

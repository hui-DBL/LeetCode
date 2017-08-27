package num10;

import java.util.HashMap;

/**
 * Created by zhonghui on 2017/7/5.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap <Character, Integer> hashMap = new HashMap<>();//元素的唯一性
        int max = 0;
        int len = 0;
        int index=0;//计数的标志位
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == null) {
                hashMap.put(s.charAt(i), i);
                len++;
            } else {
                if (hashMap.get(s.charAt(i)) >= index) {
                    len = i - hashMap.get(s.charAt(i));
                    if (len == 1) {//重新计数
                        hashMap.clear();
                        index = i - 1;
                    } else {
                        index = hashMap.get(s.charAt(i));
                    }
                } else {
                    len++;
                }
                hashMap.put(s.charAt(i), i);
            }
            if (len >= max) {
                max = len;
            }
        }
        return max;
    }
}
/*-----------------------------------------------------------*/

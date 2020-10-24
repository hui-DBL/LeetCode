package at_2020.competition1018;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hui.zhong
 * @date 2020/10/18
 */
public class LargestSubstringBetweenTwoEqualCharacters {

    public static void main(String[] args) {

    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>(s.length());
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndexMap.containsKey(c)) {
                int index = charIndexMap.get(c);
                max = Math.max(i - index - 1, max);
            } else {
                charIndexMap.put(c, i);
            }
        }
        return max;
    }
}

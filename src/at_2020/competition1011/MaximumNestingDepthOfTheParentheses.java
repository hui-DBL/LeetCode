package at_2020.competition1011;

/**
 * @author hui.zhong
 * @date 2020/10/11
 */
public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        System.out.println(maxDepth("1"));
    }

    public static int maxDepth(String s) {
        int max = 0;
        int base = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                base++;
            } else if (c == ')') {
                max = Math.max(max, base);
                base--;
            }
        }
        return max;
    }
}

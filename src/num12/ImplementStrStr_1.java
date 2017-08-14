package num12;

/**
 * Created by zhonghui on 2017/7/6.
 */
public class ImplementStrStr_1 {
    public static void main(String[] args) {
        String haystack = "abcdefg";
        String needle = "cd";
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.strStr(haystack, needle));
    }
}

class Solution_1 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {//null的判断
            return -1;
        }
        int j;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {//haystack.length() - needle.length() + 1，当haystack内的剩余长度小鱼needle时，提前结束循环
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {//内部自加，减少冗余字段
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
/*-----------------------------------------------------------*/

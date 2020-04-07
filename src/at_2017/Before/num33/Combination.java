package at_2017.Before.num33;

/**
 * Create by hui on 2017/8/29
 */
public class Combination {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        Combination combination = new Combination();
        combination.combination(chars);
    }

    public void combination(char[] chars) {
        if (chars == null||chars.length==0) {
            return;
        }
        int len = chars.length;
        int n = 1 << len;//2^n
        for(int i=1;i<n;i++) {
            for(int j=0;j<len;j++) {
                int temp = i;
                if ((temp& (1 << j))>0) {
                    System.out.print(chars[j]);
                }
            }
            System.out.println();
        }
    }
}

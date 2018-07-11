package Before.Test_PDD.test2;

import java.util.Scanner;

/**
 * Created by zhonghui on 2017/8/1.
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = new String[2];
        int i=0;
        while (in.hasNext()) {//注意while处理多个case
             s[i] = in.next();
             i++;
            if (i == 2) {
                break;
            }
        }

        if (s[0] == null || s[1] == null) {
            System.out.println("");
        }

        int len1 = s[0].length();
        int len2 = s[1].length();

        int c,t,tt;
        char[] r = new char[len1 + len2];
        int res_index=0;

        for(int ii=0;ii<len2;ii++) {
            c = 0;
            for(int j=0;j<len1;j++) {
                t = (s[0].charAt(len1 - 1 - j) - '0') * (s[1].charAt(len2 - 1 - ii) - '0') + c;
                if (t == 0) {
                    continue;
                }
                res_index = j + ii;
                tt = r[res_index] + t;
                r[res_index] = (char) (tt % 10);
                c = tt / 10;
            }
            if (c > 0) {
                r[++res_index] += c;
            }
        }
        for(int jj=0;jj<=res_index/2;jj++) {
            t = r[jj] + '0';
            r[jj] = (char) (r[res_index - jj] + '0');
            r[res_index - jj] = (char) t;
        }
        System.out.println(r);
    }
}

package at_2017.Before.num30;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by hui on 2017/8/22
 */
public class Combination {
    public static void main(String[] args) {
        int n = 2;
        int m = 5;
        Combination combination = new Combination();
//        System.out.println(combination.combin1(m, n));
        System.out.println(combination.combin3(m, n));
    }

    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * version1
     * c(m,n)=m!/(n!*(m-n)!)
     *
     * @param m
     * @param n
     * @return
     */
    public int combin1(int m, int n) {
        int facM = factorial(m);
        int facN = factorial(n);
        int facMN = factorial(m - n);
        int result = facM / (facN * facMN);
        return result;
    }

    /**
     * version2
     * c(m,n)=c(m-1,n-1)+c(m-1,n)
     *
     * @param m
     * @param n
     * @return
     */
    public int combin2(int m, int n) {
        int[][] c = new int[m + 1][m + 1];
        c[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            c[0][i] = 0;
            c[i][0] = 1;
        }
        for (int j = 1; j <= m; j++) {
            for (int k = 1; k <= n; k++) {
                c[j][k] = c[j - 1][k - 1] + c[j - 1][k];
            }
        }
        return c[m][n];
    }

    /**
     * version3
     * Prime factorization
     *
     * @param m
     * @param n
     * @return
     */
    public int combin3(int m, int n) {
        List prim = produce_prim();
        long ans = 1;
        int num;
        for (int i = 0; i < prim.size() && (int) prim.get(i) <= m; ++i) {
            int primNum = (int) prim.get(i);
            num = cal(m, primNum) - cal(n, primNum) - cal(m - n, primNum);
//            ans = (long) (ans * Math.pow(primNum, num));
            ans = ans * Pow(primNum, num);
        }
        return (int) ans;

    }

    public int Pow(int n, int k) {
        long ans = 1;
        while (k>=1) {
            if (k>=1) {
                ans = ans * n;
            }
            n = n * n;
            k >>= 1;
        }
        return (int) ans;
    }

    public int cal(int x, int p) {
        int ans = 0;
        long rec = p;
        while (x >= rec) {
            ans += x / rec;
            rec *= p;
        }
        return ans;
    }

    public List<Integer> produce_prim() {
        int max = 1000;
        ArrayList<Integer> prims = new ArrayList<>();
        boolean[] arr = new boolean[max + 1];
        prims.add(2);
        int i;
        for (i = 3; i * i <= max; i += 2) {
            if (!arr[i]) {
                prims.add(i);
                for (int j = i * i; j <= max; j += i) {
                    arr[j] = true;
                }
            }
        }
        while (i <= max) {
            if (!arr[i]) {
                prims.add(i);
            }
            i += 2;
        }
        return prims;
    }
}

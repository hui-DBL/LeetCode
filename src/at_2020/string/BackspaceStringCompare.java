package at_2020.string;

/**
 * @Author libing
 * @Date 2020/10/19
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {

    }

    public static boolean backspaceCompare(String S, String T) {
        char[] charsS = new char[S.length()];
        int indexS = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                charsS[indexS] = S.charAt(i);
                indexS++;
            } else {
                indexS--;
                if (indexS < 0) {
                    indexS = 0;
                }
            }
        }

        char[] charsT = new char[T.length()];
        int indexT = 0;
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                charsT[indexT] = T.charAt(i);
                indexT++;
            } else {
                indexT--;
                if (indexT < 0) {
                    indexT = 0;
                }
            }
        }

        if (indexS != indexT) {
            return false;
        }
        for (int i = 0; i < indexS; i++) {
            if (charsS[i] != charsT[i]) {
                return false;
            }
        }
        return true;
    }
}

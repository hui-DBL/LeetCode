package num26;

/**
 * Create by hui on 2017/8/18
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "0";
        String b = "100";
        Solution solution = new Solution();
        System.out.println(solution.addBinary(a,b));
    }
}

class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0 || a == null||a.equals("0")) {
            return b;
        } else if (b.length() == 0 || b == null||b.equals("0")) {
            return a;
        }
        int la = a.length();
        int lb = b.length();
        char[] c = new char[Math.max(la, lb)+1];
        int i = 1;
        int isCarry = 0;
        while (i <= la && i <= lb) {
            int temp = ((a.charAt(la - i) + b.charAt(lb - i)) - '0'-'0') + isCarry;
            c[c.length - i] = (char) ((temp % 2)+'0');
            isCarry = temp / 2;
            i++;
        }
        while (i <= la) {
            int temp = (a.charAt(la - i) - '0') + isCarry;
            c[c.length - i] = (char) ((temp % 2)+'0');
            isCarry = temp / 2;
            i++;
        }
        while (i <= lb) {
            int temp = (b.charAt(lb - i) - '0') + isCarry;
            c[c.length - i] = (char) ((temp % 2)+'0');
            isCarry = temp / 2;
            i++;
        }
        int j = 1;
        StringBuilder sb = new StringBuilder();
        if (isCarry == 1) {
            c[0] = '1';
            j = 0;
        }
        for(;j<c.length;j++) {
            sb.append(c[j]);
        }
        return sb.toString();
    }
}

package at_2018.LeetCode.string;

public class SimplifyPath {
    public static void main(String[] args) {
        String str = "/a/./b/../../c/";
        System.out.println(simplifyPath(str));
    }

    public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        String[] strings = path.split("/");
        for (int i = 0; i < strings.length; i++) {
            if ("".equals(strings[i]) || ".".equals(strings[i])) {
                continue;
            }

            if ("..".equals(strings[i])) {
                if (sb.length() <= 1) {
                    continue;
                }
                sb = delTo(sb);
                continue;
            }
            sb.append(strings[i]);
            if (sb.length() > 1) {
                sb.append("/");
            }
        }
        if (sb.length() == 1) {
            return sb.toString();
        } else {
            return sb.delete(sb.length() - 1, sb.length()).toString();
        }
    }

    private static StringBuilder delTo(StringBuilder sb) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("/");
        String[] strs = sb.toString().split("/");
        for (int i = 0; i < strs.length-1; i++) {
            if ("".equals(strs[i])) {
                continue;
            }
            tmp.append(strs[i]);
            tmp.append("/");
        }
        return tmp;
    }
}

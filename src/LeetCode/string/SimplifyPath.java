package LeetCode.string;

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
            if ("".equals(strings[i])) {
                continue;
            }
            if (".".equals(strings[i])) {
                continue;
            }
            if ("..".equals(strings[i])) {
                if (i == strings.length - 1) {
                    sb.delete(sb.length() - 1, sb.length());
                } else {
                    sb.delete(sb.length() - 2, sb.length());
                }
                continue;
            }
            sb.append(strings[i]);
            if (i != strings.length - 1) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}

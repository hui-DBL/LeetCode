package at_2020.string;

/**
 * @Author libing
 * @Date 2020/10/21
 */
public class LongPressedName {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int indexTyped = 0;
        char pre = 'A';

        for (int i = 0; i < name.length(); i++) {
            if (indexTyped >= typed.length()) {
                return false;
            }

            if (name.charAt(i) == typed.charAt(indexTyped)) {
                pre = name.charAt(i);
                indexTyped++;
            } else {
                while (pre == typed.charAt(indexTyped)) {
                    indexTyped++;
                    if (indexTyped >= typed.length()) {
                        return false;
                    }
                }
                if (name.charAt(i) == typed.charAt(indexTyped)) {
                    pre = name.charAt(i);
                    indexTyped++;
                } else {
                    return false;
                }
            }
        }
        while (indexTyped < typed.length()) {
            if (pre == typed.charAt(indexTyped)) {
                indexTyped++;
            } else {
                return false;
            }
        }
        return true;
    }
}

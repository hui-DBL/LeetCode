package at_2020.string;

/**
 * @author hui.zhong
 * @date 2020-10-08
 */
public class ReverseString {
	public static void main(String[] args) {
		char[] s = {'h', 'e', 'l', 'l', 'o'};
		reverseString(s);
	}

	public static void reverseString(char[] s) {
		int len = s.length;
		if (len <= 1) {
			return;
		}
		char tmp;
		for (int i = 0; i < len / 2; i++) {
			if (s[i] == s[len - 1 - i]) {
				continue;
			}
			tmp = s[i];
			s[i] = s[len - 1 - i];
			s[len - 1 - i] = tmp;
		}
		System.out.println(s);
	}
}

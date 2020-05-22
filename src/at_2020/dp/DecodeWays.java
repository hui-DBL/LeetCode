package at_2020.dp;

/**
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * <p>
 * 0. --1
 * 1. B --1
 * 2. B B, V --2
 * 3. B B F, VF , BZ, --3
 *
 * @author hui.zhong
 * @date 2020-05-22
 */
public class DecodeWays {
	public static void main(String[] args) {
		System.out.println(numDecodings("226"));
	}

	public static int numDecodings(String s) {
		if (s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		int[] s_array = new int[s.length() + 1];
		s_array[0] = 1;
		for (int i = 1; i <= s.length(); i++) {
			if (s.charAt(i - 1) != '0') {
				s_array[i] += s_array[i - 1];
			}
			if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
				s_array[i] += s_array[i - 2];
			}
		}
		return s_array[s.length()];
	}
}

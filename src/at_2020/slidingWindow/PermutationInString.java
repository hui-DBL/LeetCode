package at_2020.slidingWindow;


/**
 * @author hui.zhong
 * @date 2020-07-16
 */
public class PermutationInString {

	public static void main(String[] args) {
		System.out.println(checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
	}

	/**
	 * 另一种方法：通过全局频率来匹配
	 *
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}

		int[] charNums_s1 = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			int currIndex = s1.charAt(i) - 'a';
			charNums_s1[currIndex]++;
		}

		int left = 0;
		// 窗口内的各个字母数量相等即可
		for (int right = s1.length() - 1; right < s2.length(); right++) {
			int[] charNums_s2 = new int[26];

			boolean tryFlag = true;
			for (int i = left; i <= right; i++) {
				int currIndex = s2.charAt(i) - 'a';
				charNums_s2[currIndex]++;
				if (charNums_s2[currIndex] > charNums_s1[currIndex]) {
					tryFlag = false;
					break;
				}
			}
			if (tryFlag) {
				boolean returnFlag = true;
				for (int i = 0; i < charNums_s2.length; i++) {
					if (charNums_s1[i] != charNums_s2[i]) {
						returnFlag = false;
					}
				}
				if (returnFlag) {
					return true;
				}
			}
			left++;
		}
		return false;
	}
}

package at_2020.string;

/**
 * @author hui.zhong
 * @date 2020-10-02
 */
public class JewelsAndStones {

	public static void main(String[] args) {
		System.out.println(numJewelsInStones("z", "ZZ"));
	}

	public static int numJewelsInStones(String J, String S) {
		int[] nums = new int[60];
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			int cIndex = c - 'A';
			nums[cIndex]++;
		}
		int len = 0;
		for (int i = 0; i < J.length(); i++) {
			char c = J.charAt(i);
			int cIndex = c - 'A';
			len = len + nums[cIndex];
		}
		return len;
	}
}

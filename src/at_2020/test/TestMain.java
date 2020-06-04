package at_2020.test;

/**
 * 鸡兔同笼
 * @author hui.zhong
 * @date 2020-05-24
 */
public class TestMain {

	public static void main(String[] args) {
		System.out.println(solve("2,6"));
	}

	public static String solve(String headAndFoot) {
		if (headAndFoot == null) {
			return "INPUTERROR";
		}
		try {
			String[] numArray = headAndFoot.split(",");
			int n = Integer.parseInt(numArray[0]);
			int m = Integer.parseInt(numArray[1]);
			int chicken = (4 * n - m) / 2;
			int tu = n - chicken;
			if (tu * 4 + chicken * 2 == m) {
				if (chicken > -1 && tu > -1) {
					if (chicken == 0 || tu == 0) {
						return "NODATA";
					}
					return chicken + "," + tu;
				} else {
					return "NODATA";
				}
			} else {
				return "NODATA";
			}
		} catch (NumberFormatException e) {
			return "INPUTERROR";
		}
	}
}

package at_2020.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-08-24
 */
public class RestoreIpAddresses {

	public static void main(String[] args) {
		String str = "101023";
		System.out.println(restoreIpAddresses(str));
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		if (s.length() < 4) {
			return list;
		}
		for (int i = 0; i < 3; i++) {
			if (s.length() < i + 1) {
				continue;
			}
			String head = s.substring(0, i + 1);
			if (head.length() > 1 && "0".equals(head.substring(0, 1))) {
				continue;
			}
			Integer headNum = Integer.valueOf(head);
			if (headNum <= 255) {
				buildIp(list, head, s.substring(i + 1), 3);
			}
		}
		return list;
	}

	private static void buildIp(List<String> list, String in, String out, int times) {
		if (times == 0) {
			if ("".equals(out)) {
				list.add(in);
				return;
			} else {
				return;
			}
		} else {
			if ("".equals(out)) {
				return;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (out.length() < i + 1) {
				continue;
			}
			String head = out.substring(0, i + 1);
			if (head.length() > 1 && "0".equals(head.substring(0, 1))) {
				continue;
			}
			Integer headNum = Integer.valueOf(head);
			if (headNum <= 255) {
				buildIp(list, in + "." + head, out.substring(i + 1), times - 1);
			}
		}
	}
}

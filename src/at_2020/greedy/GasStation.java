package at_2020.greedy;

/**
 * @author hui.zhong
 * @date 2020-07-01
 */
public class GasStation {
	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {3, 4, 5, 1, 2};
//		System.out.println(canCompleteCircuit(gas, cost));
		System.out.println(canCompleteCircuit1(gas, cost));
	}

	public static int canCompleteCircuit1(int[] gas, int[] cost) {
//		int start = 0;
//		int curr = 0;
//
//		for (int i = 0; i < gas.length; i++) {
//			curr += gas[i];
//			curr -= cost[i];
//			if (curr < 0) {
//				start++;
//			}
//		}
//
//		return curr >= 0 ? start : -1;
//
		int n = gas.length;

		int total_tank = 0;
		int curr_tank = 0;
		int starting_station = 0;
		for (int i = 0; i < n; ++i) {
			// 总油量超过总消耗量就行
			total_tank += gas[i] - cost[i];
			// 确定一个出发的地点
			curr_tank += gas[i] - cost[i];
			// If one couldn't get here,
			if (curr_tank < 0) {
				// Pick up the next station as the starting one.
				starting_station = i + 1;
				// Start with an empty tank.
				curr_tank = 0;
			}
		}
		return total_tank >= 0 ? starting_station : -1;
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			if (canCompleteCircuit(gas, cost, i, 0, i, false)) {
				return i;
			}
		}
		return -1;
	}

	private static boolean canCompleteCircuit(int[] gas, int[] cost, int i, int nowGas, int start, boolean next) {
		if (i >= gas.length) {
			i -= gas.length;
			next = true;
		}
		// 加油后
		nowGas += gas[i];
		// 去下一站
		if (nowGas < cost[i]) {
			return false;
		}
		if (next && i == start) {
			return true;
		}
		nowGas -= cost[i];
		return canCompleteCircuit(gas, cost, ++i, nowGas, start, next);
	}
}

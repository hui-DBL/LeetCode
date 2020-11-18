package at_2020.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author libing
 * @Date 2020/11/18
 */
public class canCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                starts.add(i);
            }
        }
        if (starts.size() == 0) {
            return -1;
        }
        for (int start : starts) {
            if (canCompleteCircuit(start, gas, cost)) {
                return start;
            }
        }
        return -1;
    }

    private static boolean canCompleteCircuit(int start, int[] gas, int[] cost) {
        int index = start;
        int re = gas[index] - cost[index];
        if (re < 0) {
            return false;
        }
        index++;
        if (index >= gas.length) {
            index = index - gas.length;
        }
        while (index != start) {
            re = re + gas[index] - cost[index];
            if (re < 0) {
                return false;
            }
            index++;
            if (index >= gas.length) {
                index = index - gas.length;
            }
        }
        return true;
    }
}

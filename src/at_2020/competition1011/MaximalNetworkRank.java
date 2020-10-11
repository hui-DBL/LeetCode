package at_2020.competition1011;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hui.zhong
 * @date 2020/10/11
 */
public class MaximalNetworkRank {

    public static void main(String[] args) {
        int[][] roads = {{2, 4}};
        System.out.println(maximalNetworkRank(6, roads));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0) {
            return 0;
        }
        Map<Integer, Set<Integer>> nRoadMap = new HashMap<>(n);
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];

            Set<Integer> fromCount = nRoadMap.get(from);
            Set<Integer> toCount = nRoadMap.get(to);
            if (fromCount == null) {
                fromCount = new HashSet<>();
            }
            fromCount.add(to);
            nRoadMap.put(from, fromCount);

            if (toCount == null) {
                toCount = new HashSet<>();
            }
            toCount.add(from);
            nRoadMap.put(to, toCount);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                Set<Integer> icount = nRoadMap.get(i);
                Set<Integer> jcount = nRoadMap.get(j);

                int totalCount = 0;
                if (icount == null && jcount == null) {

                } else if (icount == null && jcount != null) {
                    totalCount = jcount.size();
                } else if (icount != null && jcount == null) {
                    totalCount = icount.size();
                } else {
                    totalCount = icount.size() + jcount.size();
                    if (icount.contains(j) && jcount.contains(i)) {
                        totalCount--;
                    }
                }
                max = Math.max(totalCount, max);
            }
        }

        return max;
    }
}

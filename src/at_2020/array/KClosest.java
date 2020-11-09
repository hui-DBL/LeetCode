package at_2020.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author libing
 * @Date 2020/11/9
 */
public class KClosest {

    public static void main(String[] args) {

    }

    public static int[][] kClosest(int[][] points, int K) {
        TreeMap<Integer, List<String>> treeMap = new TreeMap<Integer, List<String>>();
        for (int i = 0; i < points.length; i++) {
            int len = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            List<String> list = treeMap.getOrDefault(len, new ArrayList<String>());
            list.add(points[i][0] + "," + points[i][1]);
            treeMap.put(len, list);
        }
        int[][] sets = new int[K][2];
        int index = 0;
        for (Map.Entry<Integer, List<String>> entry : treeMap.entrySet()) {
            if (index == K) {
                break;
            }
            for (String str : entry.getValue()) {
                String[] strings = str.split(",");
                sets[index][0] = Integer.valueOf(strings[0]);
                sets[index][1] = Integer.valueOf(strings[1]);
                index++;
                if (index == K) {
                    break;
                }
            }
        }
        return sets;
    }
}

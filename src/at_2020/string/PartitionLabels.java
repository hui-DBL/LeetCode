package at_2020.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author libing
 * @Date 2020/10/22
 */
public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(partitionLabels("a"));
    }

    public static List<Integer> partitionLabels(String S) {
        int[] numMax = new int[S.length()];
        for (int i = 0; i < S.length() - 1; i++) {
            numMax[i] = i;
            char c = S.charAt(i);
            for (int j = i + 1; j < S.length(); j++) {
                if (c == S.charAt(j)) {
                    numMax[i] = Math.max(numMax[i], j);
                }
            }
        }
        numMax[S.length() - 1] = S.length() - 1;

        List<Integer> list = new ArrayList<>();
        int index = 0;
        while (index < S.length()) {
            int start = index;
            int max = numMax[index];
            for (; index <= max; index++) {
                if (numMax[index] <= max) {
                    continue;
                } else {
                    max = numMax[index];
                }
            }
            list.add(max - start + 1);
        }

        return list;
    }
}

package at_2018.util;

import java.util.List;

public class ListUtil {
    public static void showLists(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
    }

    public static void showList(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}

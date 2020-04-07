package at_2018.LeetCode.string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        showList(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> stringListMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String tmp = sortString(strs[i]);
            if (stringListMap.containsKey(tmp)) {
                stringListMap.get(tmp).add(strs[i]);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                stringListMap.put(tmp, strings);
            }
        }
        List<List<String>> lists = new ArrayList<>();
        for (String s : stringListMap.keySet()) {
            lists.add(stringListMap.get(s));
        }
        return lists;
    }

    private static String sortString(String tmp) {
        char[] tmpArr = tmp.toCharArray();
        Arrays.sort(tmpArr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmpArr.length; i++) {
            sb.append(tmpArr[i]);
        }
        return sb.toString();
    }

    public static void showList(List<List<String>> lists) {
        for (List<String> list : lists) {
            for (String str : list) {
                System.out.printf(str);
            }
            System.out.println();
        }
    }
}

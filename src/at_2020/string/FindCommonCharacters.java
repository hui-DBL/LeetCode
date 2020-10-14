package at_2020.string;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public static void main(String[] args) {
        String[] strs = {"bella", "label", "roller"};
        System.out.println(commonChars(strs));
    }

    public static List<String> commonChars(String[] A) {
        int[] numOfChar = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            char c = A[0].charAt(i);
            numOfChar[c - 'a']++;
        }

        for (int i = 1; i < A.length; i++) {
            int[] numOfCharCurr = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                char c = A[i].charAt(j);
                numOfCharCurr[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                numOfChar[j] = Math.min(numOfChar[j], numOfCharCurr[j]);
            }
        }

        List<String> strs = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < numOfChar[i]; j++) {
                char c = (char) ('a' + i);
                strs.add(String.valueOf(c));
            }
        }
        return strs;
    }
}

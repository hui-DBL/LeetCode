package at_2020.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hui.zhong
 * @date 2020/10/25
 */
public class SlowestKey {

    public static void main(String[] args) {
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        System.out.println(videoStitching(clips, 10));
    }

    public static int videoStitching(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }


    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int timeMax = -1;
        char characterMax = 'a';
        for (int i = 0; i < keysPressed.length(); i++) {
            char character = keysPressed.charAt(i);
            if (i == 0) {
                timeMax = releaseTimes[0];
                characterMax = character;
            } else {
                if (timeMax > releaseTimes[i] - releaseTimes[i - 1]) {
                } else if (timeMax == releaseTimes[i] - releaseTimes[i - 1]) {
                    if (characterMax >= character) {
                    } else {
                        characterMax = character;
                    }
                } else {
                    characterMax = character;
                    timeMax = releaseTimes[i] - releaseTimes[i - 1];
                }
            }
        }
        return characterMax;
    }
}

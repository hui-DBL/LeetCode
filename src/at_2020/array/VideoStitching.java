package at_2020.array;


/**
 * @Author libing
 * @Date 2020/10/24
 */
public class VideoStitching {

    public static void main(String[] args) {
        int[][] clips = {{5, 7}, {1, 8}, {0, 0}, {2, 3}, {4, 5}, {0, 6}, {5, 10}, {7, 10}};
        System.out.println(videoStitching(clips,5));
    }

    public static int videoStitching(int[][] clips, int T) {
        int[] clipNodes = new int[T];
        for (int[] clip : clips) {
            if (clip[0] < T) {
                clipNodes[clip[0]] = Math.max(clipNodes[clip[0]], clip[1]);
            }
        }
        int preLast = -1;
        int last = 0;
        int count = 0;
        for (int i = 0; i < T; i++) {
            if (clipNodes[i] > last) {
                if (i > preLast) {
                    count++;
                    preLast = last;
                }
                last = clipNodes[i];
                if (last >= T) {
                    return count;
                }
            } else {
                if (last <= i) {
                    return -1;
                }
            }
        }
        return count;
    }
}

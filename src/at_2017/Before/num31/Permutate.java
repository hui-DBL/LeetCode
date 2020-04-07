package at_2017.Before.num31;

import java.util.Arrays;

/**
 * Create by hui on 2017/8/24
 */
public class Permutate {
    public static int total = 0;

    public static void swap(String[] str, int i, int j) {
        String temp = new String();
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void arrange(String[] str, int st, int len) {
        if (st == len - 1) {
            for (int i = 0; i < len; i++) {
                System.out.print(str[i] + "  ");
            }
            System.out.println();
            total++;
        } else {
            for (int i = st; i < len; i++) {
                swap(str, st, i);
                arrange(str, st + 1, len);
                swap(str, st, i);
            }
        }

    }

    public static void arrangeWithNoDuplicate(String str[], int st, int len) {

        if (st == len - 1) {
            for (int i = 0; i < len; i++) {
                System.out.print(str[i] + "  ");
            }
            System.out.println();
            total++;
        } else {
            for (int i = st; i < len; i++) {
                if (i == st || str[i] != str[st]) {
                    //在排列的时候进行判断如果后面的元素与start相同时就不进行排序。
                    //这样就可以避免对重复元素进行排序
                    swap(str, st, i);
                    arrangeWithNoDuplicate(str, st + 1, len);
                    swap(str, st, i);
                }
            }
        }
    }

    public static void arrangeWithDictionary(char chs[]) {
        Arrays.sort(chs);
        //先对数组的元素进行依次排序
        while (true) {
            System.out.println(chs);
            total++;
            int j = chs.length - 1;
            int index = 0;
            for (j = chs.length - 2; j >= 0; j--) {
                if (chs[j] < chs[j + 1]) {
                    index = j;
                    break;
                    //从右向左找到第一个非递增的元素
                } else if (j == 0) {//最大序
                    return;
                }
            }

            for (j = chs.length - 1; j >= 0; j--) {
                if (chs[j] > chs[index])
                    break;
                //从右向左找到第一个比非递增元素大的元素
            }
            Swap(chs, index, j);
            //交换找到的两个元素
            Reverse(chs, index + 1);
            //对非递增元素位置后面的数组进行逆序排列
        }
    }

    public static void Reverse(char chs[], int i) {
        int k = i, j = chs.length - 1;
        while (k < j) {
            Swap(chs, k, j);
            k++;
            j--;
        }
    }

    public static void Swap(char chs[], int i, int j) {
        char temp;
        temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }


    public static void main(String[] args) {
        String str[] = {"b", "a", "c"};
        char[] chars = {'1', '2', '3'};
        arrangeWithDictionary(chars);
        System.out.println(total);
    }
}
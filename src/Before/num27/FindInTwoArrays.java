package Before.num27;

/**
 * Create by hui on 2017/8/18
 * 题目三：二维数组中查找
 * <p>
 * 在一个二维数组中，每一行都按照从左到右递增顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含
 * 有该整数。
 * <p>
 * 数组：1  2  8  9
 * 2  4  9  12
 * 4  7 10  13
 * 6  8 11  15
 * 整数：7
 * 返回true
 */
public class FindInTwoArrays {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] x = new int[4];
//        int[] y = new int[4];
//        for(int i=0;i<4;i++) {
//            for(int j=0;j<4;j++) {
//                //注：从控制台输入
//            }
//        }
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int num = 14;
        System.out.println(findTarget(matrix, num));
//        System.out.println(matrix[1].length);
//        System.out.println(matrix.length);
//        System.out.println(matrix[3][3]);
    }

    public static boolean findTarget(int[][] matrix, int num) {
        if (matrix == null) {
            return false;
        }
        boolean result = false;
        int rows = matrix.length;//行
        int columns = matrix[0].length;//第一行有多少列
        int x = 0;
        int y = columns-1;
        while (x <rows && y >=0) {
            int temp = matrix[x][y];//先行后列 选取的是右上角
            if (temp == num) {
                return true;
            } else if (temp > num) {
                y--;
            } else if (temp < num) {
                x++;
            }
        }
        return result;
    }
}

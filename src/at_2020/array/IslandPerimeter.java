package at_2020.array;

/**
 * @Author libing
 * @Date 2020/10/30
 */
public class IslandPerimeter {

    public static void main(String[] args) {

    }

    public static int islandPerimeter(int[][] grid) {
        int len = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (j - 1 < 0) {
                        len++;
                    } else {
                        if (grid[i][j - 1] != 1) {
                            len++;
                        }
                    }

                    if (j + 1 >= grid[0].length) {
                        len++;
                    } else {
                        if (grid[i][j + 1] != 1) {
                            len++;
                        }
                    }

                    if (i - 1 < 0) {
                        len++;
                    } else {
                        if (grid[i - 1][j] != 1) {
                            len++;
                        }
                    }

                    if (i + 1 >= grid.length) {
                        len++;
                    } else {
                        if (grid[i + 1][j] != 1) {
                            len++;
                        }
                    }
                }
            }
        }
        return len;
    }
}

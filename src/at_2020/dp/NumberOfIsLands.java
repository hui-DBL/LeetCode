package at_2020.dp;

/**
 * @author hui.zhong
 * @date 2020-08-25
 */
public class NumberOfIsLands {

	public static void main(String[] args) {
		char[][] grid = {

		};
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		// 遍历，能联通的就置为0
		int rowNum = grid.length;
		if (rowNum == 0) {
			return 0;
		}
		int column = grid[0].length;
		int num = 0;
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == '1') {
					num++;
				}
				// 前后左右(正常右下即可)
				propagate(i, j, rowNum, column, grid);
			}
		}
		return num;
	}

	private static void propagate(int i, int j, int rowNum, int column, char[][] grid) {
		// 自身变成0
		int self = grid[i][j];
		if (self == '0') {
			return;
		}
		grid[i][j] = '0';
		// 上
		if (i - 1 >= 0) {
			int tmp = grid[i - 1][j];
			if (tmp == '1') {
				propagate(i - 1, j, rowNum, column, grid);
			}
		}
		// 下
		if (i + 1 <= rowNum - 1) {
			int tmp = grid[i + 1][j];
			if (tmp == '1') {
				propagate(i + 1, j, rowNum, column, grid);
			}
		}
		// 左
		if (j - 1 >= 0) {
			int tmp = grid[i][j - 1];
			if (tmp == '1') {
				propagate(i, j - 1, rowNum, column, grid);
			}
		}
		// 右
		if (j + 1 <= column - 1) {
			int tmp = grid[i][j + 1];
			if (tmp == '1') {
				propagate(i, j + 1, rowNum, column, grid);
			}
		}
	}

}

package at_2020.backtrating;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hui.zhong
 * @date 2020-04-17
 */
public class SudokuSolver {
	public static void main(String[] args) {
		char[][] sudoku = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		solveSudoku(sudoku);
		System.out.println(sudoku);
	}

	public static void solveSudoku(char[][] board) {
//		if (board == null) {
//			return;
//		}
//		// 遍历确定总数
//		List<Coordinate> coordinates = new ArrayList<>();
//		for (int col = 0; col < board.length; col++) {
//			for (int row = 0; row < board[0].length; row++) {
//				if (board[row][col] == '.') {
//					coordinates.add(new Coordinate(row, col));
//				}
//			}
//		}
//		solve(coordinates, board);
		solve(board);
	}

	private static boolean solve(char[][] board) {
		for (int col = 0; col < board.length; col++) {
			for (int row = 0; row < board[0].length; row++) {
				if (board[row][col] != '.') {
					continue;
				}
				// 试答案
				for (char i = '1'; i <= '9'; i++) {
					if (valid(board, col, row, i)) {
						board[row][col] = i;
						if (solve(board)) {
							return true;
						}
						board[row][col] = '.';
					}
				}
				return false;
			}
		}
		return true;
	}

	private static boolean valid(char[][] board, int col, int row, char i) {
		for (int j = 0; j < 9; j++) {
			// 行
			if (board[row][j] != '.' && board[row][j] == i) {
				return false;
			}
			// 列
			if (board[j][col] != '.' && board[j][col] == i) {
				return false;
			}
			// 区域
			if (board[3 * (row / 3) + j / 3][3 * (col / 3) + j % 3] != '.'
					&&
					board[3 * (row / 3) + j / 3][3 * (col / 3) + j % 3] == i) {
				return false;
			}
		}
		return true;
	}

//	private static void solve(List<Coordinate> coordinates, char[][] board) {
//		if (coordinates.size() == 0) {
//			return;
//		}
//		List<Coordinate> result = new ArrayList<>();
//		for (Coordinate coordinate : coordinates) {
//			// 行候选、列候选、区域候选取交集，如果唯一，则确定，否则跳过
//
//			List<Character> rowAll = buildAll();
//
//			// 行已有
//			List<Character> rowFormal = new ArrayList<>();
//			for (int col = 0; col < board[coordinate.x].length; col++) {
//				char tmp = board[coordinate.x][col];
//				if (tmp != '.') {
//					rowFormal.add(tmp);
//				}
//			}
//			// 行候选
//			rowAll.removeAll(rowFormal);
//
//			List<Character> colAll = buildAll();
//			// 列已有
//			List<Character> colFormal = new ArrayList<>();
//			for (int row = 0; row < board.length; row++) {
//				char tmp = board[row][coordinate.y];
//				if (tmp != '.') {
//					colFormal.add(tmp);
//				}
//			}
//			// 列候选
//			colAll.removeAll(colFormal);
//
//			List<Character> regionAll = buildAll();
//			// 区域已有
//			List<Character> regionFormal = new ArrayList<>();
//			int regionRowStart = 0;
//			int regionRowEnd = 0;
//			int regionColStart = 0;
//			int regionColEnd = 0;
//			for (int i = regionRowStart; i <= regionRowEnd; i++) {
//				for (int j = regionColStart; j <= regionColEnd; j++) {
//					char tmp = board[i][j];
//					if (tmp != '.') {
//						regionFormal.add(tmp);
//					}
//				}
//			}
//			// 区域候选
//			regionAll.removeAll(regionFormal);
//
//			rowAll.retainAll(colAll);
//			rowAll.retainAll(regionAll);
//			if (rowAll.size() == 1) {
//				// 现有
//				result.add(coordinate);
//				board[coordinate.x][coordinate.y] = rowAll.get(0);
//			} else {
//				continue;
//			}
//		}
//		if (result.size() > 0) {
//			coordinates.removeAll(result);
//		}
//		solve(coordinates, board);
//	}
//
//	private static List<Character> buildAll() {
//		List<Character> all = new ArrayList<>();
//		all.add('1');
//		all.add('2');
//		all.add('3');
//		all.add('4');
//		all.add('5');
//		all.add('6');
//		all.add('7');
//		all.add('8');
//		all.add('9');
//
//		return all;
//	}

}

class Coordinate {
	int x;

	int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

package packageName;

import java.util.Random;

public class MatrixPuzzle {

	public static void main(String[] args) {
		int[][] board = new int[5][5];
		Random random = new Random();
		
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				board[x][y] = random.nextInt(15) + 1;
				System.out.print(board[x][y] + " ");
			}
			System.out.print("\n");
		}
		
		System.out.println(detectEquivalentAdjacentPairs(board));
		
		checkDuplicates(board);
		
		
		int[][] board2 = shiftRight(board, 2, 1);
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				System.out.print(board2[x][y] + " ");
			}
			System.out.print("\n");
		}
		
		int[][] board3 = shiftUp(board, 3, 2);
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				System.out.print(board3[x][y] + " ");
			}
			System.out.print("\n");
		}

	}
	
	
	public static int detectEquivalentAdjacentPairs(int[][] arr) {
		int first = 0;
		int second = 0;
		int count = 0;
		for (int[] row : arr) {
			second = 0;
			for (int num : row) {
				first = second;
				second = num;
				if (first == second) {
					count++;
				}
			}
		}
		return count;
	}
	
	
	public static void checkDuplicates(int[][] arr) {
		int[] counts = new int[15];
		for (int[] row : arr) {
			for (int num : row) {
				counts[num - 1]++;
			}
		}
		
		for (int i = 0; i < 15; i++) {
			if (counts[i] > 1) {
				System.out.println(i+1 + ": " + counts[i]);
			}
		}
	}
	
	
	public static int[][] shiftRight(int[][] arr, int shift, int row) {
		int[][] output = new int[5][5];
		for (int i = 0; i < 5; i++) {
			output[row][(i+shift) % 5] = arr[row][i];
		}
		for (int j = 0; j < 5; j++) {
			arr[row][j] = output[row][j];
		}
		return arr;
	}
	
	
	public static int[][] shiftUp(int[][] arr, int shift, int col) {
		int[][] output = new int[5][5];
		for (int i = 0; i < 5; i++) {
			output[(i+shift) % 5][col] = arr[i][col];
		}
		for (int j = 0; j < 5; j++) {
			arr[j][col] = output[j][col];
		}
		return arr;
	}

}

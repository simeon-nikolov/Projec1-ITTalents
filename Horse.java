import java.util.Scanner;

public class Horse {

	public static void main(String[] args) {
		System.out.println("Enter number of rows: ");
		Scanner sc = new Scanner(System.in);
		int rowsCount = sc.nextInt();
		System.out.println("Enter number of columns: ");
		int colsCount = sc.nextInt();
		char[][] board = new char[rowsCount][colsCount];
		
		initializeBoard(board);
		
		System.out.println("Enter starting coordinares.\nEnter row number:");
		int startRow = sc.nextInt();
		
		while (startRow > rowsCount || startRow < 1) {
			System.out.println("Enter valid row number:");
			startRow = sc.nextInt();
		}
		
		System.out.println("Enter column number:");
		int startCol = sc.nextInt();
		
		while (startCol > colsCount || startCol < 1) {
			System.out.println("Enter valid column number:");
			startCol = sc.nextInt();
		}

		startRow--;
		startCol--;
		
		fillDots(board, startRow, startCol);
		printBorders(board);

	}

	private static void initializeBoard(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}
	}

	static void fillDots(char[][] board, int coordX, int coordY) {
		if (coordX < 0 || coordX >= board.length) {
			return;
		}
		
		if (coordY < 0 || coordY >= board[coordX].length) {
			return;
		}
		
		if (board[coordX][coordY] == '.') {
			return;
		}
		
		board[coordX][coordY] = '.';
		
		fillDots(board, coordX - 2, coordY - 1);
		fillDots(board, coordX - 2, coordY + 1);
		fillDots(board, coordX - 1, coordY - 2);
		fillDots(board, coordX - 1, coordY + 2);
		fillDots(board, coordX + 2, coordY - 1);
		fillDots(board, coordX + 2, coordY + 1);
		fillDots(board, coordX + 1, coordY - 2);
		fillDots(board, coordX + 1, coordY + 2);

	}

	static void print(char[][] x) {		
		for (int row = 0; row < x.length; row++) {
			for (int col = 0; col < x[row].length; col++) {
				System.out.print(x[row][col] + " ");
			}
			
			System.out.println();
		}

	}

	static void printBorders(char[][] board) {
		char[][] outputBoard = new char[board.length * 2 + 1][board[0].length * 2 + 1];
		
		initializeBoard(outputBoard);
		
		for (int row = 0; row < outputBoard.length; row += 2) {
			for (int col = 0; col < outputBoard[row].length; col++) {
				outputBoard[row][col] = '-';
			}
		}
		
		for (int row = 1; row < outputBoard.length; row += 2) {
			for (int col = 0; col < outputBoard[row].length; col++) {
				outputBoard[row][col] = '|';
			}
		}
		
		for (int row = 1; row < outputBoard.length; row += 2) {
			for (int col = 1; col < outputBoard[row].length; col += 2) {
				outputBoard[row][col] = board[row / 2][col / 2];
			}
		}
		
		print(outputBoard);
	}
}

import java.util.Scanner;

public class Horse {
	private static final char BLACK_KNIGHT_UNICODE = '\u265E';
	private static final char WHITE_KNIGHT_UNICODE = '\u2658';
	
	private char[][] board;
	private int startRow;
	private int startCol;
	
	public void findPath() {
		getInputData();
		fillBoard(startRow, startCol);
		this.board[startRow][startCol] = WHITE_KNIGHT_UNICODE;
		printBoard();
	}

	private void getInputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows: ");
		int rowsCount = sc.nextInt();
		System.out.println("Enter number of columns: ");
		int colsCount = sc.nextInt();
		this.board = new char[rowsCount][colsCount];
		initializeBoard(board);
		System.out.println("Enter starting coordinares.");
		System.out.println("Enter row number:");
		startRow = sc.nextInt();
		
		while (startRow > rowsCount || startRow < 1) {
			System.out.println("Enter valid row number:");
			startRow = sc.nextInt();
		}
		
		System.out.println("Enter column number:");
		startCol = sc.nextInt();
		
		while (startCol > colsCount || startCol < 1) {
			System.out.println("Enter valid column number:");
			startCol = sc.nextInt();
		}

		startRow--;
		startCol--;
	}

	private static void initializeBoard(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}
	}

	private void fillBoard(int coordX, int coordY) {
		if (coordX < 0 || coordX >= board.length) {
			return;
		}
		
		if (coordY < 0 || coordY >= board[coordX].length) {
			return;
		}
		
		if (this.board[coordX][coordY] != ' ') {
			return;
		}
		
		this.board[coordX][coordY] = BLACK_KNIGHT_UNICODE;
		
		fillBoard(coordX - 2, coordY - 1);
		fillBoard(coordX - 2, coordY + 1);
		fillBoard(coordX - 1, coordY - 2);
		fillBoard(coordX - 1, coordY + 2);
		fillBoard(coordX + 2, coordY - 1);
		fillBoard(coordX + 2, coordY + 1);
		fillBoard(coordX + 1, coordY - 2);
		fillBoard(coordX + 1, coordY + 2);
	}

	private void printBoard() {
		int lineLenght = this.board[0].length * 4 + 1; // The length of the lines between the rows 
		printHorizontalLine(lineLenght);
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print("| " + board[row][col] + " ");
			}
			
			System.out.println("|");
			printHorizontalLine(lineLenght);
		}
	}
	
	private void printHorizontalLine(int lineLenght) {
		for (int col = 0; col < lineLenght; col++) {
			System.out.print("-");
		}
		
		System.out.println();
	}
}

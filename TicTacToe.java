import java.util.Locale;
import java.util.Scanner;

public class TicTacToe {
	private Scanner sc = new Scanner(System.in);
	private char[][] matrix = new char[3][3];
	private boolean winFirst = false;        
	private boolean winSecond = false;
	
	public TicTacToe() {
		Locale.setDefault(Locale.US);
		initializeMatrix();
	}
	
	public void run() {		
		printBoard();
		int choice = 0;
		int movesCount = 0;
		
		while (true) {
			// Ход на играч 1
			System.out.print("1: ");
			choice = this.getInput(1);
			makeMove(choice, 'x');
			movesCount++;
			printBoard();
			winFirst = checkForWin('x');
			
			if (winFirst || movesCount == 9) {
				break;
			}

			// Ход на играч 2
			System.out.print("2: ");
			choice = this.getInput(2);
			makeMove(choice, 'o');
			movesCount++;
			printBoard();
			winSecond = checkForWin('o');
			
			if (winSecond || movesCount == 9) {
				break;
			}
		}
		
		printWinMessage();
	}

	private int getInput(int player) {
		int input = sc.nextInt();
		
		while (!checkValidMove(input)) {
			System.out.print(player + ": ");
			input = sc.nextInt();
		}
		
		return input;
	}

	private void printWinMessage() {
		if (this.winFirst) {
			System.out.println("Печели играч 1!");
		} else {
			if (this.winSecond) {
				System.out.println("Печели играч 2!");
			} else {
				System.out.println("Равенство!");
			}
		}
		
		System.out.println();
	}

	private void makeMove(int choice, char symbol) {
		int selectedRow = getRow(choice);
		int selectedCol = getCol(choice);
		matrix[selectedRow][selectedCol] = symbol;
	}

	private boolean checkValidMove(int choice) {
		int row = getRow(choice);
		int col = getCol(choice);
		
		if (row < 0 || row > 2) {
			return false;
		}
		
		if (col < 0 || col > 2) {
			return false;
		}
		
		if (matrix[row][col] != ' ') {
			return false;
		}

		return true;
	}

	private int getCol(int choice) {
		return (choice % 10) - 1;
	}

	private int getRow(int choice) {
		return (choice / 10) - 1;
	}

	private void initializeMatrix() {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = ' ';
			}
		}
	}

	private boolean checkForWin(char symbol) {
		if (matrix[0][0] == symbol && matrix[0][1] == symbol && matrix[0][2] == symbol) {
			return true;
		}
		
		if (matrix[1][0] == symbol && matrix[1][1] == symbol && matrix[1][2] == symbol) {
			return true;
		}
		
		if (matrix[2][0] == symbol && matrix[2][1] == symbol && matrix[2][2] == symbol) {
			return true;
		}
		
		if (matrix[0][0] == symbol && matrix[1][0] == symbol && matrix[2][0] == symbol) {
			return true;
		}
		
		if (matrix[0][1] == symbol && matrix[1][1] == symbol && matrix[2][1] == symbol) {
			return true;
		}
		
		if (matrix[0][2] == symbol && matrix[1][2] == symbol && matrix[2][2] == symbol) {
			return true;
		}
		
		if (matrix[0][0] == symbol && matrix[1][1] == symbol && matrix[2][2] == symbol) {
			return true;
		}
		
		if (matrix[0][2] == symbol && matrix[1][1] == symbol && matrix[2][0] == symbol) {
			return true;
		}
		
		return false;
	}

	private void printBoard() {
		System.out.print("  ");
		
		for (int col = 0; col < matrix[0].length; col++) {
			System.out.print("  " + (col + 1) + " ");
		}
		
		System.out.println();
		
		int lineLenght = matrix[0].length * 4 + 1; // The length of the lines between the rows 
		printHorizontalLine(lineLenght);
		
		for (int row = 0; row < matrix.length; row++) {
			System.out.print((row + 1) + " ");
			
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print("| " + matrix[row][col] + " ");
			}
			
			System.out.println("|");
			printHorizontalLine(lineLenght);
		}
		
		System.out.println();
	}

	private void printHorizontalLine(int lineLenght) {
		System.out.print("  "); // left padding - two intervals
		
		for (int col = 0; col < lineLenght; col++) {
			System.out.print("-");
		}
		
		System.out.println();
	}

}

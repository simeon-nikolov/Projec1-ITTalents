import java.util.Locale;
import java.util.Scanner;

public class MorskiShah {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		char[][] matrix = new char[3][3];
		boolean winFirst = false;
		boolean winSecond = false;

		initializeMatrix(matrix);
		print(matrix);
		int choice = 0;
		int movesCount = 0;

		while (true) {
			// Ход на играч 1
			System.out.print("1: ");
			choice = sc.nextInt();
			
			while (!checkValidMove(matrix, choice)) {
				System.out.print("1: ");
				choice = sc.nextInt();
			}
			
			makeMove(matrix, choice, 'x');
			movesCount++;
			print(matrix);
			winFirst = checkForWin(matrix, 'x');
			
			if (winFirst || movesCount == 9) {
				break;
			}

			// Ход на играч 2
			System.out.print("2: ");
			choice = sc.nextInt();

			while (!checkValidMove(matrix, choice)) {
				System.out.print("2: ");
				choice = sc.nextInt();
			}

			makeMove(matrix, choice, 'o');
			movesCount++;
			print(matrix);
			winSecond = checkForWin(matrix, '0');
			
			if (winSecond || movesCount == 9) {
				break;
			}
		}
		
		printWinMessage(winFirst, winSecond); 
		
		sc.close();
	}

	private static void printWinMessage(boolean winFirst, boolean winSecond) {
		if (winFirst) {
			System.out.println("Печели играч 1!");
		} else {
			if (winSecond) {
				System.out.println("Печели играч 2!");
			} else {
				System.out.println("Равенство!");
			}
		}
	}

	private static void makeMove(char[][] matrix, int choice, char symbol) {
		int selectedRow = getRow(choice);
		int selectedCol = getCol(choice);
		matrix[selectedRow][selectedCol] = symbol;
	}

	private static boolean checkValidMove(char[][] matrix, int choice) {
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

	private static int getCol(int choice) {
		return (choice % 10) - 1;
	}

	private static int getRow(int choice) {
		return (choice / 10) - 1;
	}

	private static void initializeMatrix(char[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = ' ';
			}
		}
	}

	private static boolean checkForWin(char[][] matrix, char symbol) {
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

	private static void print(char[][] matrix) {
		int lineLenght = matrix[0].length * 4 + 1; // The length of the lines between the rows 
		
		printHorizontalLine(lineLenght);
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print("| " + matrix[row][col] + " ");
			}
			
			System.out.println("|");
			printHorizontalLine(lineLenght);
		}
		
		System.out.println();
	}

	private static void printHorizontalLine(int lineLenght) {
		for (int col = 0; col < lineLenght; col++) {
			System.out.print("-");
		}
		
		System.out.println();
	}

}

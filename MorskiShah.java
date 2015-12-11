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

		while (!winFirst || !winSecond) {
			// Ход на играч 1
			System.out.print("1: ");
			choice = sc.nextInt();
			
			while (!checkValidMove(matrix, choice)) {
				System.out.print("1: ");
				choice = sc.nextInt();
			}
			
			makeMove(matrix, choice, 'x');
			print(matrix);

			// Ход на играч2
			System.out.print("2: ");
			choice = sc.nextInt();

			while (!checkValidMove(matrix, choice)) {
				System.out.print("2: ");
				choice = sc.nextInt();
			}

			makeMove(matrix, choice, 'o');
			print(matrix);

			if (winFirst) {
				System.out.println("Печели играч 1");
			} else {
				if (winSecond) {
					System.out.println("Печели играч 2");
				}
			}
		}
	}

	private static void makeMove(char[][] matrix, int choice, char symbol) {
		int selectedRow = getRow(choice);
		int selectedCol = getCol(choice);
		matrix[selectedRow][selectedCol] = symbol;
	}

	private static boolean checkValidMove(char[][] matrix, int choice) {
		boolean valid = true;
		int row = getRow(choice);
		int col = getCol(choice);
		valid = (matrix[row][col] == ' ');

		return valid;
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
		boolean isWinner = false;
		
		return false;
	}

	static void print(char[][] matrix) {
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

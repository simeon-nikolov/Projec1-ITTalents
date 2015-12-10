import java.util.Scanner;

public class MorskiShah {

	public static void main(String[] args) {
		char[][] matrix = new char[7][7];
		boolean[][] populated = new boolean[3][3];
		boolean winFirst = ((matrix[2][2] == 'x' && matrix[2][4] == 'x' && matrix[2][6] == 'x')
				|| (matrix[4][2] == 'x' && matrix[4][4] == 'x' && matrix[4][6] == 'x')
				|| (matrix[6][2] == 'x' && matrix[6][4] == 'x' && matrix[6][6] == 'x')
				|| (matrix[2][2] == 'x' && matrix[4][2] == 'x' && matrix[6][2] == 'x')
				|| (matrix[2][4] == 'x' && matrix[4][4] == 'x' && matrix[6][4] == 'x')
				|| (matrix[2][6] == 'x' && matrix[4][6] == 'x' && matrix[6][6] == 'x')
				|| (matrix[2][2] == 'x' && matrix[4][4] == 'x' && matrix[6][6] == 'x')
				|| (matrix[2][6] == 'x' && matrix[4][4] == 'x' && matrix[6][2] == 'x'));
		boolean winSecond = ((matrix[2][2] == 'o' && matrix[2][4] == 'o' && matrix[2][6] == 'o')
				|| (matrix[4][2] == 'o' && matrix[4][4] == 'o' && matrix[4][6] == 'o')
				|| (matrix[6][2] == 'o' && matrix[6][4] == 'o' && matrix[6][6] == 'o')
				|| (matrix[2][2] == 'o' && matrix[4][2] == 'o' && matrix[6][2] == 'o')
				|| (matrix[2][4] == 'o' && matrix[4][4] == 'o' && matrix[6][4] == 'o')
				|| (matrix[2][6] == 'o' && matrix[4][6] == 'o' && matrix[6][6] == 'o')
				|| (matrix[2][2] == 'o' && matrix[4][4] == 'o' && matrix[6][6] == 'o')
				|| (matrix[2][6] == 'o' && matrix[4][4] == 'o' && matrix[6][2] == 'o'));

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = ' ';
			}
		}
		
		for (int row = 0; row < matrix.length; row += 2) {
			for (int col = 1; col < matrix[row].length; col += 2) {
				matrix[row][col] = '-';
			}
		}
		
		for (int row = 1; row < matrix.length; row += 2) {
			for (int col = 0; col < matrix[row].length; col += 2) {
				matrix[row][col] = '|';
			}
		}
		
		print(matrix, 22, ' ');
		System.out.print("1: ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		populated[choice / 10 - 1][choice % 10 - 1] = true;
		print(matrix, choice, 'x');
		
		// Ход 1 на играч 2
		System.out.print("2: ");
		choice = sc.nextInt();
		
		// Тук печатам за проверка условието
		System.out.println(
				(!((choice > 10 && choice < 14) || (choice > 20 && choice < 24) || (choice > 30 && choice < 34))));
		
		while ((populated[choice / 10 - 1][choice % 10 - 1])
				|| (!((choice > 10 && choice < 14) || (choice > 20 && choice < 24) || (choice > 30 && choice < 34)))) {
			System.out.print("2: ");
			choice = sc.nextInt();
		}
		
		print(matrix, choice, 'o');
		populated[choice / 10 - 1][choice % 10 - 1] = true;
		
		// Ход 2 на играч 1
		System.out.print("1: ");
		choice = sc.nextInt();
		while ((populated[choice / 10 - 1][choice % 10 - 1])
				|| (!((choice > 10 && choice < 14) || (choice > 20 && choice < 24) || (choice > 30 && choice < 34)))) {
			System.out.print("1: ");
			choice = sc.nextInt();
		}
		
		print(matrix, choice, 'x');
		populated[choice / 10 - 1][choice % 10 - 1] = true;
		
		// Ход 2 на играч2
		System.out.print("2: ");
		choice = sc.nextInt();
		
		while ((populated[choice / 10 - 1][choice % 10 - 1])
				|| (!((choice > 10 && choice < 14) || (choice > 20 && choice < 24) || (choice > 30 && choice < 34)))) {
			System.out.print("2: ");
			choice = sc.nextInt();
		}
		
		print(matrix, choice, 'o');
		populated[choice / 10 - 1][choice % 10 - 1] = true;
		
		// Ход 3 на играч 1
		System.out.print("1: ");
		choice = sc.nextInt();
		
		while ((populated[choice / 10 - 1][choice % 10 - 1])
				|| (!((choice > 10 && choice < 14) || (choice > 20 && choice < 24) || (choice > 30 && choice < 34)))) {
			System.out.print("1: ");
			choice = sc.nextInt();
		}
		
		print(matrix, choice, 'x');
		populated[choice / 10 - 1][choice % 10 - 1] = true;

		System.out.println(winFirst);
		System.out.println(matrix[2][2] == 'x');
		System.out.println(matrix[2][4] == 'x');
		System.out.println(matrix[2][6] == 'x');

		if (winFirst) {
			System.out.println("Печели играч 1");
		} else {
			// Ход 3 на играч 2
			System.out.print("2: ");
			choice = sc.nextInt();
			while ((populated[choice / 10 - 1][choice % 10 - 1]) || (!((choice > 10 && choice < 14)
					|| (choice > 20 && choice < 24) || (choice > 30 && choice < 34)))) {
				System.out.print("2: ");
				choice = sc.nextInt();
			}
			
			print(matrix, choice, 'o');
			populated[choice / 10 - 1][choice % 10 - 1] = true;
			
			if (winSecond) {
				System.out.println("Печели играч 2");
			} else {
				// Ход 4 на играч 1
				System.out.print("1: ");
				choice = sc.nextInt();
				
				while ((populated[choice / 10 - 1][choice % 10 - 1]) || (!((choice > 10 && choice < 14)
						|| (choice > 20 && choice < 24) || (choice > 30 && choice < 34)))) {
					System.out.print("1: ");
					choice = sc.nextInt();
				}
				
				print(matrix, choice, 'x');
				populated[choice / 10 - 1][choice % 10 - 1] = true;

				if (winFirst) {
					System.out.println("Печели играч 1");
				} else {
					// Ход 4 на играч 2
					System.out.print("2: ");
					choice = sc.nextInt();
					
					while ((populated[choice / 10 - 1][choice % 10 - 1]) || (!((choice > 10 && choice < 14)
							|| (choice > 20 && choice < 24) || (choice > 30 && choice < 34)))) {
						System.out.print("2: ");
						choice = sc.nextInt();
					}
					
					print(matrix, choice, 'o');
					populated[choice / 10 - 1][choice % 10 - 1] = true;
					
					if (winSecond) {
						System.out.println("Печели играч 2");
					} else {
						// Ход 5 на играч 1
						System.out.print("1: ");
						choice = sc.nextInt();
						
						while ((populated[choice / 10 - 1][choice % 10 - 1]) || (!((choice > 10 && choice < 14)
								|| (choice > 20 && choice < 24) || (choice > 30 && choice < 34)))) {
							System.out.print("1: ");
							choice = sc.nextInt();
						}
						
						print(matrix, choice, 'x');
						populated[choice / 10 - 1][choice % 10 - 1] = true;

						if (winFirst) {
							System.out.println("Печели играч 1");
						} else {
							System.out.println("Равен резултат");
						}
					}
				}
			}
		}
	}

	static void print(char[][] matrix, int input, char symbol) {
		int coordX = input / 10 * 2 - 1;
		int coordY = input % 10 * 2 - 1;
		matrix[coordX][coordY] = symbol;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			
			System.out.println();
		}
	}

}

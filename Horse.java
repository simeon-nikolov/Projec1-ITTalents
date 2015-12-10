import java.util.Scanner;

public class Horse {

	public static void main(String[] args) {
		System.out.println("Enter number of rows: ");
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		System.out.println("Enter number of columns: ");
		int col = sc.nextInt();
		char[][] real = new char[row][col];
		 for(int rowInit = 0; rowInit < real.length; rowInit++){
		 for (int colInit = 0; colInit< real[rowInit].length; colInit++){
		 real[rowInit][colInit] = ' ';
		 }
		 }
		System.out.println("Enter staring coordinares. Enter row number:");
		int startRow = sc.nextInt();
		while (startRow > row || startRow < 1) {
			System.out.println("Enter valid row number:");
			startRow = sc.nextInt();
		}
		System.out.println("Enter column number:");
		int startCol = sc.nextInt();
		while (startCol > col || startCol < 1) {
			System.out.println("Enter valid column number:");
			startCol = sc.nextInt();
		}
		startRow--;
		startCol--;
		dots(real, startRow, startCol);
		print(real);

	}

	static void dots(char[][] x, int y, int z) {
		if (x[y][z] == '.') {
			return;
		}
		if (y < 0 || y >= x.length) {
			return;
		}
		if (z < 0 || z >= x[y].length) {
			return;
		}
		x[y][z] = '.';
		if (y - 2 >= 0) {
			if (z - 1 >= 0) {
				dots(x, y - 2, z - 1);
			}
			if (z + 1 < x[y].length) {
				dots(x, y - 2, z + 1);
			}
		}
		if (y - 1 >= 0) {
			if (z - 2 >= 0) {
				dots(x, y - 1, z - 2);
			}
			if (z + 2 < x[y].length) {
				dots(x, y - 1, z + 2);
			}
		}
		if (y + 2 < x.length) {
			if (z - 1 >= 0) {
				dots(x, y + 2, z - 1);
			}
			if (z + 1 < x[y].length) {
				dots(x, y + 2, z + 1);
			}
		}
		if (y + 1 < x.length) {
			if (z - 2 >= 0) {
				dots(x, y + 1, z - 2);
			}
			if (z + 2 < x[y].length) {
				dots(x, y + 1, z + 2);
			}
		}

	}

	static void print(char[][] x) {
		for (int row = 0; row < x.length; row++) {
			for (int col = 0; col < x[row].length; col++) {
				System.out.print(x[row][col] + " ");
			}
			System.out.println();
		}
	}
static void printBorders(char[][] x){
	char[][] y = new char[x.length*2+1][x[0].length*2+1];
	for (int row = 0; row < x.length; row+=2) {
		for (int col = 1; col < x[row].length; col++) {
			y[row][col] = '-';
		}}
	for (int row = 1; row < x.length; row+=2) {
		for (int col = 0; col < x[row].length; col++) {
			y[row][col] = '|';
		}}
	for (int row = 1; row < y.length; row+=2) {
		for (int col = 1; col < y[row].length; col+=2) {
			y[row][col] = x[row/2][col/2];
			}}
	print(y);
}
}

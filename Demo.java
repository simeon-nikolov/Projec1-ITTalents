import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		do {
			printMenu();
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				playTicTacToe();
				break;
			case 2:
				System.out.println("Enter message to encrypt: ");
				String text = sc.next();
				System.out.println(encryptText(text));
				System.out.println();
				break;
			case 3:
				System.out.println("Enter message to decrypt: ");
				String encryptedText = sc.next();
				System.out.println(decryptText(encryptedText));
				System.out.println();
				break;
			case 4:
				findKnightPath();
				System.out.println();
				break;
			}
		} while (choice != 5);
		
		sc.close();
	}

	public static void printMenu() {
		System.out.println("Choose an option from the menu:\n");
		System.out.println("1 - Play TicTacToe");
		System.out.println("2 - Encrypt a message");
		System.out.println("3 - Decrypt a message");
		System.out.println("4 - Find the path of a chess Knight on a custom board");
		System.out.println("5 - Exit");
		System.out.println();
	}

	public static void playTicTacToe() {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.run();
	}

	public static String encryptText(String text) {
		TextCrypter crypter = new TextCrypter();
		String encryptedText = crypter.encrypt(text);
		return encryptedText;
	}

	public static String decryptText(String text) {
		TextCrypter crypter = new TextCrypter();
		String decryptedText = crypter.decrypt(text);
		return decryptedText;
	}

	public static void findKnightPath() {
		Horse knightPathFinder = new Horse();
		knightPathFinder.findPath();
	}

}

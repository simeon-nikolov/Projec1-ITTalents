
public class TextCrypter {
	private static final char EXTRA_SYMBOL = 'Q'; // additional letter to add in the end if the text length is odd
	private static final char[][] ENCRYPTING_MATRIX = {
		{'B', 'M', 'S', 'J', 'C'},
		{'I', 'F', 'N', 'T', 'E'},
		{'R', 'L', 'A', 'H', 'K'},
		{'D', 'O', 'G', 'Q', 'V'},
		{'U', 'W', 'X', 'Y', 'P'},
	};
	
	public String encrypt(String text) {
		if (text.length() % 2 == 1) {
			text = text + EXTRA_SYMBOL;
		}
		
		text = text.toUpperCase();
		String encryptedText = "";
		
		for (int index = 0; index < text.length(); index += 2) {
			int[] coords1 = this.getCoords(text.charAt(index));
			int[] coords2 = this.getCoords(text.charAt(index + 1));
			
			// 1. if they are on different rows and cols
			if ((coords1[0] != coords2[0]) && (coords1[1] != coords2[1])) {
				int firstLetterRow = coords1[0];
				int firstLetterCol = coords2[1];
				int secondLetterRow = coords2[0];
				int secondLetterCol = coords1[1];
				encryptedText = encryptedText + 
						ENCRYPTING_MATRIX[firstLetterRow][firstLetterCol] + 
						ENCRYPTING_MATRIX[secondLetterRow][secondLetterCol];
			}
			
			// 2. if they are on same row
			if ((coords1[0] == coords2[0]) && (coords1[1] != coords2[1])) {
				int firstLetterRow = coords1[0];
				int firstLetterCol = coords1[1] + 1;
				int secondLetterRow = coords1[0];
				int secondLetterCol = coords2[1] + 1;
				
				if (firstLetterCol >= ENCRYPTING_MATRIX[0].length) {
					firstLetterCol = 0;
				}
				
				if (secondLetterCol >= ENCRYPTING_MATRIX[0].length) {
					secondLetterCol = 0;
				}
				
				encryptedText = encryptedText + 
						ENCRYPTING_MATRIX[firstLetterRow][firstLetterCol] + 
						ENCRYPTING_MATRIX[secondLetterRow][secondLetterCol];
			}
			
			// 3. if they are on same col
			if ((coords1[0] != coords2[0]) && (coords1[1] == coords2[1])) {
				int firstLetterRow = coords1[0] + 1;
				int firstLetterCol = coords1[1];
				int secondLetterRow = coords2[0] + 1;
				int secondLetterCol = coords2[1];
				
				if (firstLetterRow >= ENCRYPTING_MATRIX.length) {
					firstLetterRow = 0;
				}
				
				if (secondLetterRow >= ENCRYPTING_MATRIX.length) {
					secondLetterRow = 0;
				}
				
				encryptedText = encryptedText + 
						ENCRYPTING_MATRIX[firstLetterRow][firstLetterCol] + 
						ENCRYPTING_MATRIX[secondLetterRow][secondLetterCol];
			}
		}
		
		return encryptedText;
	}
	
	public String decrypt(String encryptedText) {
		encryptedText = encryptedText.toUpperCase();
		String decryptedText = "";
		
		for (int index = 0; index < encryptedText.length(); index += 2) {
			int[] coords1 = this.getCoords(encryptedText.charAt(index));
			int[] coords2 = this.getCoords(encryptedText.charAt(index + 1));
			
			// 1. if they are on different rows and cols
			if ((coords1[0] != coords2[0]) && (coords1[1] != coords2[1])) {
				int firstLetterRow = coords1[0];
				int firstLetterCol = coords2[1];
				int secondLetterRow = coords2[0];
				int secondLetterCol = coords1[1];
				decryptedText = decryptedText + 
						ENCRYPTING_MATRIX[firstLetterRow][firstLetterCol] + 
						ENCRYPTING_MATRIX[secondLetterRow][secondLetterCol];
			}
			
			// 2. if they are on same row
			if ((coords1[0] == coords2[0]) && (coords1[1] != coords2[1])) {
				int firstLetterRow = coords1[0];
				int firstLetterCol = coords1[1] - 1;
				int secondLetterRow = coords1[0];
				int secondLetterCol = coords2[1] - 1;
				
				if (firstLetterRow < 0) {
					firstLetterRow = ENCRYPTING_MATRIX.length - 1;
				}
				
				if (secondLetterRow < 0) {
					secondLetterRow = ENCRYPTING_MATRIX.length - 1;
				}
				
				decryptedText = decryptedText + 
						ENCRYPTING_MATRIX[firstLetterRow][firstLetterCol] + 
						ENCRYPTING_MATRIX[secondLetterRow][secondLetterCol];
			}
			
			// 3. if they are on same col
			if ((coords1[0] != coords2[0]) && (coords1[1] == coords2[1])) {
				int firstLetterRow = coords1[0] - 1;
				int firstLetterCol = coords1[1];
				int secondLetterRow = coords2[0] - 1;
				int secondLetterCol = coords2[1];
				
				if (firstLetterRow < 0) {
					firstLetterRow = ENCRYPTING_MATRIX.length - 1;
				}
				
				if (secondLetterRow < 0) {
					secondLetterRow = ENCRYPTING_MATRIX.length - 1;
				}
				
				decryptedText = decryptedText + 
						ENCRYPTING_MATRIX[firstLetterRow][firstLetterCol] + 
						ENCRYPTING_MATRIX[secondLetterRow][secondLetterCol];
			}
		}
		
		if (decryptedText.charAt(decryptedText.length() - 1) == 'Q') {
			decryptedText = decryptedText.substring(0, decryptedText.length() - 1);
		}
		
		return decryptedText.toLowerCase();
	}
	
	private int[] getCoords(char symbol) {
		int[] coords = new int[2];
		
		for (int row = 0; row < ENCRYPTING_MATRIX.length; row++) {
			for (int col = 0; col < ENCRYPTING_MATRIX.length; col++) {
				if (ENCRYPTING_MATRIX[row][col] == symbol) {
					coords[0] = row;
					coords[1] = col;
					break;
				}
			}
		}
		
		return coords;
	}
	
}

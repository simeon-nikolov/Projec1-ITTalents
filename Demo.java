
public class Demo {

	public static void main(String[] args) {
		TextCrypter crypter = new TextCrypter();
		String textToEncrypt = "atextmext";
		String encryptedText = crypter.encrypt(textToEncrypt);
		System.out.println(textToEncrypt);
		System.out.println(encryptedText);

	}

}

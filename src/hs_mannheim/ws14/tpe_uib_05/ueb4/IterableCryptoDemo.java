package hs_mannheim.ws14.tpe_uib_05.ueb4;

public class IterableCryptoDemo {
	public static void main(String[] args) throws IllegalKeyException {

		Crypter caesar = CrypterFactory.createCrypter("U", CAESAR);

		Crypter xor = CrypterFactory.createCrypter("TPEISTCOOL", XOR);

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");

		IterableCrypter iterableCrypter = new IterableCrypter(
				new IterableCrypter(liste, caesar), xor);

		for (String cypherText : iterableCrypter) {
			System.out.println(cypherText);
		}
	}
}

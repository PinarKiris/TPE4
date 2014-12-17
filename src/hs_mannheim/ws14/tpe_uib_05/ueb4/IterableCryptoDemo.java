package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterableCryptoDemo {
	public static void main(String[] args) throws CrypterException {

		Crypter caesar = CrypterFactory.createCrypter("U", Enumeration.CAESAR);
		Crypter xor = CrypterFactory.createCrypter("TPEISTCOOL",
				Enumeration.XOR);

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");

		IterableCrypter iterableCrypter = new IterableCrypter(
				new IterableCrypter(liste, caesar), xor);

		for (String cypherText : iterableCrypter) {
			System.out.println(cypherText);
		}
		System.out.println("------------------------------------------------");

		List<String> liste2 = Arrays.asList("MT_G", "P^J", "NTL", "[JKF");

		IterableDecrypter iterableDecrypter = new IterableDecrypter(
				new IterableDecrypter(liste2, xor), caesar);

		for (String message : iterableDecrypter) {
			System.out.println(message);
		}
	}
}

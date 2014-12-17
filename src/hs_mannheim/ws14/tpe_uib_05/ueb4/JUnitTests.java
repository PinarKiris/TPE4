package hs_mannheim.ws14.tpe_uib_05.ueb4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class JUnitTests {

	@Test
	public void CrypterCaesartest() throws CrypterException {

		Crypter caesar = new CrypterFactory().createCrypter("C",
				Enumeration.CAESAR);
		assertEquals("DEFGHIJKLMNOPQRSTUVWXYZABC",
				caesar.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				caesar.decrypt("DEFGHIJKLMNOPQRSTUVWXYZABC"));
		assertEquals("FDHVDU", caesar.encrypt("Caesar"));
		assertEquals("CAESAR", caesar.decrypt("FDHVDU"));

		List<String> list = Arrays.asList("ZIEL", "MESSER", "CAESAR");
		List<String> list1 = Arrays.asList("CLHO", "PHVVHU", "FDHVDU");
		assertEquals(list1, caesar.encrypt(list));
		assertEquals(list, caesar.decrypt(list1));

	}

	@Test(expected = CrypterException.class)
	public void testCaesarAusnahme() throws CrypterException {

		Crypter caesar = new CrypterFactory().createCrypter("E",
				Enumeration.CAESAR);
		String falscherString = "jkhk34234s";
		caesar.decrypt(falscherString);

	}

	@Test
	public void CrypterXORTest() throws CrypterException {

		Crypter xor = new CrypterFactory().createCrypter("TPERULES",
				Enumeration.XOR);
		assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ",
				xor.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				xor.decrypt("URFVPJB[]ZN^XBJCEBVF@ZRKMJ"));
		assertEquals("L_W", xor.encrypt("XOR"));
		assertEquals("XOR", xor.decrypt("L_W"));

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("PY@A", "]CQ", "QYK", "@UVF");
		assertEquals(liste1, xor.encrypt(liste));
		assertEquals(liste, xor.decrypt(liste1));

	}

	@Test(expected = CrypterException.class)
	public void testXORAusnahme1() throws CrypterException {

		Crypter xor = new CrypterFactory().createCrypter("TPERULES",
				Enumeration.XOR);
		String falscherString = "jkhk34234s";
		xor.decrypt(falscherString);

	}

	@Test
	public void CrypterSubstitutionTest() throws CrypterException {

		Crypter subs = new CrypterFactory().createCrypter(
				"UFLPWDRASJMCONQYBVTEXHZKGI", Enumeration.SUBSTITUTION);
		assertEquals("ZSMSYWPSUSTESNDQVOUESH",
				subs.encrypt("WIKIPEDIAISTINFORMATIV"));
		assertEquals("WIKIPEDIAISTINFORMATIV",
				subs.decrypt("ZSMSYWPSUSTESNDQVOUESH"));

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("PSWT", "STE", "WSN", "EWTE");
		assertEquals(liste1, subs.encrypt(liste));
		assertEquals(liste, subs.decrypt(liste1));
	}

	@Test
	public void CrypterNullTest() throws CrypterException {

		Crypter nullCrypter = new CrypterFactory().createCrypter("TPERULES",
				Enumeration.NULL);
		assertEquals("HALLO", nullCrypter.encrypt("HALLO"));
		assertEquals("HALLO", nullCrypter.decrypt("HALLO"));

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("DIES", "IST", "EIN", "TEST");
		assertEquals(liste1, nullCrypter.encrypt(liste));
		assertEquals(liste, nullCrypter.decrypt(liste1));
	}

	@Test
	public void CrypterReverseTest() throws CrypterException {

		Crypter reverse = new CrypterFactory().createCrypter("TPERULES",
				Enumeration.REVERSE);
		assertEquals("ZELUREPT", reverse.encrypt("TPERULEZ"));
		assertEquals("TPERULEZ", reverse.decrypt("ZELUREPT"));

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("SEID", "TSI", "NIE", "TSET");
		assertEquals(liste1, reverse.encrypt(liste));
		assertEquals(liste, reverse.decrypt(liste1));
	}

	@Test(expected = IllegalKeyException.class)
	public void testIllegalKeyException1() throws CrypterException {
		String key = "HALLO";
		Crypter caesar = new CrypterFactory().createCrypter(key,
				Enumeration.CAESAR);
		caesar.encrypt("TEST");

	}

	String test = "TEST";
	List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");

	@Test
	public void testCaesar() throws CrypterException {

		Crypter caesar = CrypterFactory.createCrypter("E", Enumeration.CAESAR);

		assertEquals("YJXY", caesar.encrypt(test));
		assertEquals("[INJX, NXY, JNS, YJXY]", caesar.encrypt(liste).toString());
		List<String> neueListe = caesar.encrypt(liste);
		assertEquals("TEST", caesar.decrypt("YJXY"));
		assertEquals("[DIES, IST, EIN, TEST]", caesar.decrypt(neueListe)
				.toString());
	}

	@Test(expected = CrypterException.class)
	public void testCaesarAusnahme1() throws CrypterException {

		Crypter caesar = CrypterFactory.createCrypter("E", Enumeration.CAESAR);
		String falscherString = "jkhk34234s";
		caesar.decrypt(falscherString);
	}

	@Test
	public void testNull() throws CrypterException {

		Crypter nichts = CrypterFactory.createCrypter("", Enumeration.NULL);

		assertEquals("TEST", nichts.encrypt(test));
		assertEquals("TEST", nichts.decrypt(test));
		assertEquals("[DIES, IST, EIN, TEST]", nichts.decrypt(liste).toString());
		assertEquals("[DIES, IST, EIN, TEST]", nichts.encrypt(liste).toString());

	}

	@Test
	public void testReverse() throws CrypterException {

		Crypter reverse = CrypterFactory.createCrypter("", Enumeration.REVERSE);

		assertEquals("TSET", reverse.encrypt(test));
		assertEquals("[SEID, TSI, NIE, TSET]", reverse.encrypt(liste)
				.toString());
		List<String> neueListe = reverse.encrypt(liste);
		assertEquals("TEST", reverse.decrypt("TSET"));
		assertEquals("[DIES, IST, EIN, TEST]", reverse.decrypt(neueListe)
				.toString());

	}

	@Test
	public void testSubstitution() throws CrypterException {

		Crypter sub = CrypterFactory.createCrypter(
				"UFLPWDRASJMCONQYBVTEXHZKGI", Enumeration.SUBSTITUTION);

		String wiki = "WIKIPEDIAISTINFORMATIV";
		List<String> liste = Arrays.asList("WIKIPEDIA", "IST", "INFORMATIV");

		assertEquals("ZSMSYWPSUSTESNDQVOUESH", sub.encrypt(wiki));
		assertEquals("WIKIPEDIAISTINFORMATIV",
				sub.decrypt("ZSMSYWPSUSTESNDQVOUESH"));
		assertEquals("[ZSMSYWPSU, STE, SNDQVOUESH]", sub.encrypt(liste)
				.toString());

		List<String> neueListe = Arrays
				.asList("ZSMSYWPSU", "STE", "SNDQVOUESH");
		assertEquals(liste, sub.decrypt(neueListe));
	}

	@Test
	public void testXOR() throws CrypterException {

		Crypter xor = CrypterFactory.createCrypter("TPERULES", Enumeration.XOR);

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ergebnis = "URFVPJB[]ZN^XBJCEBVF@ZRKMJ";

		assertEquals(ergebnis, xor.encrypt(alphabet));
		assertEquals(alphabet, xor.decrypt(ergebnis));

		assertEquals("[PY@A, ]CQ, QYK, @UVF]", xor.encrypt(liste).toString());
		List<String> neueListe = xor.encrypt(liste);
		assertEquals("[DIES, IST, EIN, TEST]", xor.decrypt(neueListe)
				.toString());
	}

	@Test(expected = CrypterException.class)
	public void testXORAusnahme() throws CrypterException {

		Crypter xor = CrypterFactory.createCrypter("TPERULES", Enumeration.XOR);
		String falscherString = "jkhk34234s";
		xor.decrypt(falscherString);
	}

	@Test
	public void testFactory() throws CrypterException {

		Crypter caesar = CrypterFactory.createCrypter("E", Enumeration.CAESAR);
		Crypter caesar2 = CrypterFactory.createCrypter("U", Enumeration.CAESAR);
		Crypter xor = CrypterFactory.createCrypter("TPERULES", Enumeration.XOR);

		assertEquals(caesar2.getClass(), caesar.getClass());

	}

	@Test(expected = IllegalKeyException.class)
	public void testIllegalKeyException() throws CrypterException {

		String key = "HALLO";
		Crypter caesar = CrypterFactory.createCrypter(key, Enumeration.CAESAR);
		caesar.encrypt("TEST");
	}

	@Test
	public void testIterale() throws CrypterException {

		Crypter caesar = CrypterFactory.createCrypter("U", Enumeration.CAESAR);
		Crypter xor = CrypterFactory.createCrypter("TPEISTCOOL",
				Enumeration.XOR);

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		IterableCrypter iterableCrypter = new IterableCrypter(
				new IterableCrypter(liste, caesar), xor);

		StringBuffer result = new StringBuffer();
		for (String cypherText : iterableCrypter) {
			result.append(cypherText);
		}

		assertEquals("MT_GP^JNTL[JKF", result.toString());

		List<String> liste2 = Arrays.asList("MT_G", "P^J", "NTL", "[JKF");
		IterableDecrypter iterableDecrypt = new IterableDecrypter(
				new IterableDecrypter(liste2, xor), caesar);

		StringBuffer result2 = new StringBuffer();
		for (String text : iterableDecrypt) {
			result2.append(text);
		}

		assertEquals("DIESISTEINTEST", result2.toString());
	}

}

package hs_mannheim.ws14.tpe_uib_05.ueb4;

import static org.junit.Assert.assertEquals;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class JUnitTests {
	
	@Test
	public void CrypterCaesartest() throws CrypterException {
		
		Crypter caesar = new CrypterFactory().createCrypter(
				"C", Enumeration.CAESAR);
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
	
	
	@Test (expected = CrypterException.class)
	public void testCaesarAusnahme() throws CrypterException {
		
	Crypter caesar =  new CrypterFactory().createCrypter("E", Enumeration.CAESAR);
	String falscherString = "jkhk34234s";
	caesar.decrypt(falscherString);
	
	}
		
	
	@Test
	public void CrypterXORTest() throws CrypterException{
		
	Crypter xor = new CrypterFactory().createCrypter("TPERULES", Enumeration.XOR);
	assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ", xor.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", xor.decrypt("URFVPJB[]ZN^XBJCEBVF@ZRKMJ"));
	assertEquals("L_W", xor.encrypt("XOR"));
	assertEquals("XOR", xor.decrypt("L_W"));
	
	List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
	List<String> liste1 = Arrays.asList("PY@A", "]CQ", "QYK", "@UVF");
	assertEquals(liste1, xor.encrypt(liste));
	assertEquals(liste,xor.decrypt(liste1));

	}
	
	@Test (expected = CrypterException.class)
	public void testXORAusnahme() throws CrypterException {
		
	Crypter xor = new CrypterFactory().createCrypter("TPERULES", Enumeration.XOR);
	String falscherString = "jkhk34234s";
	xor.decrypt(falscherString);
	
	}
	
	@Test
	public void CrypterSubstitutionTest() throws CrypterException {
		
		Crypter subs = new CrypterFactory().createCrypter("UFLPWDRASJMCONQYBVTEXHZKGI", Enumeration.SUBSTITUTION);
		assertEquals("ZSMSYWPSUSTESNDQVOUESH", subs.encrypt("WIKIPEDIAISTINFORMATIV"));
		assertEquals("WIKIPEDIAISTINFORMATIV", subs.decrypt("ZSMSYWPSUSTESNDQVOUESH"));
		
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("PSWT", "STE", "WSN", "EWTE");
		assertEquals(liste1, subs.encrypt(liste));
		assertEquals(liste, subs.decrypt(liste1));
	}
	
	@Test
	public void CrypterNullTest() throws CrypterException {
		
		Crypter nullCrypter = new CrypterFactory().createCrypter("TPERULES", Enumeration.NULL);
		assertEquals("HALLO", nullCrypter.encrypt("HALLO"));
		assertEquals("HALLO", nullCrypter.decrypt("HALLO"));
		
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("DIES", "IST", "EIN", "TEST");
		assertEquals(liste1, nullCrypter.encrypt(liste));
		assertEquals(liste, nullCrypter.decrypt(liste1));
	}
	
	@Test
	public void CrypterReverseTest() throws CrypterException {
		
		Crypter reverse = new CrypterFactory().createCrypter("TPERULES", Enumeration.REVERSE);
		assertEquals("ZELUREPT", reverse.encrypt("TPERULEZ"));
		assertEquals("TPERULEZ", reverse.decrypt("ZELUREPT"));
		
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("SEID", "TSI", "NIE", "TSET");
		assertEquals(liste1, reverse.encrypt(liste));
		assertEquals(liste, reverse.decrypt(liste1));
	}
	
	@Test(expected = IllegalKeyException.class)
	public void testIllegalKeyException() throws CrypterException {
	String key = "HALLO";
	Crypter caesar = new CrypterFactory().createCrypter(key, Enumeration.CAESAR);
	caesar.encrypt("TEST");
	
	}

}

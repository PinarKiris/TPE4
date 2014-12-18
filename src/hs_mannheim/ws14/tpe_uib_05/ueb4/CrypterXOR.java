package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.LinkedList;
import java.util.List;

/**
 * Diese Klasse dient dazu, einen Text nach dem XOR-Verfahren zu verschluesseln.
 * 
 * @author Dennis Keßler 1326697
 * @author Pınar Kırış 1332722
 * 
 */

public class CrypterXOR implements Crypter {

	private String key;

	/**
	 * Konstruktor um ein Caesar Verschluesselungsobjekt mit einem
	 * dazugehoerigen Schluessel zu erzeugen.
	 * 
	 * @param key
	 *            Schluessel
	 */

	public CrypterXOR(String key) {
		this.key = key;
	}

	/*
	 * StringBuffer Methoden bietet, um die Zeichenketten zu manipulieren, wie
	 * z.B. append(), insert(), delete(), setCharAt(), trimToSize() …. Während
	 * beim Aufruf der oben vorgestellten Methoden in der Klasse String immer
	 * neue String-Objekte erzeugt werden, werden in der Klasse StringBuffer die
	 * Veränderungen an demselben Objekt durchgeführt. StringBuffer muss
	 * explizit mit dem new-Operator erzeugt werden.
	 */

	@Override
	public String encrypt(String message) throws CrypterException {
		message = message.toUpperCase();
		StringBuffer ergebnis = new StringBuffer();
		for (int i = 0; i < message.length(); i++) {
			ergebnis.append(add(message.charAt(i),
					key.charAt((i) % key.length())));
		}
		return ergebnis.toString();

	}

	/**
	 * Diese Methode dient dazu ein Zeichen in einer Binaerzahl umzuwandeln und
	 * sie mit einer anderen Binaerzahl nach dem XOR-Verfahren zu vergleichen.
	 * 
	 * @param message
	 *            Buchstabe des zu verschluesselnden Textes
	 * 
	 * @param key
	 *            Buchstabe des Schluessels
	 * 
	 * @return veschluesseltes Zeichen
	 */

	private char add(char message, char key) {
		int y = charToValue(message);
		int z = charToValue(key);

		String yBin = Integer.toBinaryString(y);
		String zBin = Integer.toBinaryString(z);
		while (yBin.length() < 5) {
			yBin = "0" + yBin;
		}
		while (zBin.length() < 5) {
			zBin = "0" + zBin;
		}
		StringBuffer ergebnis = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			if (yBin.charAt(i) == zBin.charAt(i)) {
				ergebnis.append("0");
			} else {
				ergebnis.append("1");
			}
		}
		
		int dez = Integer.parseInt(ergebnis.toString(), 2);
		char[] zeichen = { '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
				'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_' };
		return zeichen[dez];
	}

	/**
	 * Diese Methode wandelt ein Zeichen in eine passende Dezimalzahl um.
	 * 
	 * @param a
	 *            das Zeichen
	 * @return Dezimalzahl
	 */
	
	private int charToValue(char a) {
		String alpha = ("@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_");
		for (int i = 0; i < alpha.length(); i++) {
			if (a == alpha.charAt(i)) {
				return (i);
			}
		}
		return 0;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String text : messages) {
			ergebnis.add(encrypt(text));
		}
		return ergebnis;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		for (int i = 0; i < cypherText.length(); i++) {
			if (cypherText.charAt(i) < '@' || cypherText.charAt(i) > '_') {
				throw new CrypterException("Entschluesselung nicht moeglich");
			}
		}
		return encrypt(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String text : cypherTexte) {
			ergebnis.add(decrypt(text));
		}
		return ergebnis;
	}

}

package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

/**
 * Diese Klasse dient dazu, einen Text nach dem Caesar-Verfahren zu
 * verschluesseln.
 * 
 * @author Dennis Keßler 1326697
 * @author Pınar Kırış 1332722
 *
 */

public class CrypterCaesar implements Crypter {

	private String key;

	/**
	 * Konstruktor um ein Caesar Verschluesselungsobjekt mit einem
	 * dazugehoerigen Schluessel zu erzeugen.
	 * 
	 * @param key
	 *            Schluessel
	 */

	public CrypterCaesar(String key) {
		this.key = key;
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		int shift = ((int) this.key.charAt(0)) - 64;
		return encrypt(encode(message, shift));

	}

	/**
	 * Diese Methode dient zur Verschluesselung eines Textes mit einer
	 * festgelegten Verschiebung.
	 * 
	 * @param message
	 *            zu verschluesselnde Nachricht
	 * @param shift
	 *            Verschiebung
	 * @return verschluesselter Text
	 * 
	 */

	private String encode(String message, int shift) {
		message = message.toUpperCase();
		String ergebnis = "";
		for (int i = 0; i < message.length() - 1; i++) {

			ergebnis += (char) ((message.charAt(i) - 'A' + shift) % 26 + 'A');
		}
		return ergebnis;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : messages) {
			ergebnis.add(encrypt(message));
		}

		return ergebnis;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		int shift = (int) this.key.charAt(0) - 64;

		return decrypt(cypherText, -shift);
	}

	/**
	 * Diese Methode dient zur Entschluesselung eines Textes mit einer
	 * festgelegten Verschiebung.
	 * 
	 * @param cypherText
	 *            zu entschluesselnde Nachricht
	 * @param shift
	 *            Verschiebung
	 * @return entschluesselter Text
	 */

	private String decrypt(String cypherText, int shift) {
		cypherText = cypherText.toUpperCase();
		String ergebnis = "";
		for (int i = 0; i < cypherText.length(); i++) {

			char zeichen = (char) ((cypherText.charAt(0) - 'A' + shift) % 26 + 'A');
			if (zeichen < 65) {
				ergebnis += (char) (zeichen + 26);
			} else {
				ergebnis += (char) zeichen;

			}
		}

		return ergebnis;
	}

	@Override
	public List<String> decrypt(List<String> cypherText)
			throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String text : cypherText) {
			ergebnis.add(encrypt(text));
		}
		return ergebnis;
	}

}

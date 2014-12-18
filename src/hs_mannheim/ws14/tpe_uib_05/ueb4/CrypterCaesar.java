package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.LinkedList;
import java.util.List;

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

	public CrypterCaesar(String key) {
		this.key = key;

	}

	@Override
	public String encrypt(String message) throws CrypterException {
		int shift = (int) this.key.charAt(0) - 64;
		return encrypt(message, shift);
	}

	private String encrypt(String message, int shift) {
		message = message.toUpperCase();
		String ergebnis = "";

		for (int i = 0; i < message.length(); i++) {
			ergebnis = ergebnis
					+ (char) ((message.charAt(i) - 65 + shift) % 26 + 65);
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
	public String decrypt(String crypterText) throws CrypterException {
		int shift = ((int) this.key.charAt(0)) - 64;
		return decrypt(crypterText, -shift);
	}

	private String decrypt(String message, int shift) {
		String ergebnis = "";
		for (int i = 0; i < message.length(); i++) {

			char zeichen = (char) ((message.charAt(i) - 65 + shift) % 26 + 65);
			if (zeichen < 65) {
				ergebnis = ergebnis + (char) (zeichen + 26);
			} else {
				ergebnis = ergebnis + (char) zeichen;
			}
		}
		return ergebnis;

	}

	@Override
	public List<String> decrypt(List<String> crypterTexte)
			throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String text : crypterTexte) {
			ergebnis.add(decrypt(text));
		}
		return ergebnis;
	}

}

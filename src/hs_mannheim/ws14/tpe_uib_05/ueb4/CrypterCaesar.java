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

	/*
	 * Methode, die für eine uebergebene Nachricht die Verschiebungszahl
	 * erzeugt, die Nachricht und die Verschiebungsziffer werden dabei an eine
	 * private interne encrypt Methode weitergeleitet.
	 */

	@Override
	public String encrypt(String message) throws CrypterException {
		int shift = (int) this.key.charAt(0) - 64;
		return encrypt(message, shift);
	}

	/*
	 * Private, interne Methode zur Verschluesselung eines Textes mit Hilfe der
	 * Caesar Verschluesselung und einer zuvor festgelegten Verschiebungsziffer.
	 */

	private String encrypt(String message, int shift) {
		message = message.toUpperCase();
		String ergebnis = "";

		for (int i = 0; i < message.length(); i++) {
			ergebnis = ergebnis
					+ (char) ((message.charAt(i) - 65 + shift) % 26 + 65);
		}
		return ergebnis;
	}

	/*
	 * Encrypt Methode zu Verschluesselung einer verketteten Liste, dabei wird
	 * ueber die Liste iteriert und der verschluesselte Text in einer neuen
	 * Liste gespeichert.
	 */

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : messages) {
			ergebnis.add(encrypt(message));
		}
		return ergebnis;
	}

	/*
	 * Methode zur Entschluesselung einer verschluesselten Nachricht, wobei die
	 * Verschiebung der Verschluesselung entspricht, allerdings mit negativem
	 * Vorzeichen.
	 */

	@Override
	public String decrypt(String crypterText) throws CrypterException {
		int shift = ((int) this.key.charAt(0)) - 64;
		return decrypt(crypterText, -shift);
	}

	/*
	 * Private, interne Methode zur Entschluesslung eines Textes mit gegebenem
	 * Verschiebungswert
	 */

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

	/*
	 * Decrypt Methode zu Entschluesselung einer verketteten Liste, dabei wird
	 * ueber die Liste iteriert und der entschluesselte Text in einer neuen
	 * Liste gespeichert.
	 */

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

package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.LinkedList;
import java.util.List;

/**
 * Diese Klasse dient dazu, einen Text nach dem Reverse-Verfahren zu
 * verschluesseln.
 * 
 * @author Dennis Keßler 1326697
 * @author Pınar Kırış 1332722
 *
 */

public class CrypterReverse implements Crypter {

	@Override
	public String encrypt(String message) throws CrypterException {
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(0) < 'A' || message.charAt(0) > 'Z') {
				throw new CrypterException("Verschluesselung nicht moeglich");

			}
		}
		String ergebnis = "";
		for (int i = message.length() - 1; i > (-1); i--) {
			ergebnis += message.charAt(i);
		}
		return ergebnis;
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
			if (cypherText.charAt(i) < 'A' || cypherText.charAt(i) > 'Z') {
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

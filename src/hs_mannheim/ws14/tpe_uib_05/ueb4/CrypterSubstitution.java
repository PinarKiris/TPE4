package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.LinkedList;
import java.util.List;

/**
 * Diese Klasse dient dazu, einen Text nach dem Substitutions-Verfahren zu
 * verschluesseln.
 * 
 * @author Dennis Keßler 1326697
 * @author Pınar Kırış 1332722
 * 
 */

public class CrypterSubstitution implements Crypter {

	private String key;

	/**
	 * Konstruktor um ein Caesar Verschluesselungsobjekt mit einem
	 * dazugehoerigen Schluessel zu erzeugen.
	 * 
	 * @param key
	 *            Schluessel
	 */

	public CrypterSubstitution(String key) {
		this.key = key;
	}

	@Override
	public String encrypt(String message) throws CrypterException {

		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) < 'A' || message.charAt(i) > 'Z') {
				throw new CrypterException("Verschluesselung nicht moeglich");
			}
		}
		StringBuffer ergebnis = new StringBuffer();
		for (int i = 0; i < message.length(); i++) {

			ergebnis.append(key.charAt((int) (message.charAt(i) - 65)));
		}
		return ergebnis.toString();
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
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer ergebnis = new StringBuffer();
		for (int j = 0; j < cypherText.length(); j++) {
			char zeichen = (cypherText.charAt(j));
			ergebnis.append(alpha.charAt(entschluesseln(zeichen)));
		}
		return ergebnis.toString();
	}

	/**
	 * Diese Methode ist fuer die Suche eines passenden Substitutionsbuchstabens
	 * verantwortlich
	 * 
	 * @param buchstabe
	 *            Buchstabe der substituiert werden soll
	 * @return passender Substitutionsbuchstabe
	 */

	private int entschluesseln(char buchstabe) {
		for (int j = 0; j < key.length(); j++) {
			if (buchstabe == key.charAt(j)) {
				return j;
			}
		}
		return 0;
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

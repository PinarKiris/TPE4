package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.List;

/**
 * Diese Klasse verschluesselt den Text nicht. Die Ausgabe der
 * Methoden entspricht der Eingabe.
 * 
 * @author Dennis Keßler 1326697
 * @author Pınar Kırış 1332722
 * 
 */

public class CrypterNull implements Crypter {

	@Override
	public String encrypt(String message) throws CrypterException {
		// Gibt die Nachricht unveraendert zurueck
		return message;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		// Gibt eine Liste an Nachrichten unveraendert zurueck
		return messages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		// Gibt die Nachricht unveraendert zurueck
		return cypherText;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// Gibt eine Liste an Nachrichten unveraendert zurueck
		return cypherTexte;
	}

}

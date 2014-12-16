package hs_mannheim.ws14.tpe_uib_05.ueb4;

/**
 * Diese Klasse umfasst die Auswahl einer geeigneten Verschluesselungsmethode,
 * wobei diese durch eine Enumeration ermoeglicht wird.
 * 
 * @author Dennis Keßler 1326697
 * @author Pınar Kırış 1332722
 */

public class CrypterFactory {

	/**
	 * Methode zum erstellen einer Verschluesselungsklasse
	 * 
	 * @param key
	 *            Schluessel nach dem dem verschluesselt wird
	 * @param crypterTyp
	 *            Auswahl des Verschluesselungsverfahrens (Enum)
	 * @return gibt eines Instanz der Verschluesslungsklasse zurueck.
	 * @throws CrypterException
	 *             Exception bei ungueltigem Schluessel
	 */

	public static Crypter createCrypter(String key, Enumeration crypterTyp)
			throws CrypterException {

		switch (crypterTyp) {

		case CAESAR:
			if (key.length() != 1
					|| (key.charAt(0) < 'A' || key.charAt(0) > 'Z')) {
				throw new IllegalKeyException("Ungültiger Schlüssel");
			} else {
				return new CrypterCaesar(key);
			}

		case SUBSTITUTION:
			if (key.length() != 26) {
				throw new IllegalKeyException("Ungültiger Schlüssel");
			} else {
				for (int i = 0; i < key.length(); i++) {

					if (key.charAt(i) < 'A' || key.charAt(i) > 'Z') {
						throw new IllegalKeyException("Ungültiger Schlüssel");
					}
				}
				return new CrypterSubstitution(key);
			}

		case XOR:
			for (int i = 0; i < key.length(); i++) {
				if (key.charAt(i) < 'A' || key.charAt(i) > 'Z') {
					throw new IllegalKeyException("Ungültiger Schlüssel");
				}
			}
			return new CrypterXOR(key);

		case NULL:
			return new CrypterNull();

		case REVERSE:
			for (int i = 0; i < key.length(); i++) {
				if (key.charAt(i) < 'A' || key.charAt(i) > 'Z') {
					throw new IllegalKeyException("Ungültiger Schlüssel");
				}
			}
			return new CrypterReverse();

		default:
			throw new CrypterException(
					"Der gewünschte Verschluesselungstyp existiert nicht");
		}
	}

}

package hs_mannheim.ws14.tpe_uib_05.ueb4;

public class CrypterFactory {

	/**
	 * Methode zum erstelle einer Verschluesselungsklasse
	 * 
	 * @param key
	 *            Schluessel nach dem dem verschluesselt wird
	 * @param crypterTyp
	 *            Auswahl des Verschluesselungsverfahrens (Enum)
	 * @return gibt eines Instanz der Verschluesslungsklasse zurueck.
	 * @throws CrypterException
	 */

	public static Crypter createCrypter(String key, Enumeration crypterTyp)
			throws CrypterException {

		switch (crypterTyp) {

		case CAESAR:
			try {
				return new CrypterCaesar(key);
			} catch (IllegalKeyException i) {
				System.out.println("CrypterFactory meldet:\n");
				System.out.println(i.getMessage());

				throw new CrypterException(
						"\nACHTUNG!\nDer CaesarCrypter mit dem Schluessel '"
								+ key
								+ "' wurde nicht angelegt! Verwenden Sie einen anderen Schluessel\n");
				// System.out
				// .println("\n::CAESAR-Verschluesselung::\nEs sind nur Schluessel mit einem Zeichen erlaubt.\n"
				// + "Es duerfen nur Zeichen zwischen A-Z verwendet werden.");
				// returns null, als Rueckgabewert, statt der CrypterCaesar
				// Instanz
			}

		case XOR:
			try {
				return new CrypterXOR(key);
			} catch (IllegalKeyException i) {
				System.out.println("CrypterFactory meldet:\n");
				System.out.println(i.getMessage());

				throw new CrypterException(
						"\nACHTUNG!\nDer CaesarXOR mit dem Schluessel '"
								+ key
								+ "' wurde nicht angelegt! Verwenden Sie einen anderen Schluessel\n");
				// System.out
				// .println("\n::XOR-Verschluesselung::\nEs sind nur Schluessel mit folgenden Zeichen erlaubt:\n"
				// + "Es duerfen nur Zeichen zwischen A-Z verwendet werden.");
				// returns null, als Rueckgabewert, statt der CrypterXOR
				// Instanz
			}
		case NULL:
			if (key != null) {
				throw new IllegalKeyException(
						"Fuer die Nullchiffre hat der Schluessel keine Bedeutung");
			}
			return new CrypterNull();

		case REVERSE:
			if (key != null) {
				throw new IllegalKeyException(
						"Fuer die Umkehrverschluesselung hat der Schluessel keine Bedeutung");
			}
			return new CrypterReverse();

		case SUBSTITUTION:
			if (key != null) {
				throw new IllegalKeyException(
						"Fuer das Subsitutionschiffre hat der Schluessel keine Bedeutung");
			}
			return new CrypterSubstitution();

		default:
			throw new CrypterException("Der gewünschte Crypter existiert nicht");
		}
	}

	/**
	 * @param selectedCrypter
	 * @return
	 * @throws CrypterException
	 */
	public static Crypter createCrypter(Enumeration crypterTyp)
			throws CrypterException {
		return createCrypter(null, crypterTyp);
	}

}

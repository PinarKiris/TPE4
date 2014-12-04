package hs_mannheim.ws14.tpe_uib_05.ueb4;

public enum Enumeration {

	/**
	 * Ceasar-Verschluesselungsmethode instanziiert einen Crypter vom Typ
	 * CrypterCaesar
	 */

	CAESAR(new CrypterCaesar()),

	/**
	 * Substitutions-Versschluesselungmethode instanziiert einen Crypter vom Typ
	 * CrypterSubstitution
	 */

	SUBSTITUTION(new CrypterSubstitution()),

	/**
	 * XOR-Versschluesselungmethode instanziiert einen Crypter vom Typ
	 * CrypterXOR
	 */

	XOR(new CrypterXOR()),

	/**
	 * Nullchiffre-Versschluesselungmethode instanziiert einen Crypter vom Typ
	 * CrypternNull
	 */

	NULL(new CrypterNull()),

	/**
	 * Umkehr-Versschluesselungmethode instanziiert einen Crypter vom Typ
	 * CrypterReverse
	 */

	REVERSE(new CrypterReverse());

	// der Typ des Crypters wird durch den Konstruktor festgelegt
	private Crypter crypterTyp;

	/**
	 * @param crypterTyp
	 *            neue Instanz der zuverwendenden Verschlüsselungsklasse
	 */
	private Enumeration(Crypter crypterTyp) {
		this.crypterTyp = crypterTyp;
	}

	/**
	 * @return gibt den gespeicherten Crypter zurück, der einer Instanz der
	 *         Verschlüsselungs Klasse entspricht
	 */
	public Crypter getCrypter() {
		return this.crypterTyp;
	}
}

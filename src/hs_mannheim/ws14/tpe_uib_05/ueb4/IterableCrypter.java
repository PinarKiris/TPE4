package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class IterableCrypter implements Iterable<String> {

	private Crypter crypt;
	private List<String> list;

	/**
	 * Konstrukor um ein Objekt der Klasse IterableCrypter zu erzeugen. Hierzu
	 * wird eine Liste, sowie eine Verschluesselungsart angegeben.
	 * 
	 * @param liste Die Liste
	 * @param cryptIn die Verschluesselungsart
	 * @throws CrypterException Wird geworfen, falls bei der Verschluesselung 
	 * ein Fehler auftritt.
	 */
	public IterableCrypter(List<String> liste, Crypter cryptIn) throws CrypterException {
		this.list = liste;
		this.crypt = cryptIn;
	}
	/**
	 * Konstrukor um ein Objekt der Klasse IterableCrypter zu erzeugen. Hierzu
	 * ein Iterable, sowie eine Verschluesselungsart angegeben.
	 * 
	 * @param iterableCrypt das Iterabl
	 * @param cryptIn die Verschluesselungsart
	 * @throws CrypterException Wird geworfen, falls bei der Verschluesselung 
	 * ein Fehler auftritt.
	 */
	public IterableCrypter(Iterable<String> iterableCrypt, Crypter cryptIn) throws CrypterException {
			list = new LinkedList<String>();
            for (String str : iterableCrypt) {
                list.add(str);
            }
            this.crypt = cryptIn;
	}
	/**
	 * Methode, die eine interne anonyme Klasse beinhaltet, zur 
	 * Implementierung des Iterators.
	 */
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			private int pos = 0;

			@Override
			public boolean hasNext() {
				return (pos < list.size());
			}

			@Override
			public String next() {
				try {
					return crypt.encrypt(list.get(pos++));
				}
				catch (CrypterException e) {
					System.out.println(e.getMessage());
				}
				return null;

			}};
	}

}

package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IterableDecrypter implements Iterable<String> {

	private List<String> list;
	private Crypter crypt;

	/**
	 * Konstrukor der ein Objekt der Klasse IterableDecrypter erzeugt, wobei
	 * eine Liste, sowie eine Verschluesselungsart angegeben wird.
	 * 
	 * @param liste
	 *            Die Liste
	 * @param crypt
	 *            die Verschluesselungsart
	 */

	public IterableDecrypter(List<String> liste, Crypter crypt)
			throws CrypterException {
		this.list = liste;
		this.crypt = crypt;
	}

	/**
	 * Konstrukor der ein Objekt der Klasse IterableDecrypter erzeugt, wobei
	 * eine Liste, sowie eine Verschluesselungsart angegeben wird.
	 * 
	 * @param iterableCrypt
	 *            das Iterable
	 * @param crypt
	 *            die Verschluesselungsart
	 */

	public IterableDecrypter(Iterable<String> iterableCrypt, Crypter crypt)
			throws CrypterException {
		list = new LinkedList<String>();
		for (String text : iterableCrypt) {
			list.add(text);
		}
		this.crypt = crypt;
	}

	/**
	 * Methode, die eine interne anonyme Klasse beinhaltet, zur Implementierung
	 * des Iterators.
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
					return crypt.decrypt(list.get(pos++));
				} catch (CrypterException e) {
					System.out.println(e.getMessage());
				}
				return null;

			}

			@Override
			public void remove() {

			}
		};
	}

}

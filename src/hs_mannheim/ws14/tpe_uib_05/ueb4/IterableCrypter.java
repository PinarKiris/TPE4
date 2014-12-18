package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class IterableCrypter implements Iterable<String> {

	private Crypter crypt;
	private List<String> list;

	/**
	 * Konstrukor der ein Objekt der Klasse IterableCrypter erzeugt, wobei eine
	 * Liste, sowie eine Verschluesselungsart angegeben wird.
	 * 
	 * @param liste
	 *            die Liste
	 * @param cryptIn
	 *            die Verschluesselungsart
	 */

	public IterableCrypter(List<String> liste, Crypter cryptIn)
			throws CrypterException {
		this.list = liste;
		this.crypt = cryptIn;
	}

	/**
	 * Konstrukor der ein Objekt der Klasse IterableCrypter erzeugt, wobei eine
	 * Liste, sowie eine Verschluesselungsart angegeben wird.
	 * 
	 * @param iterableCrypt
	 *            das Iterable
	 * @param cryptIn
	 *            die Verschluesselungsart
	 */

	public IterableCrypter(Iterable<String> iterableCrypt, Crypter cryptIn)
			throws CrypterException {
		list = new LinkedList<String>();
		for (String text : iterableCrypt) {
			list.add(text);
		}
		this.crypt = cryptIn;
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
					return crypt.encrypt(list.get(pos++));
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

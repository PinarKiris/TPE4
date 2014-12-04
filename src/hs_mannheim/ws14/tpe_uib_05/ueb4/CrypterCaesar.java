package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.List;
import java.util.HashMap;

public class CrypterCaesar implements Crypter {

	// http://wiki.freitagsrunde.org/Javakurs/%C3%9Cbungsaufgaben/C%C3%A4sar-Chiffre/Musterloesung

	/*
	 * HashMap<Character, Character> verschluesseln; HashMap<Character,
	 * Character> entschluesseln;
	 * 
	 * /**
	 * 
	 * @param verschiebung
	 * 
	 * 
	 * 
	 * public CrypterCaesar(int verschiebung) { super(); verschluesseln = new
	 * HashMap<Character, Character>(); entschluesseln = new HashMap<Character,
	 * Character>(); Caeser(verschiebung); }
	 * 
	 * private String uebersetze (String text, HashMap <Character, Character>
	 * alphabet){ String keineKleinBuchstaben = text.toUpperCase().replace("",
	 * "");
	 * 
	 * 
	 * private void Caesar();
	 * 
	 * if (schleife = 'A'; schleife <= 'Z'; schleife ++ ) { Character schleife;
	 * int verschiebung1; if (schleife <= 'Z'){ verschluesseln.put(schleife,
	 * (char) (schleife+verschiebung1)); entschluesseln.put((char)
	 * (schleife+verschiebung1), schleife); }else{ verschluesseln.put(schleife,
	 * (char) (schleife+verschiebung1 -26)); entschluesseln.put((char)
	 * (schleife+verschiebung1-26), schleife); } }
	 * 
	 * 
	 * }
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		return null;

	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {

		return null;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {

		return null;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {

		return null;
	}

}

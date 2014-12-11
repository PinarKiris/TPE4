package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

public class CrypterCaesar implements Crypter {

	private static final int i = 0;
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
	
	private String schluessel;
	
	public CrypterCaesar (String schluessel){
		this.schluessel = schluessel;
	}
	
	
	
	
	@Override
	public String encrypt(String message) throws CrypterException {
		int verschiebung = ((int) this.schluessel.charAt (0)) - 64;
		return encrypt (String(message, verschiebung));

	}

	private String String(String message, int verschiebung) {
		message = message.toUpperCase();
		String ergebnis = "";
		for (int i = 0; i< message.length(); i++);
			
			ergebnis += (char) ((message.charAt(i) - 'A' + verschiebung) % 26 + 'A' );
		return ergebnis;
	}


	@Override
	public List<String> encrypt(List<String> messagesGanz) throws CrypterException {
		List <String> ergebnis = new LinkedList<String>();
		for (String message : messagesGanz){
			ergebnis.add(encrypt(message));
		}
		

		return ergebnis;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		int verschiebung = (int) this.schluessel.charAt(0) + 64;

		return decrypt (String(cypherText, -verschiebung));
	}
	
	
	@SuppressWarnings("unused")
	private String decrypt(String text, int verschiebung) {
		text = text.toUpperCase();
		String ergebnis = "";
		for (int i = 0; i< text.length(); i++);
			
			char zeichen  = (char) ((text.charAt(i) - 'A' + verschiebung) % 26 + 'A' );
			if (zeichen < 65){
				ergebnis += (char) (zeichen +26);
			}else{
				ergebnis += (char) zeichen;
				
			}
				
		return ergebnis;
	}

		

	@Override
	public List<String> decrypt(List<String> cypherTexteGanz)
			throws CrypterException {
		List <String> ergebnis = new LinkedList<String>();
		for (String text : cypherTexteGanz){
			ergebnis.add(encrypt(text));
		}
		return ergebnis;
	}

}

package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.HashMap;

public class CrypterCeaser {
	HashMap <Character, Character> verschluesseln;
	HashMap <Character, Character> entschluesseln;
	/**
	 * @param verschiebung 
	 * 
	 */
	public CrypterCeaser(int verschiebung) {
		super();
		verschluesseln = new HashMap <Character,Character> ();
		entschluesseln = new HashMap <Character, Character> ();
		Ceaser(verschiebung);
	}
	private String uebersetze (String text, HashMap <Character, Character> alphabet){
		String keineKleinBuchstaben = text.toUpperCase().replace("", "");
		
		
	private void Ceaser ();
	
		if (schleife = 'A'; schleife <= 'Z'; schleife ++ ) {
			Character schleife;
			int verschiebung1;
			if (schleife <= 'Z'){
			verschluesseln.put(schleife, (char) (schleife+verschiebung1));
			entschluesseln.put((char) (schleife+verschiebung1), schleife);
			}else{
			verschluesseln.put(schleife, (char) (schleife+verschiebung1 -26));
			entschluesseln.put((char) (schleife+verschiebung1-26), schleife);
		}
}
}
}

	


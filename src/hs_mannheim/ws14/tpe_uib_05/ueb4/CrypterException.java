package hs_mannheim.ws14.tpe_uib_05.ueb4;

/**
 * Diese Klasse umfasst eine Exception, die dazu dient auftretende Fehler bei
 * einer Verschluesselung zu behandeln.
 * 
 * @author Dennis Keßler 1326697
 * @author Pınar Kırış 1332722
 *
 */

public class CrypterException extends Exception {

	public CrypterException() {
		super();
	}

	public CrypterException(String message) {
		super(message);

	}

}

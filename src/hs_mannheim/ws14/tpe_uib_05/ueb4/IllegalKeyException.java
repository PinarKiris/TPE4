package hs_mannheim.ws14.tpe_uib_05.ueb4;

/**
 * Exception, die dazu dient Fehler bei der Verschluesselung zu behandeln,
 * insofern ein nicht erlaubter Schluessel verwendet/eingegeben wurde.
 * 
 * @author Dennis Keßler 1326697
 * @author Pınar Kırış 1332722
 *
 */

public class IllegalKeyException extends CrypterException {

	public IllegalKeyException() {
		super();
	}

	public IllegalKeyException(String message) {
		super(message);
	}

}

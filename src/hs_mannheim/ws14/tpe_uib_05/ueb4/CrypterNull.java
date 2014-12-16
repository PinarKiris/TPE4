package hs_mannheim.ws14.tpe_uib_05.ueb4;

import java.util.List;

/**
 * 
 * @author Dennis Keßler 1326697
 * @author Pınar Kırış 1332722
 * 
 */

public class CrypterNull implements Crypter {

	 /**
     * Konstruktor zum erstellen einer Nullchiffre Verschluesselung
     */
    public CrypterNull(){
        super();
    }
    
    @Override
    public String encrypt(String message) throws CrypterException {
        //loescht alle ungueltigen Zeichn und gibt den String zurueck
        return CrypterTools.deleteForbiddenCharakters(message);
    }

    @Override
    public List<String> encrypt(List<String> messages) throws CrypterException {
        for(String thisString : messages){
            thisString = encrypt(thisString);
        }
        return messages;
    }

    @Override
    public String decrypt(String cypherText) throws CrypterException {
        return encrypt(cypherText);
    }

    @Override
    public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
        return encrypt(cypherTexte);
    }

}

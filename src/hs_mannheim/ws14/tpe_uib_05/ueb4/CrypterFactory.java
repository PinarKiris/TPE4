package hs_mannheim.ws14.tpe_uib_05.ueb4;

public class CrypterFactory {

	public boolean createCrypter(String key, Enumeration crypterTyp)
			throws IllegalKeyException {

		Crypter crypter = crypterTyp.getCrypter();

		return true;

	}

	private boolean validKey(String key, Crypter crypterTyp) {
		return true;
	}

}

package hs_mannheim.ws14.tpe_uib_05.ueb4;


public class SecretMessage {

	public static void main(String[] args) throws IllegalKeyException, CrypterException {
		
		String geheimbotschaft = "QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X";
		Crypter xor = new CrypterFactory().createCrypter("IAMTHEONEWHOKNOCKS", Enumeration.XOR);
		Crypter reverse = new CrypterFactory().createCrypter("", Enumeration.REVERSE);
		Crypter caesar = new CrypterFactory().createCrypter("L", Enumeration.CAESAR);
		Crypter sub = new CrypterFactory().createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ", Enumeration.SUBSTITUTION);
		
		geheimbotschaft = xor.decrypt(geheimbotschaft);
		geheimbotschaft = reverse.decrypt(geheimbotschaft);
		geheimbotschaft = caesar.decrypt(geheimbotschaft);
		geheimbotschaft = sub.decrypt(geheimbotschaft);
		
		System.out.println(geheimbotschaft);

	}
}

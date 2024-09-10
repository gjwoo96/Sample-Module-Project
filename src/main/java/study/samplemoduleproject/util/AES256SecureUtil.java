package study.samplemoduleproject.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

;

@Component
public class AES256SecureUtil {

	
	private static String key;
	private static String alg = "AES/CBC/PKCS5Padding";
	
	@Value("${ws.aes256key}")
	public void setKey(String k) {
		key = k;
	}
	
	public static String encrypt(String text) {
		try {
			String iv = key.substring(0, 16); // 16byte
			
			Cipher cipher = Cipher.getInstance(alg);
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
			IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);
	
			byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
			return Base64.getEncoder().encodeToString(encrypted);
			
		}catch (Exception e) {
			return text;
		}
	}

	public static String decrypt(String cipherText) {
		
		try {
			
			String iv = key.substring(0, 16); // 16byte
			
			Cipher cipher = Cipher.getInstance(alg);
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
			IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);
	
			byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
			byte[] decrypted = cipher.doFinal(decodedBytes);
			
			return new String(decrypted, "UTF-8");
		
		}catch (Exception e) {
			return cipherText;
		}
	}

}

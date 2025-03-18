package main.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Arrays;

public class Encryption {

    private static final String ALGORITHM = "AES";
    private static final byte[] PASSKEY = Arrays.copyOf("MySecurePassKey123".getBytes(), 16); // Ensures exactly 16 bytes


    public static String encrypt(String message) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(PASSKEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedMessage) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(PASSKEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            String message = "Hello, Steganography!";
            String encrypted = encrypt(message);
            String decrypted = decrypt(encrypted);

            System.out.println("Original: " + message);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

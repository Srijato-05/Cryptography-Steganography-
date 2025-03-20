package main.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Decryption extends AbstractCrypto {
    @Override
    public String process(String passkey, String unused) throws Exception {
        byte[] key = generateKey(passkey);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        String encryptedMessage = new String(Files.readAllBytes(Paths.get(FILE_PATH)), StandardCharsets.UTF_8).trim();
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    private byte[] generateKey(String passkey) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = sha.digest(passkey.getBytes(StandardCharsets.UTF_8));
        return java.util.Arrays.copyOf(key, 16);
    }
}

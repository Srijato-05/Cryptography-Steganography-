package main.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Encryption extends AbstractCrypto {
    @Override
    public String process(String message, String passkey) throws Exception {
        byte[] key = generateKey(passkey);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);

        Files.write(Paths.get(FILE_PATH), encryptedMessage.getBytes(StandardCharsets.UTF_8));
        return encryptedMessage;
    }

    private byte[] generateKey(String passkey) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = sha.digest(passkey.getBytes(StandardCharsets.UTF_8));
        return java.util.Arrays.copyOf(key, 16);
    }
}

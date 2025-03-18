package main.encryption;

import java.util.Scanner;
import java.util.Base64;

// Interface for decryption
interface Decryptor {
    String decrypt(String encryptedMessage, String passkey);
}

// Concrete implementation of Decryptor
public class Decryption implements Decryptor {

    @Override
    public String decrypt(String encryptedMessage, String passkey) {
        // Simple key-based transformation (for now, future improvements possible)
        String combined = new String(Base64.getDecoder().decode(encryptedMessage));
        return combined.replace(passkey, "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the encrypted message: ");
        String encrypted = scanner.nextLine();
        System.out.print("Enter the passkey: ");
        String passkey = scanner.nextLine();
        scanner.close();

        Decryptor decryptor = new Decryption();
        String decrypted = decryptor.decrypt(encrypted, passkey);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}

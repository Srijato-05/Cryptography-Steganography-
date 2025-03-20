package main;

import main.encryption.Encryption;
import main.encryption.Decryption;
import main.ui.AppUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppUI appUI = new AppUI();

            appUI.getEncryptButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField messageField = new JTextField();
                    JTextField passkeyField = new JTextField();

                    Object[] inputFields = { "Enter message:", messageField, "Enter passkey:", passkeyField };
                    int option = JOptionPane.showConfirmDialog(appUI.getFrame(), inputFields, "Encrypt Message", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        String message = messageField.getText();
                        String passkey = passkeyField.getText();
                        if (!message.isEmpty() && !passkey.isEmpty()) {
                            try {
                                Encryption encryption = new Encryption();
                                String encryptedMessage = encryption.process(message, passkey);
                                File file = new File("src/main/input_output/encrypted_message.txt");
                                FileWriter writer = new FileWriter(file);
                                writer.write(encryptedMessage);
                                writer.close();
                                JOptionPane.showMessageDialog(appUI.getFrame(), "Encrypted Message saved to file: encrypted_message.txt", "Encryption Success", JOptionPane.INFORMATION_MESSAGE);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(appUI.getFrame(), "Encryption failed!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            });

            appUI.getDecryptButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField passkeyField = new JTextField();

                    Object[] inputFields = { "Enter passkey:", passkeyField };
                    int option = JOptionPane.showConfirmDialog(appUI.getFrame(), inputFields, "Decrypt Message", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        String passkey = passkeyField.getText();
                        if (!passkey.isEmpty()) {
                            try {
                                JFileChooser fileChooser = new JFileChooser("src/main/input_output/");
                                int returnValue = fileChooser.showOpenDialog(null);
                                if (returnValue == JFileChooser.APPROVE_OPTION) {
                                    Decryption decryption = new Decryption();
                                    String decryptedMessage = decryption.process(passkey, "");
                                    JOptionPane.showMessageDialog(appUI.getFrame(), "Decrypted Message:\n" + decryptedMessage, "Decryption Success", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(appUI.getFrame(), "Decryption failed!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            });
        });
    }
}
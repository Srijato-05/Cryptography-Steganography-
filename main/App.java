package main;

import main.encryption.Encryption;
import main.encryption.Decryption;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create frame
            JFrame frame = new JFrame("Steganography Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new GridBagLayout());
            frame.getContentPane().setBackground(new Color(30, 30, 30)); // Dark theme

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = 0;
            gbc.gridy = 0;

            // Create Encryption heading
            JLabel encryptionHeading = new JLabel("Encryption");
            encryptionHeading.setFont(new Font("Arial", Font.BOLD, 24));
            encryptionHeading.setForeground(Color.WHITE);
            frame.add(encryptionHeading, gbc);

            // Create Encryption buttons
            JButton encryptButton = new JButton("Encrypt & Save Message");
            JButton decryptButton = new JButton("Upload & Decrypt Message");

            // Style Encryption buttons
            encryptButton.setFont(new Font("Arial", Font.BOLD, 16));
            encryptButton.setBackground(new Color(50, 150, 250));
            encryptButton.setForeground(Color.WHITE);
            encryptButton.setFocusPainted(false);

            decryptButton.setFont(new Font("Arial", Font.BOLD, 16));
            decryptButton.setBackground(new Color(250, 100, 100));
            decryptButton.setForeground(Color.WHITE);
            decryptButton.setFocusPainted(false);

            // Add action listeners to buttons
            encryptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField messageField = new JTextField();
                    JTextField passkeyField = new JTextField();

                    Object[] inputFields = { "Enter message:", messageField, "Enter passkey:", passkeyField };
                    int option = JOptionPane.showConfirmDialog(frame, inputFields, "Encrypt Message", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        String message = messageField.getText();
                        String passkey = passkeyField.getText();
                        if (!message.isEmpty() && !passkey.isEmpty()) {
                            try {
                                String encryptedMessage = Encryption.encrypt(message, passkey);
                                File file = new File("encrypted_message.txt");
                                FileWriter writer = new FileWriter(file);
                                writer.write(encryptedMessage);
                                writer.close();
                                JOptionPane.showMessageDialog(frame, "Encrypted Message saved to file: encrypted_message.txt", "Encryption Success", JOptionPane.INFORMATION_MESSAGE);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(frame, "Encryption failed!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            });

            decryptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField passkeyField = new JTextField();

                    Object[] inputFields = { "Enter passkey:", passkeyField };
                    int option = JOptionPane.showConfirmDialog(frame, inputFields, "Decrypt Message", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        String passkey = passkeyField.getText();
                        if (!passkey.isEmpty()) {
                            try {
                                JFileChooser fileChooser = new JFileChooser();
                                int returnValue = fileChooser.showOpenDialog(null);
                                if (returnValue == JFileChooser.APPROVE_OPTION) {
                                    File selectedFile = fileChooser.getSelectedFile();
                                    BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                                    String encryptedMessage = reader.readLine();
                                    reader.close();

                                    String decryptedMessage = Decryption.decrypt(passkey);
                                    JOptionPane.showMessageDialog(frame, "Decrypted Message:\n" + decryptedMessage, "Decryption Success", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(frame, "Decryption failed!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            });

            // Add Encryption buttons to layout
            gbc.gridy = 1;
            frame.add(encryptButton, gbc);
            gbc.gridy = 2;
            frame.add(decryptButton, gbc);

            // Create Steganography heading
            gbc.gridy = 3;
            JLabel stegoHeading = new JLabel("Steganography");
            stegoHeading.setFont(new Font("Arial", Font.BOLD, 24));
            stegoHeading.setForeground(Color.WHITE);
            frame.add(stegoHeading, gbc);

            // Create Steganography buttons
            JButton imageButton = new JButton("Image");
            JButton audioButton = new JButton("Audio");
            JButton videoButton = new JButton("Video");

            // Style Steganography buttons
            imageButton.setFont(new Font("Arial", Font.BOLD, 16));
            imageButton.setBackground(new Color(100, 200, 100));
            imageButton.setForeground(Color.WHITE);
            imageButton.setFocusPainted(false);

            audioButton.setFont(new Font("Arial", Font.BOLD, 16));
            audioButton.setBackground(new Color(200, 200, 50));
            audioButton.setForeground(Color.WHITE);
            audioButton.setFocusPainted(false);

            videoButton.setFont(new Font("Arial", Font.BOLD, 16));
            videoButton.setBackground(new Color(200, 100, 250));
            videoButton.setForeground(Color.WHITE);
            videoButton.setFocusPainted(false);

            // Add Steganography buttons to layout
            gbc.gridy = 4;
            frame.add(imageButton, gbc);
            gbc.gridy = 5;
            frame.add(audioButton, gbc);
            gbc.gridy = 6;
            frame.add(videoButton, gbc);

            // Make frame visible
            frame.setVisible(true);
        });
    }
}
package main;

import javax.swing.*;
import java.awt.*;

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
            JButton encryptButton = new JButton("Encrypt & Hide Message");
            JButton decryptButton = new JButton("Retrieve & Decrypt Message");

            // Style Encryption buttons
            encryptButton.setFont(new Font("Arial", Font.BOLD, 16));
            encryptButton.setBackground(new Color(50, 150, 250));
            encryptButton.setForeground(Color.WHITE);
            encryptButton.setFocusPainted(false);

            decryptButton.setFont(new Font("Arial", Font.BOLD, 16));
            decryptButton.setBackground(new Color(250, 100, 100));
            decryptButton.setForeground(Color.WHITE);
            decryptButton.setFocusPainted(false);

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

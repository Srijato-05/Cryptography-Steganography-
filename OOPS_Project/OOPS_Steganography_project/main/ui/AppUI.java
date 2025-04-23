package main.ui;

import java.awt.*;
import javax.swing.*;

public class AppUI extends AbstractUI {
    private JButton videoButton;
    private JButton encryptHideButton, extractDecryptButton;
    private JButton encryptAudioButton, decryptAudioButton;

    public AppUI() {
        super(); // Ensure frame is initialized
    }

    @Override
    protected void initializeComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel encryptionHeading = new JLabel("Encryption");
        encryptionHeading.setFont(new Font("Arial", Font.BOLD, 24));
        encryptionHeading.setForeground(Color.WHITE);
        frame.add(encryptionHeading, gbc);

        encryptButton = new JButton("Encrypt & Save Message");
        decryptButton = new JButton("Upload & Decrypt Message");
        styleButton(encryptButton, new Color(50, 150, 250));
        styleButton(decryptButton, new Color(250, 100, 100));

        gbc.gridy = 1;
        frame.add(encryptButton, gbc);
        gbc.gridy = 2;
        frame.add(decryptButton, gbc);

        JLabel stegoHeading = new JLabel("Steganography");
        stegoHeading.setFont(new Font("Arial", Font.BOLD, 24));
        stegoHeading.setForeground(Color.WHITE);
        gbc.gridy = 3;
        frame.add(stegoHeading, gbc);

        // Image buttons
        encryptHideButton = new JButton("Encrypt & Hide in Image");
        extractDecryptButton = new JButton("Extract & Decrypt from Image");
        styleButton(encryptHideButton, new Color(120, 180, 120));
        styleButton(extractDecryptButton, new Color(180, 120, 120));

        gbc.gridy = 4;
        frame.add(encryptHideButton, gbc);
        gbc.gridy = 5;
        frame.add(extractDecryptButton, gbc);

        // Audio buttons
        encryptAudioButton = new JButton("Encrypt & Hide in Audio");
        decryptAudioButton = new JButton("Extract & Decrypt from Audio");
        styleButton(encryptAudioButton, new Color(120, 150, 200));
        styleButton(decryptAudioButton, new Color(200, 150, 120));

        gbc.gridy = 6;
        frame.add(encryptAudioButton, gbc);
        gbc.gridy = 7;
        frame.add(decryptAudioButton, gbc);

        // Video button
        videoButton = new JButton("Video");
        styleButton(videoButton, new Color(200, 100, 250));
        gbc.gridy = 8;
        frame.add(videoButton, gbc);
    }

    public JButton getEncryptButton() {
        return encryptButton;
    }

    public JButton getDecryptButton() {
        return decryptButton;
    }

    public JButton getEncryptHideButton() {
        return encryptHideButton;
    }

    public JButton getExtractDecryptButton() {
        return extractDecryptButton;
    }

    public JButton getEncryptAudioButton() {
        return encryptAudioButton;
    }

    public JButton getDecryptAudioButton() {
        return decryptAudioButton;
    }

    public JButton getVideoButton() {
        return videoButton;
    }
}

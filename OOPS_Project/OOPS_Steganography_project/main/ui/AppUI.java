package main.ui;

import java.awt.*;
import javax.swing.*;

public class AppUI extends AbstractUI {
    private JButton encryptHideButton, extractDecryptButton;
    private JButton encryptAudioButton, decryptAudioButton;

    public AppUI() {
        super();
        frame.setTitle("SecureStego"); // Updated window title only
    }

    @Override
    protected void initializeComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel title = new JLabel("SecureStego");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(new Color(0xCCCCFF));
        frame.add(title, gbc);

        gbc.gridy++;
        JLabel encryptionHeading = new JLabel("Encryption");
        encryptionHeading.setFont(new Font("Arial", Font.BOLD, 24));
        encryptionHeading.setForeground(Color.WHITE);
        frame.add(encryptionHeading, gbc);

        encryptButton = new JButton("Encrypt & Save Message");
        decryptButton = new JButton("Upload & Decrypt Message");
        styleButton(encryptButton, new Color(50, 150, 250));
        styleButton(decryptButton, new Color(250, 100, 100));

        gbc.gridy++;
        frame.add(encryptButton, gbc);
        gbc.gridy++;
        frame.add(decryptButton, gbc);

        gbc.gridy++;
        JLabel stegoHeading = new JLabel("Steganography");
        stegoHeading.setFont(new Font("Arial", Font.BOLD, 24));
        stegoHeading.setForeground(Color.WHITE);
        frame.add(stegoHeading, gbc);

        encryptHideButton = new JButton("Encrypt & Hide in Image");
        extractDecryptButton = new JButton("Extract & Decrypt from Image");
        styleButton(encryptHideButton, new Color(120, 180, 120));
        styleButton(extractDecryptButton, new Color(180, 120, 120));

        gbc.gridy++;
        frame.add(encryptHideButton, gbc);
        gbc.gridy++;
        frame.add(extractDecryptButton, gbc);

        encryptAudioButton = new JButton("Encrypt & Hide in Audio");
        decryptAudioButton = new JButton("Extract & Decrypt from Audio");
        styleButton(encryptAudioButton, new Color(120, 150, 200));
        styleButton(decryptAudioButton, new Color(200, 150, 120));

        gbc.gridy++;
        frame.add(encryptAudioButton, gbc);
        gbc.gridy++;
        frame.add(decryptAudioButton, gbc);
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

    public JFrame getFrame() {
        return frame;
    }
}

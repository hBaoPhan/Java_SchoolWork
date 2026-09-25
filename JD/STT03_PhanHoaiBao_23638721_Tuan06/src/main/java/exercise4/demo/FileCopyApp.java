package exercise4.demo;

import exercise4.gui.FileCopyFrame;

import javax.swing.*;

/**
 * Main application launcher for Exercise 4: File Copy with Progress Bar.
 */
public class FileCopyApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new FileCopyFrame().setVisible(true);
        });
    }
}

package exercise5.demo;

import exercise5.gui.MySimpleNotepad;

import javax.swing.*;

/**
 * Launcher for Exercise 5: Tý tèo simple Notepad.
 */
public class NotepadApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new MySimpleNotepad().setVisible(true);
        });
    }
}

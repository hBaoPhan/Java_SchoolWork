package exercise6.demo;

import exercise6.gui.FileSplitterCombinerFrame;

import javax.swing.*;

public class FileSplitterCombinerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }
            new FileSplitterCombinerFrame().setVisible(true);
        });
    }
}

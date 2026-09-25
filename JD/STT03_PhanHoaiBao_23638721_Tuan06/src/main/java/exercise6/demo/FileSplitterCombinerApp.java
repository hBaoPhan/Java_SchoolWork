package exercise6.demo;

import exercise6.gui.FileSplitterCombinerFrame;

import javax.swing.*;

/**
 * Launcher for Exercise 6: Splitter and Combiner GUI Utility.
 */
public class FileSplitterCombinerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new FileSplitterCombinerFrame().setVisible(true);
        });
    }
}

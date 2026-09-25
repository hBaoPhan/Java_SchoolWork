package exercise4.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.util.List;

public class FileCopyFrame extends JFrame {
    private final JTextField txtFrom;
    private final JTextField txtTo;
    private final JButton btnBrowseFrom;
    private final JButton btnBrowseTo;
    private final JButton btnCopy;
    private final JProgressBar progressBar;
    private final JLabel lblStatus;

    private SwingWorker<Void, Integer> copyWorker;

    public FileCopyFrame() {
        setTitle("Copying File");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 260);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Form panel for From and To
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // "From" row
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        formPanel.add(new JLabel("From:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtFrom = new JTextField();
        formPanel.add(txtFrom, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;
        btnBrowseFrom = new JButton("Browse...");
        formPanel.add(btnBrowseFrom, gbc);

        // "To" row
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        formPanel.add(new JLabel("To:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtTo = new JTextField();
        formPanel.add(txtTo, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;
        btnBrowseTo = new JButton("Browse...");
        formPanel.add(btnBrowseTo, gbc);

        mainPanel.add(formPanel, BorderLayout.NORTH);

        // Center panel for Action & Progress
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 8, 8));
        centerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCopy = new JButton("Copy...");
        btnCopy.setPreferredSize(new Dimension(130, 32));
        btnPanel.add(btnCopy);
        centerPanel.add(btnPanel);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setString("0%");
        progressBar.setPreferredSize(new Dimension(460, 24));
        centerPanel.add(progressBar);

        lblStatus = new JLabel("Select source and destination files to begin.", SwingConstants.CENTER);
        lblStatus.setFont(lblStatus.getFont().deriveFont(Font.ITALIC, 11f));
        centerPanel.add(lblStatus);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        add(mainPanel);

        // Event listeners
        btnBrowseFrom.addActionListener(e -> chooseSourceFile());
        btnBrowseTo.addActionListener(e -> chooseDestinationFile());
        btnCopy.addActionListener(e -> startFileCopy());
    }

    private void chooseSourceFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select Source File");
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selected = chooser.getSelectedFile();
            txtFrom.setText(selected.getAbsolutePath());
            if (txtTo.getText().trim().isEmpty()) {
                // Suggest destination file in same folder with copy prefix
                File dest = new File(selected.getParentFile(), "copy_" + selected.getName());
                txtTo.setText(dest.getAbsolutePath());
            }
        }
    }

    private void chooseDestinationFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select Destination File or Directory");
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selected = chooser.getSelectedFile();
            txtTo.setText(selected.getAbsolutePath());
        }
    }

    private void startFileCopy() {
        String fromPath = txtFrom.getText().trim();
        String toPath = txtTo.getText().trim();

        if (fromPath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter or select a source file.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        File sourceFile = new File(fromPath);
        if (!sourceFile.exists() || !sourceFile.isFile()) {
            JOptionPane.showMessageDialog(this, "Source file does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (toPath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter or select a destination path.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        File destFile = new File(toPath);
        if (destFile.isDirectory()) {
            destFile = new File(destFile, sourceFile.getName());
            txtTo.setText(destFile.getAbsolutePath());
        }

        if (sourceFile.getAbsolutePath().equalsIgnoreCase(destFile.getAbsolutePath())) {
            JOptionPane.showMessageDialog(this, "Source and destination cannot be identical!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Lock UI controls during copy
        setUIEnabled(false);
        progressBar.setValue(0);
        progressBar.setString("0%");
        lblStatus.setText("Copying in progress...");

        final File finalSource = sourceFile;
        final File finalDest = destFile;

        copyWorker = new SwingWorker<Void, Integer>() {
            private long totalCopied = 0;
            private long totalBytes = finalSource.length();

            @Override
            protected Void doInBackground() throws Exception {
                byte[] buffer = new byte[64 * 1024]; // 64 KB buffer
                try (InputStream in = new BufferedInputStream(new FileInputStream(finalSource));
                        OutputStream out = new BufferedOutputStream(new FileOutputStream(finalDest))) {

                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                        totalCopied += bytesRead;
                        int progress = (totalBytes > 0) ? (int) ((totalCopied * 100) / totalBytes) : 100;
                        publish(progress);
                        // Brief pause to make progress visible for small demo files
                        if (totalBytes < 5 * 1024 * 1024) {
                            Thread.sleep(15);
                        }
                    }
                    out.flush();
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                int latestProgress = chunks.get(chunks.size() - 1);
                progressBar.setValue(latestProgress);
                progressBar.setString(latestProgress + "%");
                lblStatus.setText(String.format("Copied: %s / %s (%d%%)",
                        formatBytes(totalCopied), formatBytes(totalBytes), latestProgress));
            }

            @Override
            protected void done() {
                setUIEnabled(true);
                try {
                    get(); // Check for exceptions during copy
                    progressBar.setValue(100);
                    progressBar.setString("100%");
                    lblStatus.setText("File copied successfully!");
                    JOptionPane.showMessageDialog(FileCopyFrame.this,
                            "File copied successfully to:\n" + finalDest.getAbsolutePath(),
                            "Copy Complete", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    lblStatus.setText("Error during copy: " + ex.getMessage());
                    JOptionPane.showMessageDialog(FileCopyFrame.this,
                            "Failed to copy file: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        copyWorker.execute();
    }

    private void setUIEnabled(boolean enabled) {
        btnCopy.setEnabled(enabled);
        btnBrowseFrom.setEnabled(enabled);
        btnBrowseTo.setEnabled(enabled);
        txtFrom.setEditable(enabled);
        txtTo.setEditable(enabled);
    }

    private String formatBytes(long bytes) {
        if (bytes < 1024)
            return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char pre = "KMGTPE".charAt(exp - 1);
        return String.format("%.1f %cB", bytes / Math.pow(1024, exp), pre);
    }
}

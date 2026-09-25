package exercise6.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSplitterCombinerFrame extends JFrame {
    private JTabbedPane tabbedPane;

    // --- Split Controls ---
    private JTextField txtSplitInputFile;
    private JTextField txtSplitOutputFolder;
    private JTextField txtNumParts;
    private JButton btnBrowseSplitInput;
    private JButton btnBrowseSplitOutput;
    private JButton btnSplit;
    private JProgressBar splitProgressBar;
    private JLabel lblSplitStatus;

    // --- Combine Controls ---
    private JTextField txtCombineFirstPart;
    private JTextField txtCombineOutputFile;
    private JButton btnBrowseCombinePart;
    private JButton btnBrowseCombineOutput;
    private JButton btnCombine;
    private JProgressBar combineProgressBar;
    private JLabel lblCombineStatus;

    public FileSplitterCombinerFrame() {
        super("Splitter and Combiner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(560, 360);
        setLocationRelativeTo(null);
        setResizable(false);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Split File", createSplitPanel());
        tabbedPane.addTab("Combine", createCombinePanel());

        getContentPane().add(tabbedPane);
    }

    private JPanel createSplitPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(12, 12, 12, 12));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 1: Input File
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        form.add(new JLabel("Input File:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtSplitInputFile = new JTextField();
        form.add(txtSplitInputFile, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0;
        btnBrowseSplitInput = new JButton("...");
        btnBrowseSplitInput.setPreferredSize(new Dimension(45, 24));
        form.add(btnBrowseSplitInput, gbc);

        // Row 2: Output Folder
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        form.add(new JLabel("Output Folder:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtSplitOutputFolder = new JTextField();
        form.add(txtSplitOutputFolder, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0;
        btnBrowseSplitOutput = new JButton("...");
        btnBrowseSplitOutput.setPreferredSize(new Dimension(45, 24));
        form.add(btnBrowseSplitOutput, gbc);

        // Row 3: Number of files
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        form.add(new JLabel("Enter number of files to split into:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtNumParts = new JTextField("3");
        form.add(txtNumParts, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0;
        form.add(new JLabel(""), gbc);

        panel.add(form, BorderLayout.NORTH);

        // Action and Progress Panel
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
        actionPanel.setBorder(new EmptyBorder(10, 10, 5, 10));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSplit = new JButton("Split Its");
        btnSplit.setPreferredSize(new Dimension(130, 32));
        btnPanel.add(btnSplit);
        actionPanel.add(btnPanel);

        splitProgressBar = new JProgressBar(0, 100);
        splitProgressBar.setStringPainted(true);
        splitProgressBar.setString("0%");
        actionPanel.add(splitProgressBar);

        lblSplitStatus = new JLabel("Ready", SwingConstants.CENTER);
        lblSplitStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSplitStatus.setBorder(new EmptyBorder(8, 0, 0, 0));
        actionPanel.add(lblSplitStatus);

        panel.add(actionPanel, BorderLayout.CENTER);

        // Event listeners
        btnBrowseSplitInput.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Select File to Split");
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                txtSplitInputFile.setText(file.getAbsolutePath());
                if (txtSplitOutputFolder.getText().trim().isEmpty()) {
                    txtSplitOutputFolder.setText(file.getParent());
                }
            }
        });

        btnBrowseSplitOutput.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Select Output Folder");
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                txtSplitOutputFolder.setText(fc.getSelectedFile().getAbsolutePath());
            }
        });

        btnSplit.addActionListener(e -> startSplitting());

        return panel;
    }

    private JPanel createCombinePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(12, 12, 12, 12));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 1: First Part File
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        form.add(new JLabel("First Part File (.part001):"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtCombineFirstPart = new JTextField();
        form.add(txtCombineFirstPart, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0;
        btnBrowseCombinePart = new JButton("...");
        btnBrowseCombinePart.setPreferredSize(new Dimension(45, 24));
        form.add(btnBrowseCombinePart, gbc);

        // Row 2: Output File
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        form.add(new JLabel("Output Merged File:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtCombineOutputFile = new JTextField();
        form.add(txtCombineOutputFile, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0;
        btnBrowseCombineOutput = new JButton("...");
        btnBrowseCombineOutput.setPreferredSize(new Dimension(45, 24));
        form.add(btnBrowseCombineOutput, gbc);

        panel.add(form, BorderLayout.NORTH);

        // Action and Progress Panel
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
        actionPanel.setBorder(new EmptyBorder(10, 10, 5, 10));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCombine = new JButton("Combine Its");
        btnCombine.setPreferredSize(new Dimension(130, 32));
        btnPanel.add(btnCombine);
        actionPanel.add(btnPanel);

        combineProgressBar = new JProgressBar(0, 100);
        combineProgressBar.setStringPainted(true);
        combineProgressBar.setString("0%");
        actionPanel.add(combineProgressBar);

        lblCombineStatus = new JLabel("Ready", SwingConstants.CENTER);
        lblCombineStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblCombineStatus.setBorder(new EmptyBorder(8, 0, 0, 0));
        actionPanel.add(lblCombineStatus);

        panel.add(actionPanel, BorderLayout.CENTER);

        // Event listeners
        btnBrowseCombinePart.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Select First Part File");
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File partFile = fc.getSelectedFile();
                txtCombineFirstPart.setText(partFile.getAbsolutePath());
                String originalName = partFile.getName().replaceAll("\\.part\\d+$", "");
                File out = new File(partFile.getParentFile(),
                        originalName.equals(partFile.getName()) ? "merged_" + partFile.getName() : originalName);
                txtCombineOutputFile.setText(out.getAbsolutePath());
            }
        });

        btnBrowseCombineOutput.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Select Output Merged File Location");
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                txtCombineOutputFile.setText(fc.getSelectedFile().getAbsolutePath());
            }
        });

        btnCombine.addActionListener(e -> startCombining());

        return panel;
    }

    private void startSplitting() {
        String inputPath = txtSplitInputFile.getText().trim();
        String outDir = txtSplitOutputFolder.getText().trim();
        String numStr = txtNumParts.getText().trim();

        if (inputPath.isEmpty() || outDir.isEmpty() || numStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        File inputFile = new File(inputPath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            JOptionPane.showMessageDialog(this, "Input file does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File outputDir = new File(outDir);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        int numParts;
        try {
            numParts = Integer.parseInt(numStr);
            if (numParts <= 1) {
                JOptionPane.showMessageDialog(this, "Number of parts must be at least 2.", "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number of parts.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        setSplitUIEnabled(false);
        splitProgressBar.setValue(0);
        splitProgressBar.setString("0%");
        lblSplitStatus.setText("Splitting file into " + numParts + " parts...");

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                long totalBytes = inputFile.length();
                long partSize = totalBytes / numParts;
                long totalWritten = 0;

                byte[] buffer = new byte[64 * 1024];

                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFile))) {
                    for (int part = 1; part <= numParts; part++) {
                        File partFile = new File(outputDir, String.format("%s.part%03d", inputFile.getName(), part));
                        long currentPartBytesToRead = (part == numParts) ? (totalBytes - totalWritten) : partSize;
                        long currentPartWritten = 0;

                        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(partFile))) {
                            while (currentPartWritten < currentPartBytesToRead) {
                                int toRead = (int) Math.min(buffer.length, currentPartBytesToRead - currentPartWritten);
                                int bytesRead = in.read(buffer, 0, toRead);
                                if (bytesRead == -1)
                                    break;
                                out.write(buffer, 0, bytesRead);
                                currentPartWritten += bytesRead;
                                totalWritten += bytesRead;

                                int progress = (totalBytes > 0) ? (int) ((totalWritten * 100) / totalBytes) : 100;
                                publish(progress);

                                if (totalBytes < 5 * 1024 * 1024) {
                                    Thread.sleep(10);
                                }
                            }
                            out.flush();
                        }
                    }
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                int p = chunks.get(chunks.size() - 1);
                splitProgressBar.setValue(p);
                splitProgressBar.setString(p + "%");
                lblSplitStatus.setText("Splitting progress: " + p + "%");
            }

            @Override
            protected void done() {
                setSplitUIEnabled(true);
                try {
                    get();
                    splitProgressBar.setValue(100);
                    splitProgressBar.setString("100%");
                    lblSplitStatus.setText("File split successfully into " + numParts + " parts!");
                    JOptionPane.showMessageDialog(FileSplitterCombinerFrame.this,
                            "File split successfully into " + numParts + " parts in:\n" + outputDir.getAbsolutePath(),
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    lblSplitStatus.setText("Split failed: " + ex.getMessage());
                    JOptionPane.showMessageDialog(FileSplitterCombinerFrame.this,
                            "Failed to split file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        worker.execute();
    }

    private void startCombining() {
        String firstPartPath = txtCombineFirstPart.getText().trim();
        String outFilePath = txtCombineOutputFile.getText().trim();

        if (firstPartPath.isEmpty() || outFilePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select the first part file and destination.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        File firstPart = new File(firstPartPath);
        if (!firstPart.exists() || !firstPart.isFile()) {
            JOptionPane.showMessageDialog(this, "First part file does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File outFile = new File(outFilePath);

        // Find all contiguous part files (.part001, .part002, ...)
        String baseName = firstPart.getName().replaceAll("\\.part\\d+$", "");
        File parentDir = firstPart.getParentFile();
        List<File> parts = new ArrayList<>();
        int index = 1;
        while (true) {
            File part = new File(parentDir, String.format("%s.part%03d", baseName, index));
            if (part.exists()) {
                parts.add(part);
                index++;
            } else {
                break;
            }
        }

        if (parts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No matching part files found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        setCombineUIEnabled(false);
        combineProgressBar.setValue(0);
        combineProgressBar.setString("0%");
        lblCombineStatus.setText("Combining " + parts.size() + " parts...");

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                long totalBytes = 0;
                for (File p : parts)
                    totalBytes += p.length();
                long totalWritten = 0;

                byte[] buffer = new byte[64 * 1024];

                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {
                    for (File partFile : parts) {
                        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(partFile))) {
                            int bytesRead;
                            while ((bytesRead = in.read(buffer)) != -1) {
                                out.write(buffer, 0, bytesRead);
                                totalWritten += bytesRead;
                                int progress = (totalBytes > 0) ? (int) ((totalWritten * 100) / totalBytes) : 100;
                                publish(progress);

                                if (totalBytes < 5 * 1024 * 1024) {
                                    Thread.sleep(10);
                                }
                            }
                        }
                    }
                    out.flush();
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                int p = chunks.get(chunks.size() - 1);
                combineProgressBar.setValue(p);
                combineProgressBar.setString(p + "%");
                lblCombineStatus.setText("Combining progress: " + p + "%");
            }

            @Override
            protected void done() {
                setCombineUIEnabled(true);
                try {
                    get();
                    combineProgressBar.setValue(100);
                    combineProgressBar.setString("100%");
                    lblCombineStatus.setText("Combined " + parts.size() + " parts successfully!");
                    JOptionPane.showMessageDialog(FileSplitterCombinerFrame.this,
                            "File combined successfully:\n" + outFile.getAbsolutePath(),
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    lblCombineStatus.setText("Combine failed: " + ex.getMessage());
                    JOptionPane.showMessageDialog(FileSplitterCombinerFrame.this,
                            "Failed to combine files: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        worker.execute();
    }

    private void setSplitUIEnabled(boolean enabled) {
        btnSplit.setEnabled(enabled);
        btnBrowseSplitInput.setEnabled(enabled);
        btnBrowseSplitOutput.setEnabled(enabled);
        txtSplitInputFile.setEditable(enabled);
        txtSplitOutputFolder.setEditable(enabled);
        txtNumParts.setEditable(enabled);
    }

    private void setCombineUIEnabled(boolean enabled) {
        btnCombine.setEnabled(enabled);
        btnBrowseCombinePart.setEnabled(enabled);
        btnBrowseCombineOutput.setEnabled(enabled);
        txtCombineFirstPart.setEditable(enabled);
        txtCombineOutputFile.setEditable(enabled);
    }
}

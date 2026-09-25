package exercise5.gui;

import exercise5.util.LargeFileGenerator;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;

/**
 * Exercise 5: Simple Notepad application ("Tý tèo simple Notepad").
 * Supports opening large text files (~20MB) using multi-threading (SwingWorker)
 * so that the user interface never freezes.
 */
public class MySimpleNotepad extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JMenuBar menubar;
    private JMenu mFile, mEdit, mHelp, mTools;
    private JMenuItem itemNew, itemOpen, itemSave, itemPrint, itemExit;
    private JMenuItem itemCut, itemCopy, itemPaste;
    private JMenuItem itemAbout, itemGen20MB;

    private JTextArea tpContent;
    private JLabel lblStatus;
    private JProgressBar progressBar;

    private File currentFile = null;

    public MySimpleNotepad() {
        super("Tý tèo simple Notepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);

        initMenu();
        initComponents();
    }

    private void initMenu() {
        menubar = new JMenuBar();

        // --- File Menu ---
        mFile = new JMenu("File");
        itemNew = new JMenuItem("Tập tin mới", KeyEvent.VK_N);
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        itemOpen = new JMenuItem("Mở tập tin", KeyEvent.VK_O);
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        itemSave = new JMenuItem("Lưu tập tin", KeyEvent.VK_S);
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        itemPrint = new JMenuItem("In ra máy in", KeyEvent.VK_P);
        itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        itemExit = new JMenuItem("Thoát", KeyEvent.VK_X);
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));

        mFile.add(itemNew);
        mFile.add(itemOpen);
        mFile.add(itemSave);
        mFile.add(itemPrint);
        mFile.addSeparator();
        mFile.add(itemExit);

        // --- Edit Menu ---
        mEdit = new JMenu("Edit");
        itemCut = new JMenuItem("Cắt", KeyEvent.VK_X);
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        itemCopy = new JMenuItem("Sao chép", KeyEvent.VK_C);
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        itemPaste = new JMenuItem("Dán", KeyEvent.VK_V);
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        mEdit.add(itemCut);
        mEdit.add(itemCopy);
        mEdit.add(itemPaste);

        // --- Tools Menu (helper to test 20MB file requirement) ---
        mTools = new JMenu("Tools");
        itemGen20MB = new JMenuItem("Tạo file mẫu 20MB để test...");
        mTools.add(itemGen20MB);

        // --- Help Menu ---
        mHelp = new JMenu("Help");
        itemAbout = new JMenuItem("Giới thiệu");
        mHelp.add(itemAbout);

        menubar.add(mFile);
        menubar.add(mEdit);
        menubar.add(mTools);
        menubar.add(mHelp);
        setJMenuBar(menubar);

        // Listeners
        itemNew.addActionListener(this);
        itemOpen.addActionListener(this);
        itemSave.addActionListener(this);
        itemPrint.addActionListener(this);
        itemExit.addActionListener(this);

        itemCut.addActionListener(this);
        itemCopy.addActionListener(this);
        itemPaste.addActionListener(this);

        itemGen20MB.addActionListener(this);
        itemAbout.addActionListener(this);
    }

    private void initComponents() {
        tpContent = new JTextArea();
        tpContent.setFont(new Font("Consolas", Font.PLAIN, 14));
        tpContent.setLineWrap(false);
        JScrollPane scrollPane = new JScrollPane(tpContent);

        // Status bar panel
        JPanel statusPanel = new JPanel(new BorderLayout(5, 5));
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusPanel.setPreferredSize(new Dimension(getWidth(), 25));

        lblStatus = new JLabel(" Ready...");
        lblStatus.setFont(lblStatus.getFont().deriveFont(Font.PLAIN, 12f));

        progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(150, 18));
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);

        statusPanel.add(lblStatus, BorderLayout.CENTER);
        statusPanel.add(progressBar, BorderLayout.EAST);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(statusPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == itemNew) {
            newFile();
        } else if (src == itemOpen) {
            openFileAsync();
        } else if (src == itemSave) {
            saveFile();
        } else if (src == itemPrint) {
            printFile();
        } else if (src == itemExit) {
            System.exit(0);
        } else if (src == itemCut) {
            tpContent.cut();
        } else if (src == itemCopy) {
            tpContent.copy();
        } else if (src == itemPaste) {
            tpContent.paste();
        } else if (src == itemGen20MB) {
            generateTestFile();
        } else if (src == itemAbout) {
            JOptionPane.showMessageDialog(this,
                    "Tý tèo simple Notepad\nDistributed Programming With Java - Lab FIT IUH\nChapter 1 - Exercise 5",
                    "Giới thiệu", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void newFile() {
        tpContent.setText("");
        currentFile = null;
        setTitle("Tý tèo simple Notepad - [Untitled]");
        lblStatus.setText(" Ready...");
    }

    /**
     * Loads file using a background thread (SwingWorker)
     * Keeps GUI responsive and shows loading progress for large files (~20MB).
     */
    private void openFileAsync() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Mở tập tin");
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            loadFileInBackground(file);
        }
    }

    private void loadFileInBackground(File file) {
        long fileSize = file.length();
        lblStatus.setText(" Đang tải tập tin: " + file.getName() + " (" + formatBytes(fileSize) + ")...");
        progressBar.setValue(0);
        progressBar.setVisible(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        SwingWorker<String, Integer> worker = new SwingWorker<String, Integer>() {
            private long startTime;

            @Override
            protected String doInBackground() throws Exception {
                startTime = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder((int) Math.min(fileSize, 50 * 1024 * 1024));
                char[] buffer = new char[64 * 1024]; // 64K chars buffer
                long totalRead = 0;

                try (BufferedReader reader = new BufferedReader(new FileReader(file), 64 * 1024)) {
                    int charsRead;
                    while ((charsRead = reader.read(buffer)) != -1) {
                        sb.append(buffer, 0, charsRead);
                        totalRead += charsRead;
                        if (fileSize > 0) {
                            int progress = (int) ((totalRead * 100) / fileSize);
                            publish(Math.min(progress, 100));
                        }
                    }
                }
                return sb.toString();
            }

            @Override
            protected void process(List<Integer> chunks) {
                int latest = chunks.get(chunks.size() - 1);
                progressBar.setValue(latest);
                lblStatus.setText(String.format(" Đang tải... %d%% (%s)", latest, file.getName()));
            }

            @Override
            protected void done() {
                setCursor(Cursor.getDefaultCursor());
                progressBar.setVisible(false);
                try {
                    String content = get();
                    tpContent.setText(content);
                    tpContent.setCaretPosition(0);
                    currentFile = file;
                    long duration = System.currentTimeMillis() - startTime;
                    setTitle("Tý tèo simple Notepad - " + file.getName());
                    lblStatus.setText(String.format(" Đã tải thành công %s (%s) trong %d ms. Ready.",
                            file.getName(), formatBytes(fileSize), duration));
                } catch (Exception ex) {
                    lblStatus.setText(" Lỗi khi tải tập tin: " + ex.getMessage());
                    JOptionPane.showMessageDialog(MySimpleNotepad.this,
                            "Không thể đọc tập tin: " + ex.getMessage(),
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        worker.execute();
    }

    private void saveFile() {
        if (currentFile == null) {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Lưu tập tin");
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                currentFile = chooser.getSelectedFile();
            } else {
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
            tpContent.write(writer);
            setTitle("Tý tèo simple Notepad - " + currentFile.getName());
            lblStatus.setText(" Đã lưu: " + currentFile.getName());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu tập tin: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void printFile() {
        try {
            boolean complete = tpContent.print();
            if (complete) {
                lblStatus.setText(" Đã gửi lệnh in thành công.");
            } else {
                lblStatus.setText(" Lệnh in bị hủy.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi máy in: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateTestFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("sample_20MB.txt"));
        chooser.setDialogTitle("Chọn vị trí lưu file mẫu 20MB");
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File target = chooser.getSelectedFile();
            lblStatus.setText(" Đang tạo file 20MB...");
            progressBar.setIndeterminate(true);
            progressBar.setVisible(true);

            SwingWorker<Void, Void> genWorker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    LargeFileGenerator.generateSampleTextFile(target, 20);
                    return null;
                }

                @Override
                protected void done() {
                    progressBar.setVisible(false);
                    progressBar.setIndeterminate(false);
                    try {
                        get();
                        lblStatus.setText(" Đã tạo xong file test 20MB: " + target.getName());
                        int ans = JOptionPane.showConfirmDialog(MySimpleNotepad.this,
                                "Đã tạo thành công file test 20MB!\nBạn có muốn mở ngay bằng Notepad không?",
                                "Thành công", JOptionPane.YES_NO_OPTION);
                        if (ans == JOptionPane.YES_OPTION) {
                            loadFileInBackground(target);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(MySimpleNotepad.this,
                                "Lỗi khi tạo file: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            };
            genWorker.execute();
        }
    }

    private String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char pre = "KMGTPE".charAt(exp - 1);
        return String.format("%.1f %cB", bytes / Math.pow(1024, exp), pre);
    }
}

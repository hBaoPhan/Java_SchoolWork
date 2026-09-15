import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyNotepad extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JMenuItem newMenu;
    private JMenuItem openMenu;
    private JMenuItem saveMenu;
    private JMenuItem printMenu;
    private JMenuItem exitMenu;
    private JTextArea ta;
    private JScrollPane sc;
    private Thread thread;

    public MyNotepad() {

        setTitle("Notepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500, 300);
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(600, 400));

        JMenuBar menuBar;
        setJMenuBar(menuBar = new JMenuBar());
        JMenu fileMenu, editMenu, helpMenu;
        menuBar.add(fileMenu = new JMenu("File"));
        menuBar.add(editMenu = new JMenu("Edit"));
        menuBar.add(helpMenu = new JMenu("Help"));
        fileMenu.setMnemonic('F');
        editMenu.setMnemonic('E');
        helpMenu.setMnemonic('H');

        fileMenu.add(newMenu = new JMenuItem("New", 'N'));
        fileMenu.add(new JSeparator());
        newMenu.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        fileMenu.add(openMenu = new JMenuItem("Open", 'O'));
        openMenu.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
        fileMenu.add(saveMenu = new JMenuItem("Save", 'S'));
        saveMenu.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
        fileMenu.add(new JSeparator());
        fileMenu.add(printMenu = new JMenuItem("Print", 'P'));
        printMenu.setAccelerator(KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK));
        fileMenu.add(new JSeparator());
        fileMenu.add(exitMenu = new JMenuItem("Exit", 'E'));
        exitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));

        Container container = getContentPane();

        container.add(sc = new JScrollPane(ta = new JTextArea()));
        ta.setLineWrap(true);
        sc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel pnl;
        container.add(pnl = new JPanel(), BorderLayout.SOUTH);
        pnl.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        pnl.setLayout(new BorderLayout());
        pnl.add(new JLabel("Ready..."));

        newMenu.addActionListener(this);
        openMenu.addActionListener(this);
        saveMenu.addActionListener(this);
        printMenu.addActionListener(this);
        exitMenu.addActionListener(this);
    }

    public static void main(String[] args) {
        new MyNotepad().setVisible(true);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(exitMenu))
            System.exit(0);
        else if (o.equals(openMenu)) {

            JFileChooser fileChooser = new JFileChooser();
            File workingDirectory = new File(System.getProperty("user.dir"));
            fileChooser.setCurrentDirectory(workingDirectory);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt", "text"));
            // fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Files",
            // "txt"));
            int value = fileChooser.showOpenDialog(this);

            if (value == JFileChooser.APPROVE_OPTION) {
                File fileName = fileChooser.getSelectedFile();
                String choosing = (String) JOptionPane.showInputDialog(this, "Select your choice",
                        "Without or with thread", JOptionPane.PLAIN_MESSAGE, null,
                        new String[] { "Without thread", "With thread" }, "With thread");
                if (choosing != null) {
                    newMenu.doClick();
					if (choosing.equals("Without thread"))
						withoutThread(fileName); // small data
					else { // bigger data
						NotepadWithThreadLoader handler = new NotepadWithThreadLoader(ta, fileName);
						thread = new Thread(String.valueOf(handler));
						thread.setName("Open Thread");
						thread.start();
					}
                }
            }
        } else if (o.equals(newMenu)) {
            if (thread != null) {
                thread.stop();
                ta.setText("");
                ta.requestFocus();
            }
        }
    }
    // Byte stream: Input/Output Stream
    // Character: Reader/Writer
    // Data stream: (byte, short, int, long, float, double, char, boolean)
    // Object Stream
    // Buffered Stream
    // 1. mở luồng
    // 2. thao tác trên luồng
    // 3. đóng luồng
    // --> try-catch
    private void withoutThread(File fileName) {
        try(BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while (in.ready()){
                String line=in.readLine();
                ta.append(line+"\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

class NotepadWithThreadLoader implements Runnable{
    private final JTextArea ta;
    private final File filename;

    public NotepadWithThreadLoader(JTextArea ta, File filename) {
        super();
        this.ta = ta;
        this.filename = filename;
    }

    @Override
    public void run() {
        try(BufferedReader in = new BufferedReader(new FileReader(filename))) {
            while (in.ready()){
                String line=in.readLine();
                ta.append(line+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

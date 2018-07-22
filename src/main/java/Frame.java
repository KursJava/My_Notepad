import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Frame extends JFrame implements ActionListener {

    private String text;
    private JMenuItem nowy, open, save, close, cut, copy, paste, fullscreen, normal, about;
    private JTextArea jTextArea;
    private JMenuBar menuBar;
    private JMenu file, edit, format, view, help;
    private JMenuItem lowerCase, upperCase, fontSize, delete, time, helper, style;
    private ScrollPane scrollPane;
    private JButton jButton;
    private JCheckBox normally, bold, italic;
    private JLabel label;
    private JDialog jDialog;
    private JPopupMenu popupMenu;
    private JMenuItem jcut, jcopy, jpaste, jdelete, join;

    Frame() {
        createFrame();
        createComponent();
        createKeybordShortCut();
        createMenu();
        createPopupMenu();
        actionListner();
        setVisible(true);
    }


    private void createFrame() {
        setBounds(280, 100, 850, 500);
        setTitle(" My Notepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image image = new ImageIcon("src/main/resources/ikona.jpg").getImage();
        setIconImage(image);
    }

    private void createComponent() {
        scrollPane = new ScrollPane();
        jTextArea = new JTextArea();
        menuBar = new JMenuBar();
        file = new JMenu("Plik");
        edit = new JMenu("Edycja");
        format = new JMenu("Format");
        view = new JMenu("Widok");
        help = new JMenu("Pomoc");
        nowy = new JMenuItem("Nowy");
        open = new JMenuItem("Otwórz...");
        save = new JMenuItem("Zapisz");
        close = new JMenuItem("Zakończ");
        cut = new JMenuItem("Wytnij");
        copy = new JMenuItem("Kopiuj");
        paste = new JMenuItem("Wklej");
        delete = new JMenuItem("Usuń");
        time = new JMenuItem("Godzina/data");
        lowerCase = new JMenuItem("Małe litery");
        upperCase = new JMenuItem("Wielkie litery");
        fontSize = new JMenuItem("Rozmiar czcionki");
        style = new JMenuItem("Styl czcionki");
        fullscreen = new JMenuItem("Pełen ekran");
        normal = new JMenuItem("Widok standardowy");
        helper = new JMenuItem("Wyświetl pomoc");
        about = new JMenuItem("My Notepad-informacje");
    }

    private void createKeybordShortCut() {

        nowy.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        open.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        save.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        close.setAccelerator(KeyStroke.getKeyStroke("alt F4"));
        cut.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
        copy.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
        paste.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));
        delete.setAccelerator(KeyStroke.getKeyStroke("DELETE"));
        fullscreen.setAccelerator(KeyStroke.getKeyStroke("ctrl F"));
        normal.setAccelerator(KeyStroke.getKeyStroke("ctrl M"));
        time.setAccelerator(KeyStroke.getKeyStroke("F5"));
        about.setAccelerator(KeyStroke.getKeyStroke("F1"));
    }

    private void createMenu() {
        setJMenuBar(menuBar);
        menuBar.add(file);
        file.add(nowy);
        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(close);
        menuBar.add(edit);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(delete);
        edit.addSeparator();
        edit.add(time);
        menuBar.add(format);
        format.add(lowerCase);
        format.add(upperCase);
        format.addSeparator();
        format.add(fontSize);
        format.add(style);
        menuBar.add(view);
        view.add(normal);
        view.add(fullscreen);
        menuBar.add(help);
        help.add(helper);
        help.addSeparator();
        help.add(about);
        scrollPane.add(jTextArea);
        add(scrollPane);
    }

    private void createPopupMenu() {
        popupMenu = new JPopupMenu();
        jcut = new JMenuItem("Wytnij");
        jcopy = new JMenuItem("Kopiuj");
        jpaste = new JMenuItem("Wklej");
        jdelete = new JMenuItem("Usuń wszystko");
        join = new JMenuItem("Dołącz");


        popupMenu.add(jcut);
        popupMenu.add(jcopy);
        popupMenu.add(jpaste);
        popupMenu.add(join);
        popupMenu.addSeparator();
        popupMenu.add(jdelete);

        jTextArea.setComponentPopupMenu(popupMenu);

    }

    private void actionListner() {
        nowy.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        fullscreen.addActionListener(this);
        normal.addActionListener(this);
        lowerCase.addActionListener(this);
        upperCase.addActionListener(this);
        fontSize.addActionListener(this);
        style.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        delete.addActionListener(this);
        time.addActionListener(this);
        about.addActionListener(this);
        helper.addActionListener(this);
        close.addActionListener(this);
        jcut.addActionListener(this);
        jpaste.addActionListener(this);
        jcopy.addActionListener(this);
        jdelete.addActionListener(this);
        join.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == open) {
            textWillBeOpen();
        }
        if (source == save) {
            textWillBeSave();
        }
        if (source == close) {
            closeNotepad();
        }
        if (source == about) {
            infoNotepad();
        }
        if (source == normal) {
            normalWindows();
        }
        if (source == fullscreen) {
            fullScreen();
        }
        if (source == lowerCase) {
            textLowerCase();
        }
        if (source == upperCase) {
            textUpperCase();
        }
        if (source == cut) {
            cutText();
        }
        if (source == paste) {
            pasteText();
        }
        if (source == copy) {
            copyText();
        }
        if (source == fontSize) {
            setFontSizeText();
        }
        if (source == nowy) {

            newDocument();
        }
        if (source == delete) {
            deleteText();
        }
        if (source == time) {
            insertTime();
        }
        if (source == helper) {
            helperNotepad();
        }
        if (source == style) {
            setStyleText();
        }
        if (source == jcut) {
            cutText();
        }
        if (source == jcopy) {
            copyText();
        }
        if (source == jpaste) {
            pasteText();
        }
        if (source == jdelete) {
            deleteText();
        }
        if (source == join) {
            joinText();
        }
    }

    private void textWillBeOpen() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    jTextArea.append(scanner.nextLine() + "\n");
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void textWillBeSave() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                PrintWriter printWriter = new PrintWriter(file);
                Scanner scanner = new Scanner(jTextArea.getText());
                while (scanner.hasNext()) {
                    printWriter.println(scanner.hasNext() + "\n");
                    printWriter.close();
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void closeNotepad() {
        int message = JOptionPane.showConfirmDialog(close, "Czy napewno chcesz wyjsć z programu?"
                , "Zamknij program", JOptionPane.INFORMATION_MESSAGE);
        if (message == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    private void infoNotepad() {
        JOptionPane.showMessageDialog(about, "Alternatywa dla programu Notatnik \n" +
                        "Wersja demo: v.1.0 \n" + " Develop by Karol Sidor",
                "My Notepad-informacje", JOptionPane.INFORMATION_MESSAGE);
    }

    private void normalWindows() {
        setBounds(280, 100, 850, 500);
    }

    private void fullScreen() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int height = dimension.height;
        int width = dimension.width;
        setBounds(0, 0, width, height);
    }

    private void textLowerCase() {
        String small = jTextArea.getText();
        String lowercase = small.toLowerCase();
        jTextArea.setText(lowercase);
    }

    private void textUpperCase() {
        String large = jTextArea.getText();
        String uppercase = large.toUpperCase();
        jTextArea.setText(uppercase);
    }

    private void cutText() {
        text = jTextArea.getSelectedText();
        String actualText = jTextArea.getText();
        jTextArea.setText(null);

    }

    private void pasteText() {
        jTextArea.insert(text, jTextArea.getCaretPosition());

    }

    private void copyText() {
        text = jTextArea.getSelectedText();
    }

    private void setFontSizeText() {
        text = jTextArea.getText();
        String size = JOptionPane.showInputDialog(fontSize, "Wprowadź rozmiar czcionki");
        jTextArea.setFont(new Font("SansSerif", Font.PLAIN, Integer.parseInt(size)));
        jTextArea.setText(text);
    }

    private void newDocument() {

        int message = JOptionPane.showConfirmDialog(nowy, "Czy napewno chcesz otworzyć nowy dokument ?",
                "Nowy dokument", JOptionPane.INFORMATION_MESSAGE);

        if (message == JOptionPane.YES_OPTION) {
            Frame frame = new Frame();
        }
    }

    private void deleteText() {
        text = jTextArea.getText();
        jTextArea.setText(null);
    }

    private void insertTime() {
        text = jTextArea.getText();
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        jTextArea.setText(text + "\n " + time.toString() + "  " + date.toString());
    }

    private void helperNotepad() {
        JOptionPane.showMessageDialog(helper, "             Przepraszamy !!! \n Pomoc techniczna dla" +
                " programu \n My NotePad jest w budownie :( ", "Pomoc programu My Notepad", JOptionPane.INFORMATION_MESSAGE);
    }

    private void setStyleText() {

        label = new JLabel("Wybierz rodzaj czcionki");
        jButton = new JButton("Zatwierdź");
        normally = new JCheckBox("Normalna");
        bold = new JCheckBox("Pogrubiona");
        italic = new JCheckBox("Kursywa");

        jDialog = new JDialog();
        jDialog.setBounds(300, 200, 350, 250);
        jDialog.setTitle("Ustawienia stylu czcionki");
        jDialog.setResizable(false);
        jDialog.setLayout(null);
        jButton.setBounds(100, 150, 140, 35);
        label.setBounds(80, 10, 180, 35);
        label.setFont(new Font("SansSerif", Font.BOLD, 15));
        normally.setBounds(80, 40, 180, 35);
        bold.setBounds(80, 70, 180, 35);
        italic.setBounds(80, 100, 180, 35);
        jDialog.add(normally);
        jDialog.add(bold);
        jDialog.add(italic);
        jDialog.add(bold);
        jDialog.add(italic);
        jDialog.add(label);
        jDialog.add(jButton);
        JDialogListner();
        jDialog.setVisible(true);
    }

    private void joinText() {
        text = jTextArea.getSelectedText();
        jTextArea.insert(text + "\n", jTextArea.getCaretPosition());
    }

    private void JDialogListner() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
            }
        });
        normally.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextArea.getText();
                jTextArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
                jTextArea.setText(text);
            }
        });
        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texty = jTextArea.getText();
                jTextArea.setFont(new Font(null, Font.BOLD, 12));
                jTextArea.setText(texty);
            }
        });
        italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texts = jTextArea.getText();
                jTextArea.setFont(new Font(null, Font.ITALIC, 12));
                jTextArea.setText(texts);
            }
        });
    }


}





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

class MainFrame extends JFrame {
    public JDesktopPane desktopPane;

    public MainFrame() {
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(MainFrame.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
                    for (Component frame : desktopPane.getComponents()) {
                        if (frame instanceof StudentListPanel) {
                            ArrayList<Student> students = ((StudentListPanel) frame).getStudents();
                            outputStream.writeObject(students);
                        }
                    }
                    JOptionPane.showMessageDialog(MainFrame.this, "Data saved successfully!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(MainFrame.this, "Error saving data!");
                }
            }
        });
        fileMenu.add(saveItem);
        JMenuItem loadItem = new JMenuItem("Load");

        fileMenu.add(loadItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
}
import javax.swing.*;
import java.awt.*; // Import for layout managers
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.stream.Collectors.toList;

class StudentListPanel extends JPanel {
    private JList<Student> studentJList;
    public DefaultListModel<Student> studentListModel;
    private final String filename = "students.txt";

    public StudentListPanel() {
        studentListModel = new DefaultListModel<>();
        studentJList = new JList<>(studentListModel);
        JScrollPane scrollPane = new JScrollPane(studentJList);
        add(scrollPane);

        JButton addButton = new JButton("Add Student");
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");
        addButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter student's name:");
            String ageStr = JOptionPane.showInputDialog("Enter student's age:");
            int age = Integer.parseInt(ageStr);
            Student student = new Student(name, age);
            studentListModel.addElement(student);
        });
        add(addButton);
        add(loadButton);
        add(saveButton);
        ButtonGroup buttonGroup = new ButtonGroup();

        buttonGroup.add(addButton);
        buttonGroup.add(loadButton);
        buttonGroup.add(saveButton);

        // Panel to hold buttons with vertical layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(addButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(Box.createVerticalGlue()); // Push buttons to the top

        // Add the button panel to the right side
        setLayout(new BorderLayout()); // Use BorderLayout for the main panel
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);

        saveButton.addActionListener(e -> {
            try {
                saveGroupsToFile(filename);
                JOptionPane.showMessageDialog(null, "Student saved successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving student!");
            }
        });
        loadButton.addActionListener(e -> {
            try {
                loadGroupsFromFile(filename);
                JOptionPane.showMessageDialog(null, "Groups loaded successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error loading groups!");
            }
            });
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < studentListModel.size(); i++) {
            students.add(studentListModel.getElementAt(i));
        }
        return students;
    }

    private void saveGroupsToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < studentListModel.getSize(); i++) {
                writer.write(studentListModel.getElementAt(i).toString());
                writer.newLine();
            }
        }
    }

    // Method to load groups from a text file
    private void loadGroupsFromFile(String filename) throws IOException {
        studentListModel.clear(); // Clear existing list
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] a = line.split(",");
                String name = a[0];
                int age = Integer.parseInt(a[1]);
                studentListModel.addElement(new Student(name,age));
            }
        }
    }
}
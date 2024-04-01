import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Panel for displaying and managing a list of students.
 */
class StudentListPanel extends JPanel {
    private JList<Student> studentJList;
    public DefaultListModel<Student> studentListModel;
    private final String filename = "students.txt";

    /**
     * Constructs the student list panel.
     */
    public StudentListPanel() {
        studentListModel = new DefaultListModel<>();
        studentJList = new JList<>(studentListModel);
        JScrollPane scrollPane = new JScrollPane(studentJList);
        add(scrollPane);

        // Button for adding a student
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter student's name:");
            String ageStr = JOptionPane.showInputDialog("Enter student's age:");
            int age = Integer.parseInt(ageStr);
            Student student = new Student(name, age);
            studentListModel.addElement(student);
        });

        // Button for saving students
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try {
                saveStudentsToFile(filename);
                JOptionPane.showMessageDialog(null, "Students saved successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving students!");
            }
        });

        // Button for loading students
        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(e -> {
            try {
                loadStudentsFromFile(filename);
                JOptionPane.showMessageDialog(null, "Students loaded successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error loading students!");
            }
        });

        // Add buttons to button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(addButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(Box.createVerticalGlue()); // Push buttons to the top

        // Add the button panel to the right side using BorderLayout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
    }

    /**
     * Retrieves the list of students.
     *
     * @return the list of students
     */
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < studentListModel.size(); i++) {
            students.add(studentListModel.getElementAt(i));
        }
        return students;
    }

    /**
     * Saves the list of students to a file.
     *
     * @param filename the name of the file to save to
     * @throws IOException if an I/O error occurs while saving the file
     */
    private void saveStudentsToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < studentListModel.getSize(); i++) {
                writer.write(studentListModel.getElementAt(i).toString());
                writer.newLine();
            }
        }
    }

    /**
     * Loads the list of students from a file.
     *
     * @param filename the name of the file to load from
     * @throws IOException if an I/O error occurs while loading the file
     */
    private void loadStudentsFromFile(String filename) throws IOException {
        studentListModel.clear(); // Clear existing list
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                studentListModel.addElement(new Student(name, age));
            }
        }
    }
}
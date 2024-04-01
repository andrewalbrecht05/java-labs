import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class CourseListPanel extends JPanel {

    private JList<Course> courseJList;
    private DefaultListModel<Course> courseListModel;
    private JTextField courseNameTextField, courseDescriptionTextField, courseCreditsTextField;

    public CourseListPanel() {
        courseListModel = new DefaultListModel<>();
        courseJList = new JList<>(courseListModel);
        JScrollPane scrollPane = new JScrollPane(courseJList);
        add(scrollPane);

        // Panel for buttons and text fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Buttons
        JButton addButton = new JButton("Add");
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");

        // Add button action
        addButton.addActionListener(e -> {
            String courseName = JOptionPane.showInputDialog(null, "Enter course name:");
            String courseDescription = JOptionPane.showInputDialog(null, "Enter course description:");
            String creditsStr = JOptionPane.showInputDialog(null, "Enter course credits:");

            if (isValidCourse(courseName, courseDescription, creditsStr)) {
                int credits = Integer.parseInt(creditsStr);
                Course course = new Course(courseName, courseDescription, credits);
                courseListModel.addElement(course);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid course information! Please enter valid details.");
            }
        });

        // Save button action
        saveButton.addActionListener(e -> {
            try {
                saveCoursesToFile("courses.txt");
                JOptionPane.showMessageDialog(null, "Courses saved successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving courses!");
            }
        });

        // Load button action
        loadButton.addActionListener(e -> {
            try {
                loadCoursesFromFile("courses.txt");
                JOptionPane.showMessageDialog(null, "Courses loaded successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error loading courses!");
            }
        });
        add(addButton);
        add(loadButton);
        add(saveButton);
        // Add buttons and input panel to main panel
        add(inputPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to check for valid course details
    private boolean isValidCourse(String name, String description, String creditsStr) {
        return !name.isEmpty() && !description.isEmpty() && isInteger(creditsStr);
    }

    // Method to check if a string is an integer
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Method to clear all text fields
    private void clearTextFields() {
        courseNameTextField.setText("");
        courseDescriptionTextField.setText("");
        courseCreditsTextField.setText("");
    }

    // Method to save courses to a text file
    private void saveCoursesToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < courseListModel.getSize(); i++) {
                Course course = courseListModel.getElementAt(i);
                writer.write(course.toString());
                writer.newLine();
            }
        }
    }


    // Method to load courses from a text file
    private void loadCoursesFromFile(String filename) throws IOException {
        courseListModel.clear(); // Clear existing list
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Course course = Course.fromString(line);
                    courseListModel.addElement(course);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid course format in file: " + line);
                }
            }
        }
    }
}

// A simple 'Course' class to store course information (Make sure you have this class)


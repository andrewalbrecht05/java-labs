import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GroupListPanel extends JPanel {

    private JList<String> groupJList;
    private DefaultListModel<String> groupListModel;

    public GroupListPanel() {
        groupListModel = new DefaultListModel<>();
        groupJList = new JList<>(groupListModel);
        JScrollPane scrollPane = new JScrollPane(groupJList);
        add(scrollPane);

        // Panel for buttons and text field
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Buttons
        JButton addButton = new JButton("Add");
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");
        add(addButton);
        add(loadButton);
        add(saveButton);
        // Add button action
        addButton.addActionListener(e -> {
            String groupName = JOptionPane.showInputDialog(null, "Enter group name:");
            if (groupName != null && isValidGroupName(groupName)) { // Check for 'cancel' and validate
                groupListModel.addElement(groupName);
            } else if (groupName != null) { // Only display error if they didn't press 'cancel'
                JOptionPane.showMessageDialog(null, "Invalid group name! Please enter a valid name.");
            }
        });

        // Save button action
        saveButton.addActionListener(e -> {
            try {
                saveGroupsToFile("groups.txt");
                JOptionPane.showMessageDialog(null, "Groups saved successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving groups!");
            }
        });

        // Load button action
        loadButton.addActionListener(e -> {
            try {
                loadGroupsFromFile("groups.txt");
                JOptionPane.showMessageDialog(null, "Groups loaded successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error loading groups!");
            }
        });

        // Add buttons and input panel to main panel
        add(inputPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to check for valid group name
    private boolean isValidGroupName(String groupName) {
        return !groupName.isEmpty() && !groupName.contains(" "); // Check for non-empty and no spaces
    }

    // Method to save groups to a text file
    private void saveGroupsToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < groupListModel.getSize(); i++) {
                writer.write(groupListModel.getElementAt(i));
                writer.newLine();
            }
        }
    }

    // Method to load groups from a text file
    private void loadGroupsFromFile(String filename) throws IOException {
        groupListModel.clear(); // Clear existing list
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                groupListModel.addElement(line);
            }
        }
    }
}
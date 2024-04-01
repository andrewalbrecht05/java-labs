import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Panel for displaying and managing a list of groups.
 */
public class GroupListPanel extends JPanel {

    private JList<String> groupJList;
    private DefaultListModel<String> groupListModel;

    /**
     * Constructs the group list panel.
     */
    public GroupListPanel() {
        groupListModel = new DefaultListModel<>();
        groupJList = new JList<>(groupListModel);
        JScrollPane scrollPane = new JScrollPane(groupJList);
        add(scrollPane);
        // Buttons
        JButton addButton = new JButton("Add");
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");

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
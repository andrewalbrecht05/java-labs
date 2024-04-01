import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

/**
 * The main class that creates and displays the application's main frame and internal frames.
 */
public class Main {
    public static void main(String[] args) {
        // Create and display the main frame
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);

        // Create and display the student list internal frame
        StudentListPanel studentListPanel = new StudentListPanel();
        JInternalFrame studentInternalFrame = new JInternalFrame("Student List", true, false, true, true);
        studentInternalFrame.getContentPane().add(studentListPanel);
        studentInternalFrame.setSize(400, 300);
        studentInternalFrame.setVisible(true);
        mainFrame.desktopPane.add(studentInternalFrame);

        // Create and display the group list internal frame
        GroupListPanel groupListPanel = new GroupListPanel();
        JInternalFrame groupInternalFrame = new JInternalFrame("Group List", true, false, true, true);
        groupInternalFrame.getContentPane().add(groupListPanel);
        groupInternalFrame.setSize(400, 300);
        groupInternalFrame.setVisible(true);
        mainFrame.desktopPane.add(groupInternalFrame);

        // Create and display the course list internal frame
        CourseListPanel courseListPanel = new CourseListPanel();
        JInternalFrame courseInternalFrame = new JInternalFrame("Course List", true, false, true, true);
        courseInternalFrame.getContentPane().add(courseListPanel);
        courseInternalFrame.setSize(400, 300);
        courseInternalFrame.setVisible(true);
        mainFrame.desktopPane.add(courseInternalFrame);
    }
}

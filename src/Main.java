import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);


        StudentListPanel studentListPanel = new StudentListPanel();
        JInternalFrame studentInternalFrame = new JInternalFrame("Student List", true, false, true, true);
        studentInternalFrame.getContentPane().add(studentListPanel);
        studentInternalFrame.setSize(400, 300);
        studentInternalFrame.setVisible(true);
        mainFrame.desktopPane.add(studentInternalFrame);

        GroupListPanel groupListPanel = new GroupListPanel();
        JInternalFrame groupInternalFrame = new JInternalFrame("Group List", true, false, true, true);
        groupInternalFrame.getContentPane().add(groupListPanel);
        groupInternalFrame.setSize(400, 300);
        groupInternalFrame.setVisible(true);
        mainFrame.desktopPane.add(groupInternalFrame);

        CourseListPanel courseListPanel = new CourseListPanel();
        JInternalFrame courseInternalFrame = new JInternalFrame("Course List", true, false, true, true);
        courseInternalFrame.getContentPane().add(courseListPanel);
        courseInternalFrame.setSize(400, 300);
        courseInternalFrame.setVisible(true);
        mainFrame.desktopPane.add(courseInternalFrame);
    }
}

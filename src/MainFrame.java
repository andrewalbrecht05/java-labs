import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * The main frame of the Student Management System application.
 */
class MainFrame extends JFrame {
    /** The desktop pane where internal frames are displayed. */
    public JDesktopPane desktopPane;
    private JMenuBar menuBar;
    private JMenu helpMenu;
    private JMenuItem helpMenuItem, aboutMenuItem;

    /**
     * Constructs the main frame.
     */
    public MainFrame() {
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        menuBar = new JMenuBar();
        helpMenu = new JMenu("Help");
        helpMenuItem = new JMenuItem("Міні-довідка");
        aboutMenuItem = new JMenuItem("Інформація про автора програми");

        helpMenu.add(helpMenuItem);
        helpMenu.add(aboutMenuItem);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        helpMenuItem.addActionListener(e -> new HelpFrame().getInstance().setVisible(true));
        aboutMenuItem.addActionListener(e -> new AboutFrame().getInstance().setVisible(true));
    }
}

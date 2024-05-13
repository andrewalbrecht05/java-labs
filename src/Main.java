import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class WindowManager {

    private static WindowManager instance = null;
    private List<JFrame> windows;

    private WindowManager() {
        windows = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            JFrame window = new JFrame("Вікно " + (i + 1));
            window.setSize(300, 300);

            JLabel label = new JLabel("Вікно " + (i + 1));
            window.getContentPane().add(label);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

            for (int j = 0; j < 5; j++) {
                if (i != j) {
                    JButton button = getButton(i, j);
                    button.setSize(300, 50);
                    buttonPanel.add(button);
                }
            }

            window.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            this.windows.add(window);
        }
    }

    private static JButton getButton(int from, int to) {
        JButton button = new JButton("Перейти до вікна " + (to + 1));
        button.addActionListener(e -> WindowManager.getInstance().switchToWindow(from, to));
        return button;
    }

    public static WindowManager getInstance() {
        if (instance == null) {
            instance = new WindowManager();
        }
        return instance;
    }

    public void showWindow(int index) {
        if (index >= 0 && index < windows.size()) {
            windows.get(index).setVisible(true);
        }
    }

    public void hideWindow(int index) {
        if (index >= 0 && index < windows.size()) {
            windows.get(index).setVisible(false);
        }
    }

    public void switchToWindow(int fromIndex, int toIndex) {
        hideWindow(fromIndex);
        showWindow(toIndex);
    }
}

public class Main {
    public static void main(String[] args) {
        WindowManager windowManager = WindowManager.getInstance();
        windowManager.showWindow(0);
    }
}

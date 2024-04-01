import javax.swing.*;

/**
 * Цей клас описує GUI вікна "Інформація про автора програми".
 *
 */
class AboutFrame extends JFrame {
    private static AboutFrame aboutFrame;
    public AboutFrame() {
        setTitle("About");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextPane aboutText = new JTextPane();
        aboutText.setContentType("text/html");
        aboutText.setText("<html><h2>Про автора</h2>" +
                "Ця програма була розроблена студентом 2 курсу КН-ІНФ ФІТ Альбрехтом Андрієм.\n\n" +
                "<h2>Контактна інформація</h2>" +
                "<ul><li> Email: <a href=\"mailto:albrekht.andrii@student.uzhnu.edu.ua\">albrekht.andrii@student.uzhnu.edu.ua</a>" +
                "<li> Telegram: @andrew055</li></ul>");
        aboutText.setEditable(false);
        aboutText.setBackground(null);
        aboutText.setBorder(null);
        add(aboutText);
    }
    /**
     * Отримує екземпляр вікна "Інформація про автора програми".
     *
     * @return екземпляр вікна "Інформація про автора програми"
     */
    public AboutFrame getInstance() {
        if (aboutFrame == null) {
            aboutFrame = new AboutFrame();
        }
        return aboutFrame;
    }
}
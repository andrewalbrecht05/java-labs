import javax.swing.*;

/**
 * Цей клас описує GUI вікна "Міні-довідка".
 *
 * @author Andrii Albrecht
 */
class HelpFrame extends JFrame {
    private static HelpFrame helpFrame;

    /**
     * Конструктор класу HelpFrame.
     * Ініціалізує GUI вікна.
     */
    public HelpFrame() {
        setTitle("Help");
        setSize(700, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextPane helpText = new JTextPane();
        helpText.setContentType("text/html");
        helpText.setText("<html><h1>Довідка</h1>" +
                "<p>Даний додаток дозволяє користувачу працювати зі списками студентів, груп, курсів тощо у режимі реального часу. " +
                "Кожен список представлений у власному вікні, що дозволяє зручно організовувати робочий процес.</p>" +
                "<h2>Як користуватися</h2>" +
                "<ul><li>Запустіть додаток.</li>" +
                "<li>Відкрийте потрібне вікно для роботи зі списком.</li>" +
                "<li>Додавайте, видаляйте та редагуйте елементи списку за допомогою відповідних кнопок та опцій меню.</li>" +
                "<li>Зберігайте дані за допомогою кнопки \"Зберегти\".</li>" +
                "<li>Завантажуйте дані за допомогою кнопки \"Завантажити\".</li>" +
                "<h2>Контактна інформація</h2>" +
                "Якщо у вас виникли питання або проблеми з роботою програми, ви можете зв'язатися з автором за електронно адресою: " +
                "<a href=\"mailto:albrekht.andrii@student.uzhnu.edu.ua\">albrekht.andrii@student.uzhnu.edu.ua</a></html>");
        helpText.setEditable(false);
        helpText.setBackground(null);
        helpText.setBorder(null);
        add(helpText);
    }

    /**
     * Отримує екземпляр вікна "Довідка".
     *
     * @return екземпляр вікна "Довідка"
     */
    public HelpFrame getInstance() {
        if (helpFrame == null) {
            helpFrame = new HelpFrame();
        }
        return helpFrame;
    }
}
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
                "<p>Ця програма дозволяє вам отримати загальну інформацію про ваш знак зодіаку.</p>" +
                "<h2>Як користуватися</h2>" +
                "<ul><li>Введіть свою дату народження у форматі YYYY-MM-DD.</li>" +
                "<li>Натисніть кнопку <b>Submit</b>.</li>" +
                "<li>Перегляньте інформацію про ваш знак зодіаку.</li></ul>" +
                "<h2>Доступні функції</h2>" +
                "<ul><li>Визначення знаку зодіаку: програма визначає ваш знак зодіаку на основі введеної дати народження.</li>" +
                "<li>Відображення інформації про знак зодіаку: програма відображає загальну інформацію про ваш знак зодіаку, " +
                "включаючи його характеристики, сильні та слабкі сторони.</li>" +
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
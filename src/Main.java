import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Month;

public class Main extends JFrame {
    private JLabel nameLabel, dobLabel, resultLabel;
    private JTextField nameField, dobField;
    private JButton submitButton;
    private JMenuBar menuBar;
    private JMenu helpMenu;
    private JMenuItem helpMenuItem, aboutMenuItem;

    /**
     * Цей клас описує GUI для програми "Знак Зодіаку".
     */
    public Main() {
        setTitle("Zodiac Sign App");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    /**
     * Цей метод ініціалізує компоненти GUI.
     */
    private void initComponents() {
        menuBar = new JMenuBar();
        helpMenu = new JMenu("Help");
        helpMenuItem = new JMenuItem("Міні-довідка");
        aboutMenuItem = new JMenuItem("Інформація про автора програми");

        helpMenu.add(helpMenuItem);
        helpMenu.add(aboutMenuItem);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        setLayout(new GridLayout(4, 2, 5, 5));

        nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField();
        dobLabel = new JLabel("Enter your date of birth (YYYY-MM-DD):");
        dobField = new JTextField();
        resultLabel = new JLabel();

        submitButton = new JButton("Submit");

        add(nameLabel);
        add(nameField);
        add(dobLabel);
        add(dobField);
        add(submitButton);
        add(resultLabel);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String dobText = dobField.getText();
            try {
                LocalDate dob = LocalDate.parse(dobText);
                String zodiacSign = getZodiacSign(dob.getMonth(), dob.getDayOfMonth());
                resultLabel.setText("<html>Привіт, " + name + "! Твій знак зодіаку: " + getZodiacInfo(zodiacSign) + "<br>" + "</html>");
            } catch (Exception ex) {
                resultLabel.setText("<html>Невалідний формат. Введіть дату у форматі YYYY-MM-DD.</html>");
            }
        });

        helpMenuItem.addActionListener(e -> new HelpFrame().getInstance().setVisible(true));
        aboutMenuItem.addActionListener(e -> new AboutFrame().getInstance().setVisible(true));
    }


    /**
     * Визначає знак зодіаку за датою народження.
     *
     * @param month Місяць народження
     * @param day   День народження
     * @return Знак зодіаку
     */
    private String getZodiacSign(Month month, int day) {
        return switch (month) {
            case MARCH -> (day < 21) ? "Риби" : "Овен";
            case APRIL -> (day < 20) ? "Овен" : "Телець";
            case MAY -> (day < 21) ? "Телець" : "Близнюки";
            case JUNE -> (day < 21) ? "Близнюки" : "Рак";
            case JULY -> (day < 23) ? "Рак" : "Лев";
            case AUGUST -> (day < 23) ? "Лев" : "Діва";
            case SEPTEMBER -> (day < 23) ? "Діва" : "Терези";
            case OCTOBER -> (day < 23) ? "Терези" : "Скорпіон";
            case NOVEMBER -> (day < 22) ? "Скорпіон" : "Стрілець";
            case DECEMBER -> (day < 22) ? "Стрілець" : "Козеріг";
            case JANUARY -> (day < 20) ? "Козеріг" : "Водолій";
            case FEBRUARY -> (day < 19) ? "Водолій" : "Риби";
        };
    }

    /**
     * Надає характеристику обраного знаку зодіаку
     *
     * @param zodiacSign Знак зодіаку
     * @return Характеристика знаку зодіаку
     */
    private String getZodiacInfo(String zodiacSign) {
        // Додамо загальну інформацію про кожен знак зодіаку
        return switch (zodiacSign) {
            case "Овен" -> zodiacSign + ": Відданий і енергійний. Завжди готовий до дії.";
            case "Телець" -> zodiacSign + ": Спокійний і впевнений в собі. Любить комфорт.";
            case "Близнюки" -> zodiacSign + ": Комунікабельний і любить різноманіття. Швидко адаптується.";
            case "Рак" -> zodiacSign + ": Чутливий і зв'язаний з родиною. Має сильне емоційне сприйняття.";
            case "Лев" -> zodiacSign + ": Лідерський і впевнений. Любить бути в центрі уваги.";
            case "Діва" -> zodiacSign + ": Аналітичний і перфекціоніст. Має практичний підхід до життя.";
            case "Терези" -> zodiacSign + ": Справедливий і спокійний. Має збалансований погляд на світ.";
            case "Скорпіон" -> zodiacSign + ": Стриманий і загадковий. Має глибоку емоційну сутність.";
            case "Стрілець" -> zodiacSign + ": Позитивний і ентузіазіст. Має сильний дух дослідження.";
            case "Козеріг" -> zodiacSign + ": Амбітний і практичний. Має великі кар'єрні амбіції.";
            case "Водолій" -> zodiacSign + ": Незалежний і оригінальний. Вірить у соціальну справедливість.";
            case "Риби" -> zodiacSign + ": Інтуїтивний і емоційний. Має тенденцію до мрійництва.";
            default -> "";
        };
    }

    /**
     * Запускає програму.
     *
     * @param args Аргументи командного рядка
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}

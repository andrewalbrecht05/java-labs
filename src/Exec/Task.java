package Exec;
import java.util.Random;

/**
 * Клас Task представляє завдання, яке генерується випадковим чином.
 */
public class Task {
    /** Опис завдання. */
    private String description;

    /** Грошова винагорода за виконання завдання. */
    private int rewardMoney;

    /** Досвід, отриманий за виконання завдання. */
    private int rewardXP;

    /** Перше число у завданні. */
    private int number1;

    /** Друге число у завданні. */
    private int number2;

    /** Оператор у завданні. */
    private String operator;

    /** Правильна відповідь на завдання. */
    private int correctAnswer;

    /**
     * Конструктор класу Task.
     *
     * @param description Опис завдання.
     * @param rewardMoney Грошова винагорода за виконання завдання.
     * @param rewardXP Досвід, отриманий за виконання завдання.
     */
    public Task(String description, int rewardMoney, int rewardXP) {
        this.description = description;
        this.rewardMoney = rewardMoney;
        this.rewardXP = rewardXP;
        generateRandomTask(); // Генеруємо випадкове завдання
    }

    /**
     * Метод для генерації випадкового завдання.
     * Встановлює значення чисел, оператора та правильної відповіді.
     */
    private void generateRandomTask() {
        Random random = new Random();
        number1 = random.nextInt(10) + 1;
        number2 = random.nextInt(10) + 1;
        int operatorChoice = random.nextInt(4);

        // Вибираємо випадковий оператор
        switch (operatorChoice) {
            case 0:
                operator = "+";
                correctAnswer = number1 + number2;
                break;
            case 1:
                operator = "-";
                correctAnswer = number1 - number2;
                break;
            case 2:
                operator = "*";
                correctAnswer = number1 * number2;
                break;
            case 3:
                operator = "/";
                if (number2 == 0)
                    number2 = 1;
                correctAnswer = number1 / number2;
                break;
        }
    }

    /**
     * Метод для отримання опису завдання.
     *
     * @return Опис завдання у вигляді рядка.
     */
    public String getDescription() {
        return description + " " + number1 + " " + operator + " " + number2 + " = ?";
    }

    /**
     * Метод для отримання грошової винагороди.
     *
     * @return Грошова винагорода за виконання завдання.
     */
    public int getRewardMoney() {
        return rewardMoney;
    }

    /**
     * Метод для отримання досвіду.
     *
     * @return Досвід, отриманий за виконання завдання.
     */
    public int getRewardXP() {
        return rewardXP;
    }

    /**
     * Метод для перевірки відповіді користувача.
     *
     * @param choice Відповідь користувача.
     * @return {@code true}, якщо відповідь вірна, {@code false} - в іншому випадку.
     */
    public boolean checkAnswer(int choice) {
        return choice == correctAnswer;
    }
}

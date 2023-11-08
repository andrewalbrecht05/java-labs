import java.util.Random;

// Клас Task представляє завдання, яке генерується випадковим чином.
class Task {
    private String description; // Опис завдання
    private int rewardMoney; // Грошова винагорода за виконання завдання
    private int rewardXP; // Досвід, отриманий за виконання завдання
    private int number1; // Перше число у завданні
    private int number2; // Друге число у завданні
    private String operator; // Оператор у завданні
    private int correctAnswer; // Правильна відповідь на завдання

    // Конструктор класу Task
    public Task(String description, int rewardMoney, int rewardXP) {
        this.description = description;
        this.rewardMoney = rewardMoney;
        this.rewardXP = rewardXP;
        generateRandomTask(); // Генеруємо випадкове завдання
    }

    // Метод для генерації випадкового завдання
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
                if( number2 == 0 )
                    number2 = 1;
                correctAnswer = number1 / number2;
                break;
        }
    }

    // Метод для отримання опису завдання
    public String getDescription() {
        return description + " " + number1 + " " + operator + " " + number2 + " = ?";
    }

    // Метод для отримання грошової винагороди
    public int getRewardMoney() {
        return rewardMoney;
    }

    // Метод для отримання досвіду
    public int getRewardXP() {
        return rewardXP;
    }

    // Метод для перевірки відповіді користувача
    public boolean checkAnswer(int choice) {
        return choice == correctAnswer;
    }
}

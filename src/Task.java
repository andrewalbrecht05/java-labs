import java.util.Random;

class Task {
    private String description;
    private int rewardMoney;
    private int rewardXP;
    private int number1;
    private int number2;
    private String operator;
    private int correctAnswer;

    public Task(String description, int rewardMoney, int rewardXP) {
        this.description = description;
        this.rewardMoney = rewardMoney;
        this.rewardXP = rewardXP;
        generateRandomTask();
    }

    private void generateRandomTask() {
        Random random = new Random();
        number1 = random.nextInt(10) + 1;
        number2 = random.nextInt(10) + 1;
        int operatorChoice = random.nextInt(4);

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

    public String getDescription() {
        return description + " " + number1 + " " + operator + " " + number2 + " = ?";
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public int getRewardXP() {
        return rewardXP;
    }

    public boolean checkAnswer(int choice) {
        return choice == correctAnswer;
    }
}

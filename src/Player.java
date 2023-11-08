public class Player {
    private int money; // Гроші гравця
    private int xp; // Досвід гравця
    private int xpAmplifier = 1; // Підсилювач досвіду гравця

    // Конструктор класу Player
    public Player() {
        money = 0;
        xp = 0;
    }

    // Метод для отримання грошей гравця
    public int getMoney() {
        return money;
    }

    // Метод для отримання досвіду гравця
    public int getXP() {
        return xp;
    }

    // Метод для збільшення грошей гравця
    public void increaseMoney(int amount) {
        money += amount;
    }

    // Метод для збільшення досвіду гравця
    public void increaseXP(int amount) {
        xp += amount * xpAmplifier;
    }

    // Метод для купівлі додаткового досвіду
    public void buyXP() {
        if (money >= 10) {
            money -= 10;
            increaseXP(5);
            System.out.println("Ви купили додаткові очки досвіду (+5 XP) за 10 золота.");
        } else {
            System.out.println("У вас недостатньо золота для покупки додаткових очок досвіду.");
        }
    }

    // Метод для купівлі підсилювача досвіду
    public void buyXPAmplifier() {
        if (money >= 20) {
            money -= 20;
            xpAmplifier *= 2;
            System.out.println("Ви купили підсилювач XP за 20 золота.");
        } else {
            System.out.println("У вас недостатньо золота для покупки підсилювача XP.");
        }
    }
}

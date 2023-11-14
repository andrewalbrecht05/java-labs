package Exec;
/**
 * Клас, що представляє гравця гри.
 */
public class Player {
    /** Гроші гравця. */
    private int money;

    /** Досвід гравця. */
    private int xp;

    /** Підсилювач досвіду гравця. */
    private int xpAmplifier = 1;

    /**
     * Конструктор класу Player.
     * Ініціалізує гроші та досвід гравця.
     */
    public Player() {
        money = 0;
        xp = 0;
    }

    /**
     * Метод для отримання грошей гравця.
     *
     * @return Кількість грошей гравця.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Метод для отримання досвіду гравця.
     *
     * @return Кількість досвіду гравця.
     */
    public int getXP() {
        return xp;
    }

    /**
     * Метод для збільшення грошей гравця.
     *
     * @param amount Кількість грошей для збільшення.
     */
    public void increaseMoney(int amount) {
        money += amount;
    }

    /**
     * Метод для збільшення досвіду гравця.
     *
     * @param amount Кількість досвіду для збільшення.
     */
    public void increaseXP(int amount) {
        xp += amount * xpAmplifier;
    }

    /**
     * Метод для купівлі додаткового досвіду.
     * Зменшує гроші гравця та збільшує досвід.
     */
    public void buyXP() {
        if (money >= 10) {
            money -= 10;
            increaseXP(5);
            System.out.println("Ви купили додаткові очки досвіду (+5 XP) за 10 золота.");
        } else {
            System.out.println("У вас недостатньо золота для покупки додаткових очок досвіду.");
        }
    }

    /**
     * Метод для купівлі підсилювача досвіду.
     * Зменшує гроші гравця та збільшує підсилювач досвіду.
     */
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


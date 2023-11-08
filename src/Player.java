public class Player {
    private int money;
    private int xp;
    private int xpAmplifier = 1;

    public Player() {
        money = 0;
        xp = 0;
    }

    public int getMoney() {
        return money;
    }

    public int getXP() {
        return xp;
    }

    public void increaseMoney(int amount) {
        money += amount;
    }

    public void increaseXP(int amount) {
        xp += amount * xpAmplifier;
    }

    public void buyXP() {
        if (money >= 10) {
            money -= 10;
            increaseXP(5);
            System.out.println("Ви купили додаткові очки досвіду (+5 XP) за 10 золота.");
        } else {
            System.out.println("У вас недостатньо золота для покупки додаткових очок досвіду.");
        }
    }

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


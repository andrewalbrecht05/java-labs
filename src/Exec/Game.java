package Exec;
import java.util.Scanner;

/**
 * Клас Game представляє гру RPG.
 */
public class Game {
    /** Гравець у грі. */
    private Player player;

    /** Поточний рівень у грі. */
    private Level level;

    /**
     * Конструктор класу Game.
     * Створює нового гравця та починає гру з першого рівня.
     */
    public Game() {
        player = new Player();
        level = new Level(1);
    }

    /**
     * Метод для початку гри.
     * Виводить початкові повідомлення та керує основним циклом гри.
     */
    public void start() {
        System.out.println("Ласкаво просимо до гри RPG!");
        System.out.println("Ваша мета - завершити всі завдання та досягти останнього рівня.");
        while (true) {
            System.out.println("Поточний рівень: " + level.getCurrentLevel());
            System.out.println("Золото гравця: " + player.getMoney());
            System.out.println("Очки досвіду гравця: " + player.getXP());
            Task task = level.generateTask();
            System.out.println("Завдання: " + task.getDescription());
            System.out.print("Введіть правильну відповідь: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            boolean result = task.checkAnswer(choice);
            if (result) {
                System.out.println("Ви виконали завдання успішно!");
                player.increaseMoney(task.getRewardMoney());
                player.increaseXP(task.getRewardXP());
                if (level.isCompleted()) {
                    System.out.println("Вітаємо! Ви завершили всі рівні гри!");
                    break;
                }
                level.advance();
            } else {
                System.out.println("Ви не виконали завдання. Спробуйте ще раз.");
            }
            System.out.print("Бажаєте купити додаткові очки досвіду (1) або підсилювач XP (2)? (0, щоб пропустити): ");
            int purchaseChoice = scanner.nextInt();
            if (purchaseChoice == 1) {
                player.buyXP();
            } else if (purchaseChoice == 2) {
                player.buyXPAmplifier();
            }
        }
    }
}

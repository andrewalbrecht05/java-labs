import java.util.Scanner;

// Клас Game представляє гру RPG.
public class Game {
    private Player player; // Гравець у грі
    private Level level; // Поточний рівень у грі

    // Конструктор класу Game
    public Game()
    {
        player = new Player(); // Створюємо нового гравця
        level = new Level(1); // Починаємо з першого рівня
    }

    // Метод для початку гри
    public void start() {
        System.out.println("Ласкаво просимо до гри RPG!");
        System.out.println("Ваша мета - завершити всі завдання та досягти останнього рівня.");
        while (true) {
            System.out.println("Поточний рівень: " + level.getCurrentLevel());
            System.out.println("Золото гравця: " + player.getMoney());
            System.out.println("Очки досвіду гравця: " + player.getXP());
            Task task = level.generateTask(); // Генеруємо нове завдання
            System.out.println("Завдання: " + task.getDescription());
            System.out.print("Введіть правильну відповідь: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            boolean result = task.checkAnswer(choice); // Перевіряємо відповідь гравця
            if (result) {
                System.out.println("Ви виконали завдання успішно!");
                player.increaseMoney(task.getRewardMoney()); // Нагороджуємо гравця грошима
                player.increaseXP(task.getRewardXP()); // Нагороджуємо гравця досвідом
                if (level.isCompleted()) {
                    System.out.println("Вітаємо! Ви завершили всі рівні гри!");
                    break;
                }
                level.advance(); // Переходимо на наступний рівень
            } else {
                System.out.println("Ви не виконали завдання. Спробуйте ще раз.");
            }
            System.out.print("Бажаєте купити додаткові очки досвіду (1) або підсилювач XP (2)? (0, щоб пропустити): ");
            int purchaseChoice = scanner.nextInt();
            if (purchaseChoice == 1) {
                player.buyXP(); // Гравець купує додаткові очки досвіду
            } else if (purchaseChoice == 2) {
                player.buyXPAmplifier(); // Гравець купує підсилювач XP
            }
        }
    }
}

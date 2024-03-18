import java.util.Random;
import java.util.Scanner;

/**
 * Клас, що реалізує гру "Вгадай число".
 */
public class GuessingGame {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    private int randomNumber;
    private int remainingAttempts;
    private boolean isGameOver;
    private static Scanner scanner;

    /**
     * Конструктор класу {@code GuessingGame}.
     * Ініціалізує випадкове число, кількість спроб та сканер для введення користувача.
     */
    public GuessingGame() {
        randomNumber = generateRandomNumber();
        remainingAttempts = 10;
        isGameOver = false;
        scanner = new Scanner(System.in);
    }

    /**
     * Метод для початку гри.
     * Користувач може вводити свої догадки, доки гра не закінчиться.
     */
    public void playGame() {
        Player player = new Player();
        class HintGenerator {
            private int guess;
            private int randomNumber;

            /**
             * Конструктор для генератора підказок.
             *
             * @param guess        догадка користувача
             * @param randomNumber випадкове число, яке потрібно вгадати
             */
            public HintGenerator(int guess, int randomNumber) {
                this.guess = guess;
                this.randomNumber = randomNumber;
            }

            /**
             * Генерує підказку для користувача на основі його догадки.
             *
             * @return підказка для користувача
             */
            public String generateHint() {
                if (guess > randomNumber) {
                    return "Ваше число занадто велике. Спробуйте менше.";
                } else {
                    return "Ваше число занадто маленьке. Спробуйте більше.";
                }
            }
        }
        while (!isGameOver) {
            System.out.println("Введіть число від " + MIN_VALUE + " до " + MAX_VALUE + ":");
            int guess = player.getGuess();

            if (guess == randomNumber) {
                printWinner(player);
                break;
            } else {
                remainingAttempts--;
                System.out.println("Неправильно! Залишилось " + remainingAttempts + " спроб.");
                if (remainingAttempts == 0) {
                    System.out.println("Ви програли! Загадуване число було " + randomNumber);
                    isGameOver = true;
                } else {
                    HintGenerator hintGenerator = new HintGenerator(guess, randomNumber);
                    String hint = hintGenerator.generateHint();
                    System.out.println(hint);
                }
            }
        }
    }

    /**
     * Інтерфейс для виведення результату гри.
     */
    interface PrinterOut {
        void print(Player player);
    }

    /**
     * Друкуються вітання переможцю.
     *
     * @param player переможець гри
     */
    private void printWinner(Player player) {
        PrinterOut printer = new PrinterOut() {
            public void print(Player player) {
                System.out.println("Вітаємо, " + player.getName() + "! Ви виграли!");
            }
        };

        printer.print(player);
    }

    /**
     * Генерує випадкове число в межах заданого діапазону.
     *
     * @return випадкове число
     */
    private static int generateRandomNumber() {
        return Utils.getRandomNumber(MIN_VALUE, MAX_VALUE);
    }

    /**
     * Клас, що представляє гравця в грі.
     */
    private static class Player {
        private String name;
        private int guess;

        /**
         * Конструктор класу {@code Player}.
         * Запитує ім'я користувача.
         */
        public Player() {
            System.out.println("Введіть ваше ім'я:");
            name = scanner.nextLine();
        }

        /**
         * Отримує догадку користувача.
         *
         * @return догадка користувача
         */
        public int getGuess() {
            try {
                guess = Integer.parseInt(scanner.nextLine());
                if (guess < MIN_VALUE || guess > MAX_VALUE) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Невірний формат числа! Спробуйте ще раз.");
                guess = getGuess();
            }
            return guess;
        }

        /**
         * Повертає ім'я гравця.
         *
         * @return ім'я гравця
         */
        public String getName() {
            return name;
        }
    }

    /**
     * Утилітарний клас з допоміжними методами.
     */
    private static class Utils {

        private static final Random random = new Random();

        /**
         * Генерує випадкове число в межах заданого діапазону.
         *
         * @param min мінімальне значення діапазону
         * @param max максимальне значення діапазону
         * @return випадкове число
         */
        public static int getRandomNumber(int min, int max) {
            return random.nextInt(max - min + 1) + min;
        }
    }
}
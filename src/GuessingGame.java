import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    private int randomNumber;
    private int remainingAttempts;
    private boolean isGameOver;
    private static Scanner scanner;

    public GuessingGame() {
        randomNumber = generateRandomNumber();
        remainingAttempts = 10;
        isGameOver = false;
        scanner = new Scanner(System.in);
    }

    public void playGame() {
        Player player = new Player();
        class HintGenerator {
            private int guess;
            private int randomNumber;

            public HintGenerator(int guess, int randomNumber) {
                this.guess = guess;
                this.randomNumber = randomNumber;
            }

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

    interface PrinterOut {
        void print(Player player);
    }

    private void printWinner(Player player) {
        PrinterOut printer = new PrinterOut() {
            public void print(Player player) {
                System.out.println("Вітаємо, " + player.getName() + "! Ви виграли!");
            }
        };

        printer.print(player);
    }

    private static int generateRandomNumber() {
        return Utils.getRandomNumber(MIN_VALUE, MAX_VALUE);
    }

    private static class Player {
        private String name;
        private int guess;

        public Player() {
            System.out.println("Введіть ваше ім'я:");
            name = scanner.nextLine();
        }

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

        public String getName() {
            return name;
        }
    }

    private static class Utils {

        private static final Random random = new Random();

        public static int getRandomNumber(int min, int max) {
            return random.nextInt(max - min + 1) + min;
        }
    }
}
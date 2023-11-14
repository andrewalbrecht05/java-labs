package Source;
import Exec.*;
import java.util.Scanner;

/**
 * Клас Main є точкою входу для запуску гри.
 */
public class Main {
    /**
     * Головний метод, що викликається при запуску програми.
     *
     * @param args Масив аргументів командного рядка.
     */
    public static void main(String[] args) {
        // Ініціалізація гри
        Game game = new Game();
        game.start(); // запуск гри
    }
}

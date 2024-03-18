/**
 * Головний клас програми, що запускає гру "Вгадай число".
 */
public class Main {
    /**
     * Головний метод програми.
     * Створює екземпляр гри та запускає її.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.playGame();
    }
}

/**
 * Виключення, яке кидається, коли спроба зберегти об'єкт у вже зайнятій комірці схову.
 */
public class CellOccupiedException extends Exception {

    /**
     * Конструктор, який приймає повідомлення про помилку.
     *
     * @param message повідомлення про помилку
     */
    public CellOccupiedException(String message) {
        super(message);
    }
}

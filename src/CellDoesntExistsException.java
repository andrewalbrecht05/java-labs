/**
 * Виключення, яке кидається, коли спроба отримати комірку схову за неіснуючими координатами.
 */
public class CellDoesntExistsException extends Exception {

    /**
     * Конструктор, який приймає повідомлення про помилку.
     *
     * @param message повідомлення про помилку
     */
    public CellDoesntExistsException(String message) {
        super(message);
    }
}

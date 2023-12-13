import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Клас Main відповідає за взаємодію з користувачем.
 */
public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);
        // Додати список дозволених речей
        List<String> allowedItems = Arrays.asList("сумка", "коробка", "куртка", "ложка");
        System.out.println("Якщо бажаєте зупинити программу, введіть -1");
        while (true) {
            // Запросити у користувача, що він хоче зробити
            System.out.println("Що ви хочете зробити?\n1. Записати річ\n2. Переглянути вміст комірки");
            int choice = scanner.nextInt();
            if (choice == -1) {
                break;
            }

            if (choice == 1) {
                System.out.println("Введіть номер рядка комірки: ");
                int row = scanner.nextInt();
                System.out.println("Введіть номер стовпця комірки: ");
                int column = scanner.nextInt();
                // Запросити у користувача дані про речі, які він хоче зберегти
                System.out.println("Введіть назву речі: ");
                String itemName = scanner.next();

                // Перевірити, чи дозволена річ
                if (!allowedItems.contains(itemName)) {
                    System.out.println("Ця річ не дозволена");
                    continue;
                }

                // Зберегти річ у комірку
                try {
                    storage.store(row, column, itemName);
                    System.out.println("Предмет успішно збережений");
                } catch (CellDoesntExistsException | CellOccupiedException e) {
                    System.out.println("Помилка зберігання комірки!");
                }
            } else if (choice == 2) {
                System.out.println("Введіть номер рядка комірки: ");
                int row = scanner.nextInt();
                System.out.println("Введіть номер стовпця комірки: ");
                int column = scanner.nextInt();
                // Отримати вміст комірки
                try {
                    Object content = storage.getCell(row, column).getContent();
                    if (content == null) {
                        System.out.println("Комірка порожня");
                    } else {
                        System.out.println("Вміст комірки: " + content);
                    }
                } catch (CellDoesntExistsException e) {
                    System.out.println("Комірка не існує");
                }
            } else {
                System.out.println("Неправильний вибір");
            }
        }
    }
}

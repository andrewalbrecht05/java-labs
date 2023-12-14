import java.util.Scanner;

/**
 * Основна точка входу до програми.
 */
public class Main {

    /**
     * Створює об'єкт класу `Contacts` і запускає цикл, який дозволяє користувачеві вибрати дію.
     *
     * @param args - аргументи командного рядка.
     */
    public static void main(String[] args) {
        Contacts contacts = new Contacts();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Виберіть дію:");
            System.out.println("1. Додати контакт");
            System.out.println("2. Видалити контакт");
            System.out.println("3. Список контактів");
            System.out.println("4. Вихід");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введіть ім'я:");
                    String name = scanner.next();
                    System.out.println("Введіть номер телефону:");
                    String phoneNumber = scanner.next();
                    System.out.println("Введіть дату народження:");
                    String birthday = scanner.next();
                    contacts.addContact(new Contact(name, phoneNumber, birthday));
                    break;

                case 2:
                    System.out.println("Введіть ім'я контакту, який потрібно видалити:");
                    name = scanner.next();
                    contacts.deleteContact(name);
                    break;

                case 3:
                    contacts.listContacts();
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Невірний номер!");
            }
        }
    }
}

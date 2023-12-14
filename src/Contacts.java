import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Представляє список контактів зі збереженням та завантаженням з файлу.
 *
 */
public class Contacts {

    /**
     * Шлях до файлу, в якому зберігаються контакти.
     */
    private static final String FILENAME = "contacts.txt";

    /**
     * Список контактів.
     */
    private final ArrayList<Contact> contacts = new ArrayList<>();

    /**
     * Конструктор, який завантажує контакти з файлу.
     */
    public Contacts() {
        loadContacts();
    }

    /**
     * Додає контакт до списку та зберігає його у файл.
     *
     * @param contact - контакт, який потрібно додати.
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
        saveContacts();
    }

    /**
     * Видаляє контакт зі списку та зберігає зміни у файл.
     *
     * @param name - ім'я контакту, який потрібно видалити.
     */
    public void deleteContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
                saveContacts();
                return;
            }
        }
        System.out.println("Такого контакту не знайдено!");
    }

    /**
     * Виводить список усіх контактів на консоль у форматі таблиці.
     */
    public void listContacts() {
        System.out.println("----Ім'я----||----Номер телефону----||----День народження----");
        for (Contact contact : contacts) {
            String name = contact.getName();
            String phoneNumber = contact.getPhoneNumber();
            String birthday = contact.getBirthday();

            // Вирівнювання даних у таблиці
            System.out.print(name);
            for (int i = 0; i < 14 - name.length(); i++)
                System.out.print(" ");

            System.out.print(phoneNumber);
            for (int i = 0; i < 24 - phoneNumber.length(); i++)
                System.out.print(" ");
            System.out.println(birthday);
        }
    }

    /**
     * Завантажує контакти з файлу у список.
     */
    private void loadContacts() {
        try {
            Scanner scanner = new Scanner(new File(FILENAME));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                contacts.add(new Contact(parts[0], parts[1], parts[2]));
            }
            System.out.println("Список контактів збережено.");
        } catch (FileNotFoundException e) {
            System.out.println("Ще не було записано жодного контакту!");
        }
    }

    /**
     * Зберігає список контактів у файл.
     */
    private void saveContacts() {
        try {
            FileWriter writer = new FileWriter(FILENAME);
            for (Contact contact : contacts) {
                writer.write(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getBirthday() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Сталася помилка у збереженні контактів! " +
                    "Перевірте цілісність файлу та правильність записаних даних!");
        }
    }
}

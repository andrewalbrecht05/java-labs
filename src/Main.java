import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Клас, який демонструє обробку введених користувачем чи згенерованих випадковим чином чисел та їхнє виведення в зворотньому порядку.
 */
public class Main {

    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка (не використовуються в даному випадку)
     */
    public static void main(String[] args) {
        // Запитати в користувача число
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть число: ");
        int count = scanner.nextInt();

        System.out.println("Чи бажаєте ви зчитувати числа (0 - ні, 1 - так)");
        int choice = scanner.nextInt();

        // Створити список чисел
        ArrayList<Integer> numbers = new ArrayList<>();
        if (choice == 0) {
            for (int i = 0; i < count; i++) {
                int x = (int) (Math.random() * 100);
                numbers.add(x);
            }
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println("Введіть число " + (i + 1) + ": ");
                int x = scanner.nextInt();
                numbers.add(x);
            }
        }

        // Вивести початковий масив
        System.out.println("Початковий масив: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        // Відобразити числа в зворотньому порядку
        Collections.reverse(numbers);
        System.out.println("Масив у зворотньому порядку: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}

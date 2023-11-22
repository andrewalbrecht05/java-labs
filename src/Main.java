import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Animal> animals = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // Згенерувати меню
        System.out.println("Виберіть дію:");
        System.out.println("1. Створити тварину");
        System.out.println("2. Вивести інформацію про тварину");
        System.out.println("3. Видалити тварину");
        System.out.println("4. Отримати довідку");
        System.out.println("5. Вийти");

        // Ведення діалогу з користувачем
        while (true) {
            // Отримати вибір користувача
            System.out.print("Введіть номер дії: ");
            int choice = Integer.parseInt(sc.nextLine());

            // Виконати дію, вибрану користувачем
            switch (choice) {
                case 1:
                    createAnimal();
                    break;
                case 2:
                    printAnimal();
                    break;
                case 3:
                    deleteAnimal();
                    break;
                case 4:
                    printAnimalTypes();
                    break;
                case 5:
                    System.out.println("Програма завершена.");
                    return;
            }
        }
    }
    private static void printAnimalTypes() {
        System.out.println("Тип тварини | Опис");
        System.out.println("------------- | -------------");
        System.out.println("1. Ссавець | Їсть рослинну або тваринну їжу, народжує живих дитинчат");
        System.out.println("2. Птах | Їсть насіння, комах або фрукти, кладе яйця");
        System.out.println("3. Риба | Їсть дрібних тварин і рослини, має плавники і луску");
        System.out.println("4. Земноводне | Їсть безхребетних і дрібних хребетних, може жити на суші і в воді");
        System.out.println("5. Рептилія | Їсть безхребетних, дрібних хребетних і рослини, має луску");
    }
    // Метод для створення тварини
    private static void createAnimal() {

        // Отримати тип тварини
        // Ввести дані про тварину
        System.out.print("Введіть ім'я тварини: ");
        String animalName = sc.nextLine();
        System.out.print("Введіть вік тварини: ");
        int animalAge = Integer.parseInt(sc.nextLine());
        System.out.print("Введіть середовище проживання тварини: ");
        String animalHabitat = sc.nextLine();
        System.out.print("Введіть тип тварини: ");
        int animalType = Integer.parseInt(sc.nextLine());
        // Створити об'єкт тварини
        Animal animal = null;
        switch (animalType) {
            case 1:
                System.out.println("Введіть, чи є у ссавця хутро: (0 якщо не має)");
                boolean hasFur = (0 != Integer.parseInt(sc.nextLine()));
                animal = new Mammal(animalName,animalAge,animalHabitat,hasFur);
                break;
            case 2:
                System.out.println("Введіть колір крил птаха: ");
                String wingsColor = sc.nextLine();
                animal = new Bird(animalName,animalAge,animalHabitat,wingsColor);
                break;
            case 3:
                System.out.println("Введіть к-ть плавників риби: ");
                int finsCount = Integer.parseInt(sc.nextLine());
                animal = new Fish(animalName,animalAge,animalHabitat,finsCount);
                break;
            case 4:
                System.out.println("Введіть, чи може амфібія жити на суші: (0 якщо не може, 1 якщо може)");
                boolean canLiveOnLand = (0 != Integer.parseInt(sc.nextLine()));
                animal = new Amphibian(animalName,animalAge,animalHabitat,canLiveOnLand);
                break;
            case 5:
                System.out.println("Введіть колір луски рептилії: ");
                String scalesColor = sc.nextLine();
                animal = new Reptile(animalName,animalAge,animalHabitat,scalesColor);
                break;
        }
        // Додати тварину до списку
        animals.add(animal);

        // Вивести повідомлення про успішне створення тварини
        System.out.println("Тварина створена!");
    }

    // Метод для виведення інформації про тварину
    private static void printAnimal() {
        // Отримати номер тварини, яку потрібно вивести
        System.out.print("Введіть номер тварини, про яку потрібно вивести інформацію: ");
        int animalNumber = Integer.parseInt(sc.nextLine()) - 1;
        if( !animals.contains(animalNumber) )
        {
            System.out.println("Такого номеру тварини ще не існує!");
            return;
        }
        // Вивести інформацію про тварину
        System.out.println("Ім'я: " + animals.get(animalNumber).getName());
        System.out.println("Вік: " + animals.get(animalNumber).getAge());
        System.out.println("Середовище проживання: " + animals.get(animalNumber).getHabitat());
        animals.get(animalNumber).eat();
        animals.get(animalNumber).reproduce();
    }

    // Метод для видалення тварини
    private static void deleteAnimal() {
        // Отримати номер тварини, яку потрібно видалити
        System.out.print("Введіть номер тварини, яку потрібно видалити: ");
        int animalNumber = Integer.parseInt(sc.nextLine()) - 1;
        if( !animals.contains(animalNumber) )
        {
            System.out.println("Такого номеру тварини ще не існує!");
            return;
        }
        // Видалити тварину зі списку
        animals.remove(animalNumber);

        // Вивести повідомлення про успішне видалення тварини
        System.out.println("Тварина видалена!");
    }
}

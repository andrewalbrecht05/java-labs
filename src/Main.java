import Instruments.IMInstrument;
import Instruments.Piano;
import Instruments.Synthesizer;
import Instruments.Violin;

import java.util.Scanner;

/**
 * Головний клас програми, який взаємодіє з користувачем та обробляє введені команди.
 */
public class Main {
    /**
     * Виводить інформацію про доступні опції та музичні інструменти.
     */
    static public void get_help() {
        System.out.println("Доступні опції:");
        System.out.println("1. Додати новий музичний інструмент");
        System.out.println("2. Послухати гру музиканта");
        System.out.println("3. Допомога");
        System.out.println("4. Створити нового музиканта");
        System.out.println("5. Вийти");
        System.out.println("Доступні музичні інструменти:\n\tСкрипка(1)\n\tФортепіано(2)\n\tСинтезатор(3)");
    }

    /**
     * Обробляє введений інструмент, додаючи його до музиканта, якщо він ще не вміє грати на цьому інструменті.
     *
     * @param musician   Музикант, якому додається інструмент.
     * @param instrument Обраний музичний інструмент.
     */
    static public void process(Musician musician, IMInstrument instrument) {
        if (!musician.contains(instrument)) {
            System.out.println("Музикант успішно опанував гру на фортепіано!");
            musician.addInstrument(instrument);
        } else {
            System.out.println("Музикант вже вміє грати на цьому інструменті!");
        }
        //System.out.println(musician.size());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Musician musician = new Musician();
        get_help();

        while (true) {
            String input = sc.nextLine();
            label:
            switch (input) {
                case "1":
                    System.out.println("Оберіть музичний інструмент для музиканта: ");
                    input = sc.nextLine();

                    IMInstrument instrument;
                    switch (input) {
                        case "1":
                            instrument = new Violin();
                            break;
                        case "2":
                            instrument = new Piano();
                            break;
                        case "3":
                            instrument = new Synthesizer();
                            break;
                        default:
                            System.out.println("Невірно введені дані!. Інструмент не обрано!");
                            break label;
                    }
                    process(musician, instrument);
                    break;
                case "2":
                    System.out.println("Музикант починає грати...");
                    musician.playInstruments();
                    break;
                case "3":
                    get_help();
                    break;
                case "4":
                    musician = new Musician();
                    System.out.println("Успішно створено нового музиканта!");
                    break;
                case "5":
                    System.out.println("Вихід з програми...");
                    return;
                default:
                    System.out.println("Неправильно введені дані!. " +
                            "Спробуйте ще раз.");
            }
        }

    }
}

/**
 * Клас Mammal є підкласом класу Animal і представляє будь-яку ссавцеву тварину.
 * Він містить додаткове поле hasFur, яке вказує, чи має тварина хутро.
 * Також він перевизначає методи eat() та reproduce(), щоб реалізувати поведінку, характерну для ссавців.
 */
public class Mammal extends Animal {

    /**
     * Чи має тварина хутро
     */
    public boolean hasFur;

    /**
     * Конструктор класу Mammal, який створює новий об'єкт Mammal з вказаними ім'ям, віком, середовищем існування та наявністю хутра.
     *
     * @param name ім'я тварини
     * @param age вік тварини
     * @param habitat середовище існування тварини
     * @param hasFur чи має тварина хутро
     */
    public Mammal(String name, int age, String habitat, boolean hasFur) {
        super(name, age, habitat);
        this.hasFur = hasFur;
    }

    /**
     * Реалізація методу eat() для ссавців.
     * Ссавці можуть їсти як рослинну, так і тваринну їжу.
     */
    @Override
    public void eat() {
        System.out.println("Їсть рослинну або тваринну їжу");
    }

    /**
     * Реалізація методу reproduce() для ссавців.
     * Ссавці розмножуються статевим шляхом.
     */
    @Override
    public void reproduce() {
        System.out.println("Розмножується статевим шляхом");
    }
}

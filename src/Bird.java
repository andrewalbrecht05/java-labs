/**
 * Клас Bird є підкласом класу Animal і представляє будь-яку пташину.
 * Він містить додаткове поле wingsColor, яке вказує на колір крил птаха.
 * Також він перевизначає методи eat() та reproduce(), щоб реалізувати поведінку, характерну для птахів.
 */
public class Bird extends Animal {

    /**
     * Колір крил птаха
     */
    private String wingsColor;

    /**
     * Конструктор класу Bird, який створює новий об'єкт Bird з вказаними ім'ям, віком, середовищем існування та кольором крил.
     *
     * @param name ім'я птаха
     * @param age вік птаха
     * @param habitat середовище існування птаха
     * @param wingsColor колір крил птаха
     */
    public Bird(String name, int age, String habitat, String wingsColor) {
        super(name, age, habitat);
        this.wingsColor = wingsColor;
    }

    /**
     * Метод getWingsColor() повертає колір крил птаха.
     *
     * @return колір крил птаха
     */
    public String getWingsColor() {
        return wingsColor;
    }

    /**
     * Реалізація методу eat() для птахів.
     * Птахи можуть їсти насіння, комах або фрукти.
     */
    @Override
    public void eat() {
        System.out.println("Їсть насіння, комах або фрукти");
    }

    /**
     * Реалізація методу reproduce() для птахів.
     * Птахи розмножуються кладкою яєць.
     */
    @Override
    public void reproduce() {
        System.out.println("Розмножується кладкою яєць");
    }
}

/**
 * Клас Reptile є підкласом класу Animal і представляє будь-яку рептилію.
 * Він містить додаткове поле scalesColor, яке вказує на колір луски рептилії.
 * Також він перевизначає методи eat() та reproduce(), щоб реалізувати поведінку, характерну для рептилій.
 */
public class Reptile extends Animal {

    /**
     * Колір луски рептилії
     */
    private String scalesColor;

    /**
     * Конструктор класу Reptile, який створює новий об'єкт Reptile з вказаними ім'ям, віком, середовищем існування та кольором луски.
     *
     * @param name ім'я рептилії
     * @param age вік рептилії
     * @param habitat середовище існування рептилії
     * @param scalesColor колір луски рептилії
     */
    public Reptile(String name, int age, String habitat, String scalesColor) {
        super(name, age, habitat);
        this.scalesColor = scalesColor;
    }

    /**
     * Метод getScalesColor() повертає колір луски рептилії.
     *
     * @return колір луски рептилії
     */
    public String getScalesColor() {
        return scalesColor;
    }

    /**
     * Реалізація методу eat() для рептилій.
     * Рептилії їдять безхребетних, дрібних хребетних і рослини.
     */
    @Override
    public void eat() {
        System.out.println("Їсть безхребетних, дрібних хребетних і рослини");
    }

    /**
     * Реалізація методу reproduce() для рептилій.
     * Рептилії розмножуються яйцеживородінням.
     */
    @Override
    public void reproduce() {
        System.out.println("Розмножується яйцеживородінням");
    }
}

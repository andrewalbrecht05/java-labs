/**
 * Клас Fish є підкласом класу Animal і представляє будь-яку рибу.
 * Він містить додаткове поле finsCount, яке вказує на кількість плавців риби.
 * Також він перевизначає методи eat() та reproduce(), щоб реалізувати поведінку, характерну для риб.
 */
public class Fish extends Animal {

    /**
     * Кількість плавців риби
     */
    private int finsCount;

    /**
     * Конструктор класу Fish, який створює новий об'єкт Fish з вказаними ім'ям, віком, середовищем існування та кількістю плавців.
     *
     * @param name ім'я риби
     * @param age вік риби
     * @param habitat середовище існування риби
     * @param finsCount кількість плавців риби
     */
    public Fish(String name, int age, String habitat, int finsCount) {
        super(name, age, habitat);
        this.finsCount = finsCount;
    }

    /**
     * Метод getFinsCount() повертає кількість плавців риби.
     *
     * @return кількість плавців риби
     */
    public int getFinsCount() {
        return finsCount;
    }

    /**
     * Реалізація методу eat() для риб.
     * Риби їдять дрібних морських створінь і водорості.
     */
    @Override
    public void eat() {
        System.out.println("Їсть дрібних морських створінь і водорості");
    }

    /**
     * Реалізація методу reproduce() для риб.
     * Риби розмножуються відкладанням ікри.
     */
    @Override
    public void reproduce() {
        System.out.println("Розмножується відкладанням ікри");
    }
}

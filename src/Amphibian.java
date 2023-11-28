/**
 * Клас Amphibian є підкласом класу Animal і представляє будь-яку земноводне тварину.
 * Він містить додаткове поле canLiveOnLand, яке вказує, чи може тварина жити на суші.
 * Також він перевизначає методи eat() та reproduce(), щоб реалізувати поведінку, характерну для земноводних.
 */
public class Amphibian extends Animal {

    /**
     * Чи може тварина жити на суші
     */
    public boolean canLiveOnLand;

    /**
     * Конструктор класу Amphibian, який створює новий об'єкт Amphibian з вказаними ім'ям, віком, середовищем існування та здатністю жити на суші.
     *
     * @param name ім'я тварини
     * @param age вік тварини
     * @param habitat середовище існування тварини
     * @param canLiveOnLand чи може тварина жити на суші
     */
    public Amphibian(String name, int age, String habitat, boolean canLiveOnLand) {
        super(name, age, habitat);
        this.canLiveOnLand = canLiveOnLand;
    }

    /**
     * Реалізація методу eat() для земноводних.
     * Земноводні їдять безхребетних і дрібних хребетних.
     */
    @Override
    public void eat() {
        System.out.println("Їсть безхребетних і дрібних хребетних");
    }

    /**
     * Реалізація методу reproduce() для земноводних.
     * Земноводні розмножуються яйцеживородінням.
     */
    @Override
    public void reproduce() {
        System.out.println("Розмножується яйцеживородінням");
    }
}

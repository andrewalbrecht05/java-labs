/**
 * Абстрактний клас Animal представляє будь-яку істоту в царстві тварин.
 * Він містить поля для зберігання імені, віку та середовища існування тварини.
 * Також він містить абстрактні методи eat() та reproduce(), які повинні бути реалізовані в підкласах.
 */
public abstract class Animal {

    /**
     * Ім'я тварини
     */
    private String name;

    /**
     * Вік тварини
     */
    private int age;

    /**
     * Середовище існування тварини
     */
    private String habitat;

    /**
     * Конструктор класу Animal, який створює новий об'єкт Animal з вказаними ім'ям, віком та середовищем існування.
     *
     * @param name ім'я тварини
     * @param age вік тварини
     * @param habitat середовище існування тварини
     */
    public Animal(String name, int age, String habitat) {
        this.name = name;
        this.age = age;
        this.habitat = habitat;
    }

    /**
     * Отримання імені тварини
     *
     * @return ім'я тварини
     */
    public String getName() {
        return name;
    }

    /**
     * Установка імені тварини
     *
     * @param name нове ім'я тварини
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Отримання віку тварини
     *
     * @return вік тварини
     */
    public int getAge() {
        return age;
    }

    /**
     * Установка віку тварини
     *
     * @param age новий вік тварини
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Отримання середовища існування тварини
     *
     * @return середовище існування тварини
     */
    public String getHabitat() {
        return habitat;
    }

    /**
     * Установка середовища існування тварини
     *
     * @param habitat нове середовище існування тварини
     */
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    /**
     * Абстрактний метод eat(), який повинен бути реалізований у підкласах для виводу чим харчується тварина.
     */
    public abstract void eat();

    /**
     * Абстрактний метод reproduce(), який повинен бути реалізований у підкласах для виводу типу розмноження тварини.
     */
    public abstract void reproduce();
}

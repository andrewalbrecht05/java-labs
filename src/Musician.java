import Instruments.IMInstrument;

import java.util.HashMap;

/**
 * Клас, що представляє музиканта, який може грати на різних музичних інструментах.
 */
public class Musician implements IMusician{
    private final HashMap<String, IMInstrument> instruments;

    /**
     * Конструктор класу. Ініціалізує колекцію для зберігання музичних інструментів.
     */
    public Musician() {
        this.instruments = new HashMap<>();
    }

    /**
     * Додає музичний інструмент до колекції інструментів музиканта.
     *
     * @param instrument Новий музичний інструмент.
     */
    @Override
    public void addInstrument(IMInstrument instrument) {
        instruments.put(instrument.getClass().getName(),instrument);
    }

    /**
     * Повертає кількість музичних інструментів, якими володіє музикант.
     *
     * @return Кількість музичних інструментів.
     */
    public int size() {
        return instruments.size();
    }

    /**
     * Перевіряє, чи музикант володіє певним музичним інструментом.
     *
     * @param instrument Обраний музичний інструмент.
     * @return true, якщо музикант володіє цим інструментом, false - інакше.
     */
    public boolean contains(IMInstrument instrument) {
        return instruments.containsKey(instrument.getClass().getName());
    }

    /**
     * Відтворює звук усіх музичних інструментів, якими володіє музикант.
     * Якщо музикант не має інструментів, виводить повідомлення про це.
     */
    @Override
    public void playInstruments() {
        if (instruments.isEmpty()) {
            System.out.println("Музикант не вміє грати...");
        } else {
            for (IMInstrument instrument : instruments.values()) {
                instrument.play();
            }
        }
    }
}

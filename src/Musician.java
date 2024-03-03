import java.util.HashSet;

/**
 * Клас, що представляє музиканта, який може грати на різних музичних інструментах.
 */
public class Musician {
    private HashSet<IMInstrument> instruments;

    /**
     * Конструктор класу. Ініціалізує колекцію для зберігання музичних інструментів.
     */
    public Musician() {
        this.instruments = new HashSet<>();
    }

    /**
     * Додає музичний інструмент до колекції інструментів музиканта.
     *
     * @param instrument Новий музичний інструмент.
     * @return true, якщо інструмент доданий успішно, false - якщо він вже існує у колекції.
     */
    public boolean addInstrument(IMInstrument instrument) {
        return instruments.add(instrument);
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
        return instruments.contains(instrument);
    }

    /**
     * Відтворює звук усіх музичних інструментів, якими володіє музикант.
     * Якщо музикант не має інструментів, виводить повідомлення про це.
     */
    public void playInstruments() {
        if (instruments.isEmpty()) {
            System.out.println("Музикант не вміє грати...");
        } else {
            for (IMInstrument instrument : instruments) {
                instrument.play();
            }
        }
    }
}

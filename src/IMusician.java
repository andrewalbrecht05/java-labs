import Instruments.IMInstrument;

/**
 * Інтерфейс, який представляє музиканта.
 */
public interface IMusician {

    /**
     * Відтворює звук усіх музичних інструментів, якими володіє музикант.
     * Якщо музикант не має інструментів, виводить повідомлення про це.
     */
    void playInstruments();

    /**
     * Додає музичний інструмент до колекції інструментів музиканта.
     */
    void addInstrument(IMInstrument instrument);
}

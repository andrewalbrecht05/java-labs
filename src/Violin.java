/**
 * Клас, що представляє скрипку як музичний інструмент.
 */
public class Violin implements IMInstrument {

    /**
     * Реалізація методу для відтворення звуку скрипки.
     * Виводить повідомлення про те, що скрипка грає.
     */
    @Override
    public void play() {
        System.out.println("Грає скрипка...");
    }
}
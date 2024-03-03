/**
 * Клас, що представляє синтезатор як музичний інструмент.
 */
public class Synthesizer implements IMInstrument {

    /**
     * Реалізація методу для відтворення звуку синтезатора.
     * Виводить повідомлення про те, що синтезатор грає.
     */
    @Override
    public void play() {
        System.out.println("Грає синтезатор...");
    }
}
package Exec;
/**
 * Клас, що представляє рівень гри.
 */
public class Level {
    /** Поточний рівень. */
    private int currentLevel;

    /** Прапорець, що вказує, чи завершено рівень. */
    private boolean completed;

    /**
     * Конструктор класу Level.
     *
     * @param currentLevel Початковий рівень.
     */
    public Level(int currentLevel) {
        this.currentLevel = currentLevel;
        completed = false; // Рівень не завершено за замовчуванням
    }

    /**
     * Метод для отримання поточного рівня.
     *
     * @return Поточний рівень.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Метод для переходу на наступний рівень.
     */
    public void advance() {
        currentLevel++;
        completed = false; // Рівень не завершено після переходу на новий рівень
    }

    /**
     * Метод для перевірки, чи завершено рівень.
     *
     * @return {@code true}, якщо рівень завершено, {@code false} - в іншому випадку.
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Метод для генерації завдання.
     *
     * @return Створене завдання.
     */
    public Task generateTask() {
        return new Task("Виконайте операцію", 20, 10);
    }
}


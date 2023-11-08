public class Level {
    private int currentLevel; // Поточний рівень
    private boolean completed; // Чи завершено рівень

    // Конструктор класу Level
    public Level(int currentLevel) {
        this.currentLevel = currentLevel;
        completed = false; // Рівень не завершено за замовчуванням
    }

    // Метод для отримання поточного рівня
    public int getCurrentLevel() {
        return currentLevel;
    }

    // Метод для переходу на наступний рівень
    public void advance() {
        currentLevel++;
        completed = false; // Рівень не завершено після переходу на новий рівень
    }

    // Метод для перевірки, чи завершено рівень
    public boolean isCompleted() {
        return completed;
    }

    // Метод для генерації завдання
    public Task generateTask() {
        return new Task("Виконайте операцію", 20, 10);
    }
}

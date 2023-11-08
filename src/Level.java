public class Level {
    private int currentLevel;
    private boolean completed;

    public Level(int currentLevel) {
        this.currentLevel = currentLevel;
        completed = false;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void advance() {
        currentLevel++;
        completed = false;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Task generateTask() {
        return new Task("Виконайте операцію", 20, 10);
    }
}
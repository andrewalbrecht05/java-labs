/**
 * Клас Storage представляє камеру схову з 150 комірками. Комірки нумеруються згідно рядка та стовпчика (наприклад 1-2 перший ряд другий стовпчик).
 */
public class Storage {

    /**
     * Масив комірок схову.
     */
    private final Cell[] cells;

    /**
     * Конструктор, який створює камеру схову з 150 комірок.
     */
    public Storage() {
        this.cells = new Cell[150];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(i / 10, i % 10);
        }
    }

    /**
     * Отримання комірки схову за заданими координатами.
     *
     * @param row рядок комірки (від 0 до 14)
     * @param column стовпчик комірки (від 0 до 9)
     * @return комірка схову
     * @throws CellDoesntExistsException якщо комірки з такими координатами не існує
     */
    public Cell getCell(int row, int column) throws CellDoesntExistsException {
        if (row < 0 || row >= 15 || column < 0 || column >= 10) {
            throw new CellDoesntExistsException("Не існує комірки з такими координатами");
        }
        return cells[row * 10 + column];
    }

    /**
     * Зберігає об'єкт у комірці схову за заданими координатами.
     *
     * @param row рядок комірки (від 0 до 14)
     * @param column стовпчик комірки (від 0 до 9)
     * @param content об'єкт, який потрібно зберегти
     * @throws CellOccupiedException якщо комірка вже зайнята
     * @throws CellDoesntExistsException якщо комірки з такими координатами не існує
     */
    public void store(int row, int column, Object content) throws CellOccupiedException, CellDoesntExistsException {
        Cell cell = getCell(row, column);
        if (cell.getContent() != null) {
            throw new CellOccupiedException("Комірка вже зайнята");
        }
        cell.setContent(content);
    }

}

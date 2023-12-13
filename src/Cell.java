/**
 * Клас Cell представляє одиничну комірку схову. Комірка має ряд, стовпчик та вміст (об'єкт).
 */
public class Cell {

    /**
     * Рядок комірки (від 0 до 14)
     */
    private int row;

    /**
     * Стовпчик комірки (від 0 до 9)
     */
    private int column;

    /**
     * Вміст комірки (будь-який об'єкт)
     */
    private Object content;

    /**
     * Конструктор, який створює комірку з заданими рядом та стовпчиком. Вміст комірки при створенні встановлюється на null.
     *
     * @param row рядок комірки (від 0 до 14)
     * @param column стовпчик комірки (від 0 до 9)
     */
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.content = null;
    }

    /**
     * Отримання рядка комірки.
     *
     * @return рядок комірки
     */
    public int getRow() {
        return row;
    }

    /**
     * Зміна рядка комірки. Не рекомендується змінювати рядок після створення комірки.
     *
     * @param row новий рядок комірки
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Отримання стовпчика комірки.
     *
     * @return стовпчик комірки
     */
    public int getColumn() {
        return column;
    }

    /**
     * Зміна стовпчика комірки. Не рекомендується змінювати стовпчик після створення комірки.
     *
     * @param column новий стовпчик комірки
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Отримання вмісту комірки.
     *
     * @return вміст комірки (може бути будь-яким об'єктом)
     */
    public Object getContent() {
        return content;
    }

    /**
     * Зберігає об'єкт у комірці.
     *
     * @param content об'єкт, який потрібно зберегти
     */
    public void setContent(Object content) {
        this.content = content;
    }

}

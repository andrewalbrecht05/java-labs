/**
 * Представлення одного контакта в книзі контактів.
 */
public class Contact {

    /**
     * Ім'я контакта.
     */
    private final String name;

    /**
     * Номер телефону контакта.
     */
    private final String phoneNumber;

    /**
     * День народження контакта у форматі 'dd.mm.yyyy'.
     */
    private final String birthday;

    /**
     * Створює новий контакт з заданими ім'ям, номером телефону та днем народження.
     *
     * @param name - ім'я контакта.
     * @param phoneNumber - номер телефону контакта.
     * @param birthday - день народження контакта у форматі 'dd.mm.yyyy'.
     */
    public Contact(String name, String phoneNumber, String birthday) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    /**
     * Повертає ім'я контакта.
     *
     * @return ім'я контакта.
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає номер телефону контакта.
     *
     * @return номер телефону контакта.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Повертає день народження контакта.
     *
     * @return день народження контакта.
     */
    public String getBirthday() {
        return birthday;
    }
}

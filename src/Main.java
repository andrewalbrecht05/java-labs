import java.io.*;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Main {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_task_17";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";
    private static final String EXPORT_FILE_PATH = "export.txt";
    private static final String regex
            = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
    private static final Pattern pattern = Pattern.compile(regex);


    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            while (running) {
                get_help();
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        addContact(connection, scanner);
                        break;
                    case "2":
                        editContact(connection, scanner);
                        break;
                    case "3":
                        deleteContact(connection, scanner);
                        break;
                    case "4":
                        displayContacts(connection);
                        break;
                    case "5":
                        importContacts(connection);
                        break;
                    case "6":
                        exportContacts(connection);
                        break;
                    case "7":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void get_help() {
        System.out.println("Phone Directory Menu:");
        System.out.println("1. Add a contact");
        System.out.println("2. Edit a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Show all contacts");
        System.out.println("5. Import data from the file");
        System.out.println("6. Export data to the file");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static boolean isPhoneNumberValid(String phoneNumber) {
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private static void addContact(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        if (name.isBlank()) {
            System.out.println("Contact name is invalid! Try again.");
            return;
        }

        System.out.print("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();
        if (!isPhoneNumberValid(phoneNumber)) {
            System.out.println("Phone number is not valid! Try again.");
            return;
        }

        String sql = "INSERT INTO contacts (name, phone_number) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.executeUpdate();
            System.out.println("Contact added successfully.");
        }
    }

    private static void editContact(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter ID of the contact to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String phoneNumber = scanner.nextLine();
        String sql = "UPDATE contacts SET name = ?, phone_number = ? WHERE id = ?";

        if ( name.isBlank() && phoneNumber.isBlank() ) {
            System.out.println("You must change at least one field! Try again.");
            return;
        } else if ( name.isBlank() ) {
            sql = sql.replace("name = ?,", "");
        }
        else if ( phoneNumber.isBlank() ) {
            sql = sql.replace(", phone_number = ?", "");
        }
        else if( !isPhoneNumberValid(phoneNumber) ) {
            System.out.println("Phone number is not valid! Try again.");
            return;
        }
        System.out.println(sql);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int k = 1;
            if (!name.isBlank()) {
                statement.setString(k, name);
                k++;
            }
            if (!phoneNumber.isBlank()) {
                statement.setString(k, phoneNumber);
                k++;
            }
            statement.setInt(k, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("No contact found with ID " + id);
            }
        }
    }

    private static void displayContacts(Connection connection) throws SQLException {
        String sql = "SELECT * FROM contacts";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            System.out.println("+----+----------------------+----------------------+");
            System.out.println("| ID |         Name         |     Phone Number     |");
            System.out.println("+----+----------------------+----------------------+");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");

                System.out.format("| %2d | %-20s | %-20s |\n", id, name, phoneNumber);
            }

            System.out.println("+----+----------------------+----------------------+");
        }
    }

    private static void deleteContact(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter ID of the contact to delete: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM contacts WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("No contact found with ID " + id);
            }
        }
    }
    private static void exportContacts(Connection connection) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(EXPORT_FILE_PATH))) {
            String sql = "SELECT name, phone_number FROM contacts";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String phoneNumber = resultSet.getString("phone_number");
                    writer.println(name + "," + phoneNumber);
                }
            }
            System.out.println("Contacts exported to " + EXPORT_FILE_PATH);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void importContacts(Connection connection) {
        try (Scanner fileScanner = new Scanner(new File(EXPORT_FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if( parts.length != 2 ) {
                    System.out.println("Expected 2 elements in line, found " + parts.length);
                    return;
                }
                String name = parts[0].trim();
                String phoneNumber = parts[1].trim();

                if (!contactExists(connection, name, phoneNumber)) {
                    addContactToDatabase(connection, name, phoneNumber);
                }
            }
            System.out.println("Contacts imported from " + EXPORT_FILE_PATH);
        } catch (FileNotFoundException | SQLException e) {
            System.out.println("Error during importing contacts from the file! Try again.");
        }
    }

    private static boolean contactExists(Connection connection, String name, String phoneNumber) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM contacts WHERE name = ? AND phone_number = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                return resultSet.getInt("count") > 0;
            }
        }
    }

    private static void addContactToDatabase(Connection connection, String name, String phoneNumber) throws SQLException {
        String sql = "INSERT INTO contacts (name, phone_number) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.executeUpdate();
        }
    }
}

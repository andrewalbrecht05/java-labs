package com.example.task_19;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainUtils {
    private static final String regex = "\\+\\d{12}";
    private static final Pattern pattern = Pattern.compile(regex);

    public static void addContact(Connection connection) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add contact");

        TextField a = new TextField("");
        TextField b = new TextField("");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.addRow(0, new Label("Name:"), a);
        grid.addRow(1, new Label("Phone Number:"), b );

        dialog.getDialogPane().setContent(grid);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                String nameField = a.getText();
                String phoneNumberField = b.getText();

                if (nameField.isBlank()) {
                    errAlert("Contact name is invalid! Try again.");
                    return null;
                }

                if (!isPhoneNumberValid(phoneNumberField)) {
                    errAlert("Phone number is not valid! Try again.");
                    return null;
                }

                return new Pair<>(nameField, phoneNumberField);
            }

            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();


        result.ifPresent(pair -> {
            System.out.println("Name: " + pair.getKey());
            System.out.println("Phone Number: " + pair.getValue());
            String name = pair.getKey();
            String phoneNumber = pair.getValue();

            String sql = "INSERT INTO contacts (name, phone_number) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, phoneNumber);
                statement.executeUpdate();
                System.out.println("Contact added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void editContact(Connection connection, Model model) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Edit contact");

        TextField a = new TextField(model.getName());
        TextField b = new TextField(model.getNumber());

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.addRow(0, new Label("Name:"), a);
        grid.addRow(1, new Label("Phone Number:"), b );

        dialog.getDialogPane().setContent(grid);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                String nameField = a.getText();
                String phoneNumberField = b.getText();

                if (nameField.isBlank()) {
                    errAlert("Contact name is invalid! Try again.");
                    return null;
                }

                if (!isPhoneNumberValid(phoneNumberField)) {
                    errAlert("Phone number is not valid! Try again.");
                    return null;
                }

                return new Pair<>(nameField, phoneNumberField);
            }

            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();


        result.ifPresent(pair -> {
            System.out.println("Name: " + pair.getKey());
            System.out.println("Phone Number: " + pair.getValue());
            String name = pair.getKey();
            String phoneNumber = pair.getValue();

            String sql = "UPDATE contacts SET name = ?, phone_number = ? WHERE id = ?";
            System.out.println("UPDATE: " + sql);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, phoneNumber);
                statement.setInt(3, model.getId());
                statement.executeUpdate();
                System.out.println("Contact changed successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void deleteContact(Connection connection, Model model) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Delete contact");

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        dialog.setContentText("Are you sure you want to delete this contact?");

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                String sql = "DELETE FROM contacts WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, model.getId());
                    statement.executeUpdate();
                    System.out.println("Contact deleted successfully.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return null;
        });
        dialog.showAndWait();
    }

    public static void clearAll(Connection connection) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Delete contact");

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        dialog.setContentText("Are you sure you want to delete all contacts? This can't be undone!");

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                String sql = "DELETE FROM contacts";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.executeUpdate();
                    System.out.println("Contact deleted successfully.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return null;
        });
        dialog.showAndWait();
    }

    public static List<Model> getPageFromDB(Connection connection, int offset, Optional<String> filter) {
        String inject = "";
        if( filter.isPresent()) {
            inject += "WHERE id::text LIKE '" + filter.get() + "'\n";
            inject += "OR name::text LIKE '" + filter.get() + "'\n";
            inject += "OR phone_number::text LIKE '" + filter.get() + "'\n";
        }

        String sql = "SELECT * FROM contacts " + inject + "ORDER BY id " + "OFFSET " + offset + " LIMIT 6";
        System.out.println(sql);
        List<Model> list = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                list.add(new Model(id,name,phoneNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void errAlert(String errText ) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(errText);
        alert.showAndWait();
    }

    private static boolean isPhoneNumberValid(String phoneNumber) {
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}

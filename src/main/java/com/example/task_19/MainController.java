package com.example.task_19;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Math.max;

public class MainController implements Initializable {
    private final Connection connection = DBConfig.connection;
    public ObservableList<Model> ObservableList = FXCollections.observableArrayList();

    public TableView<Model> TableView;
    public TableColumn<Model, Integer> IdColumn;
    public TableColumn<Model, String> NameColumn;
    public TableColumn<Model, String> PhoneColumn;
    public int curPage = 1;
    public TextField searchField;

    @FXML
    public void onAboutAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About author");
        alert.setContentText("About");
        alert.showAndWait();
    }

    @FXML
    public void onImportAction(ActionEvent actionEvent) {
    }

    @FXML
    public void onExportAction(ActionEvent actionEvent) {
    }

    @FXML
    public void onAddButtonClick(MouseEvent mouseEvent) {
        Platform.runLater(() -> {
            MainUtils.addContact(connection);
            refreshTableView();
        });
    }

    @FXML
    public void onEditButtonClick(MouseEvent mouseEvent) {
        Model model = TableView.getSelectionModel().getSelectedItem();
        if (model == null) {
            MainUtils.errAlert("You must select an item from the table! Try again.");
            return;
        }
        Platform.runLater(() -> {
            MainUtils.editContact(connection, model);
            refreshTableView();
        });
    }

    @FXML
    public void onDeleteButtonClick(MouseEvent mouseEvent) {
        Model model = TableView.getSelectionModel().getSelectedItem();
        if (model == null) {
            MainUtils.errAlert("You must select an item from the table! Try again.");
            return;
        }
        Platform.runLater(() -> {
            MainUtils.deleteContact(connection, model);
            refreshTableView();
        });
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.L) {
            curPage += 1;
            refreshTableView();
            System.out.println("KEY LEFT PRESSED");
        } else if (keyEvent.getCode() == KeyCode.H) {
            curPage = max(curPage-1,1);
            refreshTableView();
            System.out.println("KEY LEFT PRESSED");
        }

    }
    @FXML
    public void onClearAllButtonClick() {
        Platform.runLater(() -> {
            MainUtils.clearAll(connection);
            refreshTableView();
        });
    }

    private void initializeTableView() {
        IdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        PhoneColumn.setCellValueFactory(new PropertyValueFactory<>("Number"));
        refreshTableView();
        TableView.setItems(ObservableList);
    }

    private void refreshTableView() {
        ObservableList.setAll(MainUtils.getPageFromDB(connection, (curPage-1)*6, Optional.empty()));
    }
    private void refreshTableView(String filter) {
        ObservableList.setAll(MainUtils.getPageFromDB(connection, (curPage-1)*6, Optional.of(filter)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTableView();

        searchField.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.isBlank()) {
                    System.out.println("BLANK");
                    refreshTableView();
                    return;
                }
                System.out.println(observable + ", " + oldValue + ", " + newValue);
                refreshTableView(newValue);
            }
        });
    }

    public void onInputChanged(InputMethodEvent inputMethodEvent) {
        System.out.println("onInputChanged");
        String inputText = searchField.getText();
        refreshTableView(inputText);
    }
}

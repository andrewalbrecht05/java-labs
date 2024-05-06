package com.example.lab_18;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloController {
    @FXML
    public TextField fileFormat;
    @FXML
    public Button chooseDirButton;
    public Label selectedDir;

    private String absolutePath;
    private final int MAX_THREADS = 100;

    private CopyOnWriteArrayList<File> foundFiles = new CopyOnWriteArrayList<>();
    private ExecutorService threadPool;

    public void onSearchButtonClick(MouseEvent mouseEvent) {
        if (absolutePath == null || absolutePath.isEmpty()) {
            showAlert("Warning", "Absolute path is not set");
            return;
        }
        if (fileFormat.getText() == null || fileFormat.getText().isEmpty()) {
            showAlert("Warning", "File format is not set");
            return;
        }

        String format = fileFormat.getText();
        File rootDir = new File(absolutePath);

        foundFiles.clear();

        threadPool = Executors.newFixedThreadPool(MAX_THREADS);

        searchFiles(rootDir, format);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Found Files");
        alert.setHeaderText("Files found with the specified format:");

        StringBuilder fileList = new StringBuilder();
        for (File file : foundFiles) {
            fileList.append(file.getAbsolutePath()).append("\n");
        }

        alert.setContentText(fileList.toString());
        alert.showAndWait();

        System.out.println("Found files:");
        for (File file : foundFiles) {
            System.out.println(file.getAbsolutePath());
        }

    }

    private void searchFiles(File dir, String format) {
        File[] files = dir.listFiles();

        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                threadPool.submit(() -> searchFiles(file, format));
                //searchFiles(file,format);
            } else if (file.getName().endsWith(format)) {
                foundFiles.add(file);
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        //alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void onChooseDirButtonClick(MouseEvent mouseEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(((Node) mouseEvent.getSource()).getScene().getWindow());
        if (selectedDirectory != null) {
            absolutePath = selectedDirectory.getAbsolutePath();
            selectedDir.setText("Selected directory: " + absolutePath);
        }
    }
}
package com.example.lab_18;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.concurrent.*;

import org.apache.commons.io.FilenameUtils;


public class HelloController {
    @FXML
    public TextField fileFormat;
    @FXML
    public Button chooseDirButton;
    @FXML
    public Label selectedDir;

    private String absolutePath;
    private final int MAX_THREADS = 1000;

    private CopyOnWriteArrayList<File> foundFiles = new CopyOnWriteArrayList<>();

    public void onSearchButtonClick(MouseEvent mouseEvent) {
        if (absolutePath == null || absolutePath.isEmpty()) {
            showAlert("Absolute path is not set");
            return;
        }
        if (fileFormat.getText() == null || fileFormat.getText().isEmpty()) {
            showAlert("File format is not set");
            return;
        }

        String format = fileFormat.getText();
        File rootDir = new File(absolutePath);

        foundFiles.clear();

        ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);

        searchFiles(rootDir, format.trim(), threadPool);

        try {
            threadPool.awaitTermination(2 , TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Found Files");
        alert.setHeaderText("Files found with the specified format:");

        StringBuilder fileList = new StringBuilder();
        for (File file : foundFiles) {
            fileList.append(file.getAbsolutePath()).append("\n");
        }

        alert.setContentText(fileList.toString());
        alert.showAndWait();
    }

    private void searchFiles(File dir, String format, ExecutorService threadPool) {
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        //System.out.println("DIRECTORY: " + dir.getAbsolutePath());
        for (File file : files) {
            if (file.isDirectory()) {
                threadPool.submit(() -> searchFiles(file, format, threadPool));
                //new Thread(() -> searchFiles(file, format)).start();
                //searchFiles(file,format);
            } else if (FilenameUtils.getExtension(file.getName()).equals(format)) {
                System.out.println(file.getAbsolutePath());
                foundFiles.add(file);
            }
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
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
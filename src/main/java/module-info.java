module com.example.lab_18 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_18 to javafx.fxml;
    exports com.example.lab_18;
}
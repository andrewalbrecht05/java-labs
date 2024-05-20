module com.example.task_19 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.task_19 to javafx.fxml;
    exports com.example.task_19;
}
module com.example.test1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires MathParser.org.mXparser;
    exports com.example.test1;

    opens com.example.test1 to javafx.fxml;
}
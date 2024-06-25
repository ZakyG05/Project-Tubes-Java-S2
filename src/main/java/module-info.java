module org.example.lastpboproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lastpboproject to javafx.fxml;
    exports org.example.lastpboproject;
    exports org.example.lastpboproject.Controller;
    opens org.example.lastpboproject.Controller to javafx.fxml;
}
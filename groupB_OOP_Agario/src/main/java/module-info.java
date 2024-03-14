module com.example._groupb_oop_agario {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._groupb_oop_agario to javafx.fxml;
    exports com.example._groupb_oop_agario;
}
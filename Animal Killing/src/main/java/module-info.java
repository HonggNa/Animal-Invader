module project.animalkilling {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens project.animalkilling to javafx.fxml;
    exports project.animalkilling;
    exports project.animalkilling.entities;
    opens project.animalkilling.entities to javafx.fxml;
    exports project.animalkilling.levels;
    opens project.animalkilling.levels to javafx.fxml;
}
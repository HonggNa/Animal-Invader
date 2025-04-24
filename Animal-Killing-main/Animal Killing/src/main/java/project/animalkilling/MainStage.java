package project.animalkilling;

import javafx.stage.Stage;

public class MainStage {
    private static volatile MainStage instance;
    private Stage stage;
    private MainStage() {
        this.stage = new Stage();
    }
    public Stage loadStage() {
        return this.stage;
    }
    public static MainStage getInstance() {
        MainStage result = instance;
        if (result == null) {
            synchronized (MainStage.class) {
                result = instance;
                if (result == null) {
                    instance = result = new MainStage();
                }
            }
        }
        return result;
    }
}

package project.animalkilling;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class OverController extends GameController implements Initializable {
    @FXML
    private Label scoreLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (score > 0) {
            scoreLabel.setText("Your score: " + score);
        } else {
            scoreLabel.setText("Wait wait ... NOOOO!");
        }
    }

    Stage stage = MainStage.getInstance().loadStage();

    public void showScore() throws IOException {
        Scene gameover = new MainScene("fxml/gameover.fxml").loadScene();
        stage.setScene(gameover);
        stage.show();
    }
}
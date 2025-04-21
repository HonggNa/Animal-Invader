package project.animalkilling;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class SceneController {
	@FXML
	private ImageView playImgView;
	@FXML
	private ImageView instructionImgView;
	@FXML
	private ImageView aboutUsImgView;
	@FXML
	private ImageView exitImgView;
	@FXML
	private ImageView backImgView;
	@FXML
	private ImageView yesImgView;
	@FXML
	private ImageView noImgView;
	@FXML
	private ImageView instructionContent;
	Stage stage = MainStage.getInstance().loadStage();

	//--Button Animation--
	public void changePlayImg(MouseEvent event) {
		if (Objects.equals(getClass().getResource("img/button/start1.png").toString(), playImgView.getImage().getUrl().toString())) {
			Image img = new Image(getClass().getResource("img/button/start2.png").toString());
			playImgView.setImage(img);
		}
		else {
			Image img = new Image(getClass().getResource("img/button/start1.png").toString());
			playImgView.setImage(img);
		}
	}
	public void changeInstructionImg(MouseEvent event) {
		if (Objects.equals(getClass().getResource("img/button/instruction1.png").toString(), instructionImgView.getImage().getUrl().toString())) {
			Image img = new Image(getClass().getResource("img/button/instruction2.png").toString());
			instructionImgView.setImage(img);
		}
		else{
			Image img = new Image(getClass().getResource("img/button/instruction1.png").toString());
			instructionImgView.setImage(img);
		}
	}
	public void changeAboutUsImg(MouseEvent event) {
		if (Objects.equals(getClass().getResource("img/button/aboutus1.png").toString(), aboutUsImgView.getImage().getUrl().toString())) {
			Image img = new Image(getClass().getResource("img/button/aboutus2.png").toString());
			aboutUsImgView.setImage(img);
		}
		else{
			Image img = new Image(getClass().getResource("img/button/aboutus1.png").toString());
			aboutUsImgView.setImage(img);
		}
	}
	public void changeExitImg(MouseEvent event) {
		if (Objects.equals(getClass().getResource("img/button/exit1.png").toString(), exitImgView.getImage().getUrl().toString())) {
			Image img = new Image(getClass().getResource("img/button/exit2.png").toString());
			exitImgView.setImage(img);
		}
		else{
			Image img = new Image(getClass().getResource("img/button/exit1.png").toString());
			exitImgView.setImage(img);
		}
	}
	public void changeBackImg(MouseEvent event) {
		if (Objects.equals(getClass().getResource("img/content/back1.png").toString(), backImgView.getImage().getUrl().toString())) {
			Image img = new Image(getClass().getResource("img/content/back2.png").toString());
			backImgView.setImage(img);
		}
		else{
			Image img = new Image(getClass().getResource("img/content/back1.png").toString());
			backImgView.setImage(img);
		}
	}
	public void changeYesImg(MouseEvent event) {
		if (Objects.equals(getClass().getResource("img/content/yes1.png").toString(), yesImgView.getImage().getUrl().toString())) {
			Image img = new Image(getClass().getResource("img/content/yes2.png").toString());
			yesImgView.setImage(img);
		}
		else {
			Image img = new Image(getClass().getResource("img/content/yes1.png").toString());
			yesImgView.setImage(img);
		}
	}
	public void changeNoImg(MouseEvent event) {
		if (Objects.equals(getClass().getResource("img/content/no1.png").toString(), noImgView.getImage().getUrl().toString())) {
			Image img = new Image(getClass().getResource("img/content/no2.png").toString());
			noImgView.setImage(img);
		}
		else{
			Image img = new Image(getClass().getResource("img/content/no1.png").toString());
			noImgView.setImage(img);
		}
	}

	// go to next page on instruction content
	public void nextPage() {
		String[] imgPath = {
				getClass().getResource("img/content/instructioncontent1.png").toString(),
				getClass().getResource("img/content/instructioncontent2.png").toString(),
				getClass().getResource("img/content/instructioncontent3.png").toString()
		};
		String currentPath = instructionContent.getImage().getUrl();
		try{
			for (int i = 0; i < imgPath.length; i++) {
				if (Objects.equals(imgPath[i], currentPath)) {
					instructionContent.setImage(new Image(imgPath[i + 1]));
				}
			}
		} catch (ArrayIndexOutOfBoundsException error) {
			instructionContent.setImage(new Image(imgPath[0]));
		}
	}

	//--Switch Scene--
	public void switchtoMenu(MouseEvent event) throws IOException {
		MainScene menu = new MainScene("fxml/menu.fxml");
		stage.setScene(menu.loadScene());
		stage.show();
	}

	public void switchtoInstruction(MouseEvent event) throws IOException {
		MainScene instruction = new MainScene("fxml/instruction.fxml");
		stage.setScene(instruction.loadScene());
		stage.show();
	}
	public void switchtoAboutUs(MouseEvent event) throws IOException {
		MainScene instruction = new MainScene("fxml/aboutus.fxml");
		stage.setScene(instruction.loadScene());
		stage.show();
	}
	public void exit() {
		stage.close();
	}
}

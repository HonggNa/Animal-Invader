package project.animalkilling.entities;
// import necessary libraries
import javafx.scene.image.Image;
import project.animalkilling.GameController;
import project.animalkilling.MainScene;
// declare variables and constructor
public class Animal extends Entity{
    private final int speed = (GameController.playerScore / 10) + 4;
    public Animal(int x, int y, int size, Image img) {
        super(x, y, size, img);
    }
    // update method for the animal
    @Override
    public void update() {
        super.update();
        if (!exploding && !destroyed) y += speed;
        if (y > MainScene.height) destroyed = true;
    }
}

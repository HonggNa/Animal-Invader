package project.animalkilling.entities;

import javafx.scene.image.Image;
import project.animalkilling.GameController;
import static project.animalkilling.GameController.gc;
// constructor 
public class Player extends Entity {
    public Player(int x, int y, int size, Image img) {
        super(x, y, size, img);
    }
    // shoot method for the ship
    public Bullet shoot() {
        return new Bullet(x + size / 2 - Bullet.size / 2, y - Bullet.size);
    }
}

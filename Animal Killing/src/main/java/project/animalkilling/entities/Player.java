package project.animalkilling.entities;

import javafx.scene.image.Image;

// constructor
public class Player extends Entity {
    public Player(int x, int y, int size, Image img) {
        super(x, y, size, img);
    }
    // shoot method for the ship
    public int getWidth() {
        return size;
    }

    public int getHeight() {
        return size;
    }

    public PlayerBullet shoot() {
        return new PlayerBullet(x + size / 2 - AnimalBullet.size / 2, y - AnimalBullet.size);
    }
}

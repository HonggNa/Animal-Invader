package project.animalkilling.entities;

// import necessary libraries
import javafx.scene.paint.Color;
import static project.animalkilling.GameController.*;

// instantiating the class 
public class Bullet extends Entity {
    boolean remove;
    int speed = 10;
    static final int size = 6;
    boolean isFromPlayer;
    public Bullet(int x, int y, boolean isFromPlayer) {
        super(x, y, size, null);
        this.isFromPlayer = isFromPlayer;
    }
    public int getWidth() {
        return size;
    }

    public int getHeight() {
        return size;
    }

    public boolean getStatus() {
        return remove;
    }

    public void setStatus(boolean toRemove) {
        this.remove = toRemove;
    }

    @Override
    public void update() {
        this.y += isFromPlayer ? -speed : speed;
    }

    @Override
    public void draw() {
        gc.setFill(Color.valueOf("#f32236"));
        if (score <= 50) {
            gc.fillOval(x, y, size, size);
        } else if (score <= 150) {
            gc.setFill(Color.valueOf("#3a7ef7"));
            speed = 30;
            gc.fillRect(x - 5, y - 10, size + 10, size + 20);
        } else if (score <= 250) {
            gc.setFill(Color.valueOf("#ffde00"));
            speed = 50;
            gc.fillOval(x - 5, y - 10, size + 20, size + 20);
        } else {
            gc.setFill(Color.valueOf("#0eb91e"));
            speed = 70;
            gc.fillRect(x - 5, y - 10, size + 20, size + 30);
        }
    }
}

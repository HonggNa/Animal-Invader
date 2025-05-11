package project.animalkilling.entities;

// import necessary libraries
import javafx.scene.paint.Color;
import static project.animalkilling.GameController.*;

// instantiating the class 
public class AnimalBullet extends Entity {
    boolean remove;
    int speed = 10;
    static final int size = 6;



    public AnimalBullet(int x, int y) {
        super(x, y, size, null);

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


        this.y += speed;

    }

    @Override
    public void draw() {
        gc.setFill(Color.ORANGE);
        gc.fillOval(x, y, size, size);
    }}


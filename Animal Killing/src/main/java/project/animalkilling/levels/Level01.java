package project.animalkilling.levels;

import javafx.scene.image.Image;
import project.animalkilling.entities.Animal;

import java.util.*;

public class Level01 implements LevelBuilder {
    private final Image[] animalImages;
    private final int size;
    private final Random rand = new Random();

    //constructor
    public Level01(Image[] animalImages){
        this.animalImages = animalImages;
        this.size = 34;
    }

    @Override
    public List<Animal> buildLevel(){
        List<Animal> animals = new ArrayList<>();
        int startX = 225;
        int startY = 0;
        int gap = 15;
        int size = 34;
        Image animalImg = animalImages[rand.nextInt(animalImages.length)];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 10; col++) {
                int x = startX + col * (size + gap);
                int y = startY + row * (size + gap);
                animals.add(new Animal(x, y, size, animalImg));
            }
        }
        return animals;
    }
}

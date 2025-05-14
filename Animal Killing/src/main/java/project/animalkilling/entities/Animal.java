package project.animalkilling.entities;

import javafx.scene.image.Image;
import project.animalkilling.GameController;
import project.animalkilling.MainScene;
import java.util.ArrayList;
import java.util.List;
import static project.animalkilling.GameController.gc;
import java.util.Random; // Thêm import này
public class Animal extends Entity {
    private int level;//new
    private int speed ;//new

    private List<AnimalBullet> bullets = new ArrayList<>();  // Danh sách đạn của quái vật
    private int shootCooldown = 0;  // Khoảng thời gian giữa các lần bắn
    private static final Random random = new Random();//new

    public Animal(int x, int y, int size, Image img, int level) {
        super(x, y, size, img);
        this.level = level;
        this.speed = (GameController.playerScore / 10) + 2 + level;
        double shootRate = 0.1 + level * 0.05;
    }


    @Override
    public void update() {
        super.update();

        if (!exploding && !destroyed) {
            y += speed/3;  // Di chuyển xuống dưới
        }

        // Nếu quái vật vượt qua màn hình, đánh dấu bị hủy
        if (y > MainScene.height) {
            destroyed = true;
        }
        // Điều khiển bắn đạn mỗi 30 frame
        if (shootCooldown <= 0) {
            double shootRate = 0.1 + level * 0.05;  // Level 1 = 15%, Level 2 = 20%, Level 3 = 25%

            if (random.nextDouble()<shootRate) {
                bullets.add(shoot());}
            shootCooldown = 100;    // Reset cooldown (10100 frame sau mới bắn lại)
        }




        // Cập nhật tất cả các viên đạn của quái vật
        for (AnimalBullet b : bullets) {
            b.update();
        }
    }

    // Phương thức bắn đạn
    public AnimalBullet shoot() {
        return new AnimalBullet(x + size / 2 - AnimalBullet.size / 2, y + size);  // Đạn đi xuống
    }

    @Override
    public void draw() {
        if (!exploding) {
            gc.drawImage(img, x, y, size, size);  // Vẽ quái vật
        }

        // Vẽ các viên đạn của quái vật
        for (AnimalBullet b : bullets) {
            b.draw();  // Gọi phương thức draw() của Bullet để vẽ từng viên đạn
        }
    }

    // Lấy danh sách các viên đạn của quái vật
    public List<AnimalBullet> getBullets() {
        return bullets;
    }
}

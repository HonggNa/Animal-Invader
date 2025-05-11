package project.animalkilling.entities;

import javafx.scene.image.Image;
import project.animalkilling.GameController;
import project.animalkilling.MainScene;
import java.util.ArrayList;
import java.util.List;
import static project.animalkilling.GameController.gc;

public class Animal extends Entity {
    private final int speed = (GameController.playerScore / 10) + 4;  // Tốc độ di chuyển của quái vật

    private List<AnimalBullet> bullets = new ArrayList<>();  // Danh sách đạn của quái vật
    private int shootCooldown = 0;  // Khoảng thời gian giữa các lần bắn

    public Animal(int x, int y, int size, Image img) {
        super(x, y, size, img);
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
            bullets.add(shoot());  // Thêm đạn vào danh sách
            shootCooldown = 100;    // Reset cooldown (30 frame sau mới bắn lại)
        } else {
            shootCooldown--;  // Giảm thời gian cooldown
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

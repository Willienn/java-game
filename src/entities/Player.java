package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import static utils.Constants.PlayerConstants.*;

public class Player extends Entity {

    private final int aniSpeed = 15;
    private BufferedImage[][] animations;
    private int aniTick;
    private int aniIndex;
    private int playerAction = IDLE;
    private boolean left, up, right, down;
    private final boolean moving = false;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        updateAnimationTick();
        setAnimation();
        updatePos();

    }

    public void render(Graphics graphics) {

        graphics.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 256, 160, null);

    }

    private void updatePos() {
if (left&&!right){

}
    }

    private void setAnimation() {
        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
            }
        }
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];

        InputStream is = getClass().getResourceAsStream("/res/player_sprites.png");
        if (Objects.isNull(is)) {
            System.out.println("Resource player_sprites.png not found!");
            return;
        }
        try {
            BufferedImage img = ImageIO.read(is);
            for (int j = 0; j < animations.length; j++)
                for (int i = 0; i < animations[j].length; i++)
                    animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}

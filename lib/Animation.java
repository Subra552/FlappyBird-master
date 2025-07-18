/**
 * The Animation class provides a static method to draw and cycle through a series of images (sprites)
 * to create an animation effect. It handles frame progression and rotation of the sprites.
 * Note: This class uses a static frame counter, meaning all animations controlled by this class
 * will be synchronized to the same frame.
 *
 * @author Ankit Sinha
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

public class Animation {

    // Start at first frame
    private static double currentFrame = 0;

    /**
     * Draws a single frame of an animation and progresses the frame counter.
     * The sprite is rotated by the specified angle around a pivot point.
     *
     * @param g       The Graphics context on which to draw the animation.
     * @param sprites An array of {@link BufferedImage} representing the animation frames.
     * @param x       The x-coordinate for the top-left corner of the sprite.
     * @param y       The y-coordinate for the top-left corner of the sprite.
     * @param speed   The rate at which to advance through the animation frames. A higher value means a faster animation.
     * @param angle   The angle in radians to rotate the image.
     */
    public static void animate(Graphics g, BufferedImage[] sprites, int x, int y, double speed, double angle) {

        Graphics2D g2d = (Graphics2D) g;
        AffineTransform trans = g2d.getTransform();
        AffineTransform at = new AffineTransform();

        // Number of frames
        int count = sprites.length;

        // Rotate the image
        at.rotate(angle, x + 25, y + 25);
        g2d.transform(at);

        // Draw the current rotated frame
        g2d.drawImage(sprites[(int) (Math.round(currentFrame))], x, y, null);

        g2d.setTransform(trans);

        // Switch animation frames
        if (currentFrame >= count - 1) {
            currentFrame = 0;
        } else currentFrame += speed;

    }

}
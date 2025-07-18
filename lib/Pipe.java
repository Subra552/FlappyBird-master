/**
 * Pipe.java
 * Handles collisions and rendering for pipes
 *
 * @author Ankit Sinha
 */

import java.util.Random;

public class Pipe {

    // Add a static Random instance for better random number generation
    private static final Random random = new Random();

    // Pipe coordinates
    private int x = FlappyBird.WIDTH + 5;
    private int y;

    // Placement (top or bottom) of pipe
    String location;

    // Pipe constants
    public static final int WIDTH = 67;
    public static final int HEIGHT = 416;
    public static final int PIPE_DISTANCE = 150;          // Horizontal distance between pipes
    public static final int PIPE_SPACING = HEIGHT + 170; // Vertical distance between pipes
    private static final int SPEED = -2;

    // If the bird can get a point passing this pipe
    public boolean canAwardPoint = true;

    public Pipe(String location) {
        this.location = location;
        reset();
    }

    public void reset() {
        x = FlappyBird.WIDTH + 5; // Reset x-coordinate

        // This logic only applies to the top pipe. The bottom pipe's Y-coordinate
        // is calculated based on the top one.
        if (location.equals("top")) {
            // We've increased the range of possible Y-coordinates for more variety.
            // These constants define the vertical spawn range for the top pipe.
            final int MIN_Y = -370; // Results in a lower gap
            final int MAX_Y = -120; // Results in a higher gap

            int range = MAX_Y - MIN_Y;
            y = MIN_Y + random.nextInt(range + 1);
        }
    }

    /**
     * Moves the pipe
     */
    public void move() {
        x += SPEED;
    }


    /**
     * Checks for bird colliding with pipe
     *
     * @param  nX     Bird x-coordinate
     * @param  nY     Bird y-coordinate
     * @param  nW     Bird width
     * @param  nH     Bird height
     * @return If bird is colliding with the pipe
     */
    public boolean collide(int nX, int nY, int nW, int nH) {

        // Do not allow bird to jump over pipe
        if (nX > x && nY < 0 && canAwardPoint) {
            return true;
        }

        return nX < x + WIDTH &&
                nX + nW > x &&
                nY < y + HEIGHT &&
                nY + nH > y;

    }

    /**
     * @return Pipe's x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * @return Pipe's y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Set's pipe's y-coordinate (for bottom pipes)
     *
     * @param newY     New y-coordinate
     */
    public void setY(int newY) {
        y = newY;
    }

}
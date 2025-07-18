/**
 * The Audio class is responsible for handling all sound effects within the game.
 * It provides simple methods to play specific sounds for game events like jumping,
 * scoring a point, or a collision.
 *
 * @author Ankit Sinha
 */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

    private AudioInputStream audioInputStream;
    private Clip clip;

    /**
     * A private helper method that loads and plays a sound file.
     * The sound file is expected to be a .wav file located in the "res/sound/" directory.
     *
     * @param sound The name of the sound file (without the .wav extension) to play.
     */
    private void playSound(String sound) {

        // Path to sound file
        String soundURL = "res/sound/" + sound + ".wav";

        // Try to load and play sound
        try {
            audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(soundURL));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("Could not load %s.wav!\n", sound);
        }
    }

    /**
     * Plays the sound effect for the bird's jump action.
     */
    public void jump() {
        playSound("jump");
    }

    /**
     * Plays the sound effect for scoring a point.
     */
    public void point() {
        playSound("point");
    }

    /**
     * Plays the sound effect for a collision or the bird's death.
     */
    public void hit() {
        playSound("hit");
    }

}
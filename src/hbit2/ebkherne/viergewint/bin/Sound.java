package hbit2.ebkherne.viergewint.bin;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Klasse zum abspielen von Sound Dateien
 * @author Maurice Fletgen
 */
public class Sound {
	/**
	 * Method zum abspielen einer sound datei
	 * @param media Pfad zur audiodatei
	 */
	public static void playSound(String media) throws Exception {
		Media sound = new Media(new File(media).toURI().toString());
		MediaPlayer player = new MediaPlayer(sound);
		player.play();
	}
}

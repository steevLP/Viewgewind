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
	 * @deprecated wird gegen eine neue funktion ersetzt
	 */
	public static void playSound(String media) throws Exception {
		Media sound = new Media(new File(media).toURI().toString());
		MediaPlayer player = new MediaPlayer(sound);
		player.play();
		
		// Debugging Logger
		System.out.println("=================================== Audio Debug Info ===================================");
		System.out.println("Current Audio Rate: " + player.getCurrentRate());
		System.out.println("Audio Rate: " + player.getRate());
		System.out.println("Volume: " + player.getVolume());
		System.out.println("Is Audio autoplay: " + player.isAutoPlay());		
		System.out.println("Audio Media: " + player.getMedia());
		System.out.println("Audio Location" + media);
		System.out.println("Is Audio muted: " + player.isMute());
		System.out.println("Audio Start Time: " + player.getStartTime());
		System.out.println("Audio Stop Time: " + player.getStopTime());
		System.out.println("Audio Status: " + player.getStatus());
		System.out.println("Audio Duration: " + player.getTotalDuration());
		System.out.println();
		System.out.println("Audio Implementation made by Maurice (Steev) Fletgen");
		System.out.println("========================================================================================");
	}
}

package hbit2.ebkherne.viergewint.bin.utils;

import java.util.Optional;
import javafx.scene.control.TextInputDialog;

/**
 * Creates a TextInputDialog
 * @author Mauri
 */
public class DialogWindow {
	/**
	 * Constructor creates Dialog
	 * @param title Title Line
	 * @param header Headline
	 * @param content Content line
	 */
	public TextInputDialog window;
	
	public DialogWindow(String title, String header, String content) {
		// Name von Spieler 1 Wählen
		window = new TextInputDialog("");
		window.setTitle(title);
		window.setHeaderText(header);
		window.setContentText(content);	
	}
	
	/**
	 * handles input for the dialog
	 * @param window dialog instance
	 * @return string content from dialog
	 */
	public String showDialog(TextInputDialog window) {
		String output = new String();
		
		// Wait for Answere when no content is passed return Uknown
		Optional<String> result1 = window.showAndWait();
		if (result1.isPresent()) {
			output = result1.get();
		} else {
			output = "Unbekannter Spieler 1";
		}
		
		// returns what the dialog catches
		return output;
	}
}

package hbit2.ebkherne.viergewint.bin.utils;

import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Splash {
	// Credits window
	private static Popup window;
	private BorderPane layout;
	
	/**
	 * VBox content the content accepting node
	 */
	private VBox content;
	
	/**
	 * Simple Splashscreen Implementation
	 * @param Logo Path to logo image
	 * @param duration how long in seconds should the splashscreen show
	 */
	public Splash(Stage stage, String Logo, long duration) {
		// Initializes nodes for this window
		content  = new VBox();
		layout = new BorderPane();
		window = new Popup();
		
		File img = new File(Logo);
		Image image = new Image(img.toURI().toString());
						
		// Assemble everthing to display
		layout.setCenter(new ImageView(image));
		window.getContent().add(layout);
	
		window.show(stage);

		try {
			Thread.sleep(duration*1000);
			window.hide();		
		} catch (InterruptedException e) {
			e.printStackTrace();
			PopupWindow error = new PopupWindow(stage);
			error.addItems(new Label("Etwas ist schief gelaufen"));
			stage.close();
		}
		
	}
}

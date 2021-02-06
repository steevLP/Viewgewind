package hbit2.ebkherne.viergewint.bin.utils;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Popup window implementation
 * @author Mauri
 */
public class PopupWindow {
	// Credits window
	private static Popup window;
	private BorderPane layout;
	
	/**
	 * VBox content the content accepting node
	 */
	private VBox content;
	
	/**
	 * Contstructor for popup creation
	 * @param stage the applications primary Stage
	 */
	public PopupWindow(Stage stage) {						
		// Initializes nodes for this window
		content  = new VBox();
		layout = new BorderPane();
		window = new Popup();
		
		// Assemble everthing to display
		layout.setRight(content);
		layout.setStyle(" -fx-background-color: white; -fx-padding:5px;");
		window.getContent().add(layout);
	}

	/**
	 * Toogles popup state on or off
	 * @param stage the applications primary stage
	 */
	public void togglePopup(Stage stage) {
		System.out.println("Popup Toggle");
		if(!window.isShowing()) {
			window.show(stage);
			System.out.println("display");
		} else {
			window.hide();
		}
	}
	
	public void addItems(Node item) {
		this.content.getChildren().add(item);
	}
}

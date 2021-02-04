package hbit2.ebkherne.viergewint;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class VG_View extends Application
{  
	public Button spielfeld[][] = new Button[7][6];
	public String playerNameOne;
	public String playerNameTwo;
	private VG_Model model = new VG_Model(this);
    
	public void start(Stage primaryStage)
	{
		BorderPane pane = new BorderPane();
		GridPane grid = new GridPane();
		grid.setHgap(2);
		grid.setVgap(2);
		pane.setMaxSize(400, 400);
		grid.setPadding(new Insets(20, 30, 30, 20));
				     
		// Wir erstellen ein Array das 7 Hoch und 6 Lang ist
		for (int rows = 0; rows < 7; rows++){
			for (int colums = 0; colums < 6; colums++){	   
				spielfeld[rows][colums] = new Button();
				spielfeld[rows][colums].setMinSize(28, 28);
				grid.add(spielfeld[rows][colums], rows, colums+1);
				
				spielfeld[rows][colums].setStyle(
			            "-fx-background-radius: 5em; " +
			            "-fx-min-width: 30px; " +
			            "-fx-min-height: 30px; " +
			            "-fx-max-width: 30px; " +
			            "-fx-max-height: 30px;"
			            + "-fx-color:white" 
			    );
			}
		}
		
		// Wir setzten das Spielfenster in die mitte und geben es eine Maximale Größe von 400*400 Pixeln und geben diese eine Hintergund Farbe
		pane.setCenter(grid);
		pane.setMaxSize(400, 400);
		pane.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, null, null)));				
		// Credits window
		Popup credits = new Popup();
		BorderPane layout = new BorderPane();
		VBox contribs = new VBox();
		Button CreditClose = new Button("Okay");
		
		
		contribs.getChildren().add(new Label("Credits"));
		contribs.getChildren().add(new Label("Maurice F (Functional Programming & Conzeptional Design)"));
		contribs.getChildren().add(new Label("Jenni (Visual Programming & Conzeptional Design)"));
		contribs.getChildren().add(new Label("Alex (Audio Programming & Conzeptional Design)"));
		contribs.getChildren().add(new Label("Michell Dehn (war dabei)"));
		contribs.getChildren().add(new Label("Bonekit (Jenni bat ihn um Hilfe und er half:D)"));

		contribs.getChildren().add(CreditClose);
	
		// Assemble everthing to display
		layout.setRight(contribs);
		layout.setStyle(" -fx-background-color: white; -fx-padding:5px;");
		credits.getContent().add(layout);
		
		// Display and track popup interaction
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			
			// Check if popup is displayed and handle inputs
			@Override
			public void handle(ActionEvent e) {
				if(!credits.isShowing()) {
					credits.show(primaryStage);
				} else {
					credits.hide();
				}
			}
		};
	
		CreditClose.setOnAction(event);
		
		// Name von Spieler 1 Wählen
		TextInputDialog dialog1 = new TextInputDialog("");
		dialog1.setTitle("Namens Verwaltung");
		dialog1.setHeaderText("Füge den Namen für Spieler 1 hinzu");
		dialog1.setContentText("Gib deinen Namen ein:");
		
		// Warten auf eine Antwort, wenn es leer gelassen wird wird ein Placeholder benutzt
		Optional<String> result1 = dialog1.showAndWait();
		if (result1.isPresent()){
			playerNameOne = result1.get();
		}
		else{
			playerNameOne = "Unbekannter Spieler 1";
		}
		
		// Name von Spieler 2 Wählen
		TextInputDialog dialog2 = new TextInputDialog("");
		dialog2.setTitle("Namens Verwaltung");
		dialog2.setHeaderText("Füge den Namen für Spieler 2 hinzu");
		dialog2.setContentText("Gib deinen Namen ein:");
		
		// Warten auf eine Antwort, wenn es leer gelassen wird wird ein Placeholder benutzt
		Optional<String> result2 = dialog2.showAndWait();
		if (result2.isPresent()){
			playerNameTwo = result2.get();
		} else {
			playerNameTwo = "Unbekannter Spieler 2";
		}
		
		/*	=========================================
		 * 	Visual Position
		 * 	Engineerd by Jenni cleaned by Maurice F
		 *  =========================================
		 */
		
		// Sets Gameboard
		pane.setCenter(grid);
		
		// Title
		Label title = new Label("Vier gewinnt");
		HBox TitleLayout = new HBox();

		// Sets Position of Title Label
		title.setPrefSize(100, 20);
		title.setAlignment(Pos.CENTER);
		
		// Sets Position of TitleLayout
		TitleLayout.setPadding(new Insets(10, 5, 5, 10));
		TitleLayout.setSpacing(8);
		TitleLayout.getChildren().add(title);
		TitleLayout.setAlignment(Pos.CENTER);
		
		pane.setTop(TitleLayout);
		
		// Contains name of player 1
		Label playerOne  = new Label("Spieler 1:" + playerNameOne);
		HBox PlayerOneContainer = new HBox();
		
		PlayerOneContainer.setPadding(new Insets(10, 5, 5, 10));
		PlayerOneContainer.setSpacing(8);
		PlayerOneContainer.getChildren().add(playerOne); // Add playerOne Label as child
		PlayerOneContainer.setAlignment(Pos.TOP_LEFT);
		
		pane.setLeft(PlayerOneContainer);
		
		// Contains name of player 2
		Label playerTwo = new Label("Spieler 2:" + playerNameTwo);
		HBox PlayerTwoContainer = new HBox();

		playerTwo.setAlignment(Pos.TOP_RIGHT);
		
		// Sets Container Values
		PlayerTwoContainer.setPadding(new Insets(10, 5, 5, 10));
		PlayerTwoContainer.setSpacing(8);
		PlayerTwoContainer.getChildren().add(playerTwo); // Add playerTwo Label as child
		PlayerTwoContainer.setAlignment(Pos.TOP_RIGHT);
		
		pane.setRight(PlayerTwoContainer);
		
		// Creates Hbox and Buttons
		HBox buttons = new HBox();
		Button Reset = new Button("Reset");
		Button Quit = new Button("Quit");
		Button Credits = new Button("Credits");
		
		// Sets position of Hbox Layout and adds buttons to it
		buttons.setSpacing(8);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		buttons.getChildren().add(Quit);
		buttons.getChildren().add(Credits);

		// Button Functions
		Quit.setOnAction(ae -> {
			primaryStage.close();
		});
		Credits.setOnAction(event); // displays credits
		pane.setBottom(buttons);
		
		// Add everything to final display Scene and display it
		primaryStage.setScene(new Scene(pane));
		primaryStage.setResizable(false);
		primaryStage.show();
		model.updateBoard();
	}
	
	// Updatet das Spielfeld
	public void update(int[][] board) {
		System.out.println("update");
		// Wir erstellen ein Array das 7 Hoch und 6 Lang ist
		for (int rows = 0; rows < 7; rows++){
			for (int colums = 0; colums < 6; colums++){	  
				if(board[colums][rows] == 1) {
					spielfeld[rows][colums].setStyle(
						"-fx-background-radius: 5em; " +
						"-fx-min-width: 30px; " +
						"-fx-min-height: 30px; " +
						"-fx-max-width: 30px; " +
						"-fx-max-height: 30px;"
						+ "-fx-color:RED" 
						);	
				} 
				else if(board[colums][rows] == 2) {
				spielfeld[rows][colums].setStyle(
			            "-fx-background-radius: 5em; " +
			            "-fx-min-width: 30px; " +
			            "-fx-min-height: 30px; " +
			            "-fx-max-width: 30px; " +
			            "-fx-max-height: 30px;"
			            + "-fx-color:BLUE" 
						);	
				}
				else {
				spielfeld[rows][colums].setStyle(
			            "-fx-background-radius: 5em; " +
			            "-fx-min-width: 30px; " +
			            "-fx-min-height: 30px; " +
			            "-fx-max-width: 30px; " +
			            "-fx-max-height: 30px;"
			            + "-fx-color:white" 
						);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		launch();
	}
}

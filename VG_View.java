package spiel;


import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class VG_View extends Application
{  
  public Button spielfeld[][] = new Button[7][6];
  public String playerNameOne;
  public String playerNameTwo;
  
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
      }
    }
    // Wir setzten das Spielfenster in die mitte und geben es eine Maximale Größe von 400*400 Pixeln
    pane.setCenter(grid);
    pane.setMaxSize(400, 400);
    
    //Credits an uns selbst...
    TextInputDialog dialog = new TextInputDialog("");
    dialog.setTitle("Credits");
    dialog.setHeaderText(" Das hier allein Kommt von Maurice, Mimi (Seelische Unterstützung) und mit mir Jenni."
    		+ " Alex und Lorenz sind Erzfeinde die uns hängen lassen.");
    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()){
       playerNameOne = result.get();
    }
    else{
        playerNameOne = "Unbekannter Spieler 1";
    }
    
    // Name von Spieler 1 Wählen
    TextInputDialog dialog1 = new TextInputDialog("");
    dialog1.setTitle("Namens Verwaltung");
    dialog1.setHeaderText("Füge den Namen für Spieler 1 hinzu");
    dialog1.setContentText("Naaa wie heißt du den?:");
    
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
    dialog2.setContentText("Naaa wie heißt du den?:");

    // Warten auf eine Antwort, wenn es leer gelassen wird wird ein Placeholder benutzt
    Optional<String> result2 = dialog2.showAndWait();
    if (result2.isPresent()){
       playerNameTwo = result2.get();
    }
    else{
        playerNameTwo = "Unknown One";
    }

    /*
     *ab hier kam Internet wegen spacing zur hilfe
     */
    pane.setCenter(grid);
    
    Label label = new Label("Vier gewinnt");
    label.setPrefSize(100, 20);
    label.setAlignment(Pos.CENTER);
    HBox hbox = new HBox();
    hbox.setPadding(new Insets(10, 5, 5, 10));
    hbox.setSpacing(8);
    hbox.getChildren().add(label);
    hbox.setAlignment(Pos.CENTER);
    pane.setTop(hbox);
    
     
     
    Label label2 = new Label("Spieler 1:" + playerNameOne);
    HBox hbox2 = new HBox();
    hbox2.setPadding(new Insets(10, 5, 5, 10));
    hbox2.setSpacing(8);
    hbox2.getChildren().add(label2);
    hbox2.setAlignment(Pos.TOP_LEFT);
    pane.setLeft(hbox2);
    
    Label label3 = new Label("Spieler 2:" + playerNameTwo);
    label3.setAlignment(Pos.TOP_RIGHT);
    HBox hbox3 = new HBox();
    hbox3.setPadding(new Insets(10, 5, 5, 10));
    hbox3.setSpacing(8);
    hbox3.getChildren().add(label3);
    hbox3.setAlignment(Pos.TOP_RIGHT);
    pane.setRight(hbox3);

    HBox hbox4 = new HBox();
    hbox4.setPadding(new Insets(0, 0, 0, 0));
    hbox4.setSpacing(8);
    hbox4.setAlignment(Pos.BOTTOM_CENTER);
    Button Reset = new Button("Reset");
    hbox4.getChildren().add(Reset);
    Button Quit = new Button("Quit");
    hbox4.getChildren().add(Quit);
    pane.setBottom(hbox4);
    
    primaryStage.setScene(new Scene(pane));
    primaryStage.show();
    
  }
       public String holeSpielfeld (int rows, int colums)
    {
        return this.spielfeld[rows][colums].getText();     
    }

public static void main(String[] args)
{
  launch();
}
}

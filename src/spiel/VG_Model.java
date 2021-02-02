package spiel;

import javafx.scene.control.Button;

public class VG_Model extends VG_View{

	public VG_Model() {
		/**
		 *Representation of the Connect-Four-Gameboard.
		 *This array has dimensions of 6 rows and 7 columns. 
		 *gameBoard[rows][colums] * The Values have the following meanings:
		 *0: not selected cell 
		 *1: selected by player 1 *
		 *2: selected by player 2 *
		 *3: winning entry of player 1 *
		 *4: winning entry of player 2 
		 */
		
		for (int rows = 0; rows < 7; rows++){
		      for (int colums = 0; colums < 6; colums++){
		    	  
		        spielfeld[rows][colums] = new Button();
		        spielfeld[rows][colums].setMinSize(28, 28);
		        
		      
		    
		private int[][] gameBoard;
		int[][] testBoard =
			   {{ 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 0, 1, 0 },
				{ 2, 2, 1, 2, 1, 1, 0 },  
				{ 1, 1, 1, 2, 2, 1, 0 }, 
				{ 2, 2, 2, 1, 1, 1, 0 },  
				{ 2, 2, 1, 2, 1, 2, 2 }, };
		
		gameBoard = testBoard;
		}
		}
	}
}	
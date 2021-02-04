package spiel;

public class VG_Model {

	
	private int[][] gameBoard; // Initialize gameBoard
	private final VG_View view;
	
	public VG_Model(VG_View view) {
		this.view = view;
		gameBoard = new int[6][7];
		//view.update(gameBoard);
	}
	
	public void updateBoard() {
		view.update(gameBoard);
	}
	
	// Mostly unused only used for creating display gamelogic
	public void setTestConfiguration() {

		 // Define Gameboard
		 int[][] testBoard = new int[][] {
				 { 0, 0, 0, 0, 0, 1, 0 }, 
				 { 0, 0, 1, 0, 0, 1, 0 }, 
				 { 2, 2, 1, 2, 1, 1, 0 },  
				 { 1, 1, 1, 2, 2, 1, 0 }, 
				 { 2, 2, 2, 1, 1, 1, 0 }, 
				 { 2, 2, 1, 2, 1, 2, 2 }
		 };
		 
		 view.update(testBoard);
	}
}	
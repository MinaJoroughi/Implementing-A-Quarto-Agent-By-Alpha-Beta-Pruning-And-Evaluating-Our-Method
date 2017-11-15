public class GameView implements GameObserver {

	private GameLogic gameLogic;
	public GameView(GameLogic temp){
		this.gameLogic = temp;
		this.gameLogic.attach(this);
	}
	public void update() {
		this.displayMessage();
	}
	public void displayMessage() {
		displayGameBoard();
		if(this.gameLogic.isLastMoveIllegal()){
			System.out.println("ERROR : Illegal move --> Try again :)");
			return ;
		}
		if(this.gameLogic.getGameStatus() == GameState.Player){
			System.out.println("You Won :D ");
			return ;
		}
		if(this.gameLogic.getGameStatus() ==GameState.Computer){
			System.out.println("You Lost... Maybe Next Time :)");
			return ;
		}
		if(this.gameLogic.getGameStatus() == GameState.Draw){
			System.out.println("Draw :| ");
			return ;
		}
	}
	public void displayGameBoard() {
		// this for is to clear the console LOL :)
		for(int clear = 0; clear < 1000; clear++)
		     System.out.println() ;
		int size = this.gameLogic.getGameBoard().getSize();
		GameBoard gameBoard = gameLogic.getGameBoard();
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				switch (gameBoard.getPiece(i, j)){
				case 0:
					System.out.print(" " + "| ");
					break;
				case GameState.Player:
					System.out.print("O" + "| ");
					break;
				case GameState.Computer:
					System.out.print("X" + "| ");
					break;
				}
			}
			System.out.println();
			if( i < size-1  )
				System.out.println("________");
		}
		System.out.println();
	}
}
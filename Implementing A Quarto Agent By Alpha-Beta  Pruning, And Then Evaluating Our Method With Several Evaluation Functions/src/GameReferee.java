public class GameReferee {
	private GameBoard gameBoard;
	public GameReferee(GameBoard temp){
		this.gameBoard = temp;
	}
	public void setBoard(GameBoard temp){
		this.gameBoard = temp;
	}
	public boolean checkLegalMove(int ROW, int COL) {
		if (this.gameBoard.getPiece(ROW,COL) == GameState.Empty )
			return false;
		return true;
	}
	public int checkGameStatus() {
		if( this.gameBoard.isWon(GameState.Player) )
			return GameState.Player;
		else if( this.gameBoard.isWon(GameState.Computer) )
			return GameState.Computer;
		else if( this.gameBoard.isBoardFull() )
			return GameState.Draw;
		return GameState.Continue;
	}
}
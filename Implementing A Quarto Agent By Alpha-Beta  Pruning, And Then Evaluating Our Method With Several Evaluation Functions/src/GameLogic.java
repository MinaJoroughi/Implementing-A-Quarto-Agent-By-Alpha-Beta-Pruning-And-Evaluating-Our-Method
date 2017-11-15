public class GameLogic extends GameSubject {
	private GameReferee gameReferee;
	private boolean legalMove=false;
	private ComputerPlayer computerPlayer;
	private GameBoard gameBoard = new GameBoard();;
	public GameLogic(){
		this.gameReferee  = new GameReferee(gameBoard);
		this.computerPlayer  = new ComputerPlayer(gameBoard);
	}
	
	
	public int getGameStatus() {
		return this.gameReferee.checkGameStatus();
	}
	public GameBoard getGameBoard() {
		return this.gameBoard;
	}

	public GameMemento getGameBoardMemento() {
		return this.gameBoard.createGameMemento();
	}
	public void setGameBoardState(GameBoard temp) {
		this.gameBoard = temp;
		this.gameReferee.setBoard(temp);
		notifyGameObservers();
	}
	public boolean isLastMoveIllegal(){
		return this.legalMove;
	}
	public void handlePlayerMove(int ROW,int COL) {
		this.legalMove = this.gameReferee.checkLegalMove(ROW,COL);
		if ( isLastMoveIllegal() == false ){
			this.gameBoard.setPiece(ROW,COL,GameState.Player);
			if( this.gameReferee.checkGameStatus() == GameState.Continue ){
				this.computerPlayer.makeComputerMove(this.gameBoard);
			}
		}
		notifyGameObservers();
	}
}
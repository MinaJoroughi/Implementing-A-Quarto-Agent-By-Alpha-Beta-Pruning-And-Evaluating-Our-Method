public class GameCommand {
	private int x,y;
	private GameMemento gameMemento;
	public GameCommand(){}
	public GameCommand(int ROW,int COL ){
		this.x=ROW;
		this.y=COL;
	}
	public void execute(GameLogic temp) {
		gameMemento = temp.getGameBoardMemento();
		temp.handlePlayerMove(this.x,this.y);
	}
	public void unexecute(GameLogic temp) {
		temp.setGameBoardState(this.gameMemento.getState());
	}
}
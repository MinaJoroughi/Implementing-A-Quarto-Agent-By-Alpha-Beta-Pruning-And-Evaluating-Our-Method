public class GameMemento {
	private GameBoard gameBoard;
	public GameBoard getState() {
		return this.gameBoard;
	}
	public GameMemento(GameBoard temp){
		this.gameBoard = temp;
	}
	
}
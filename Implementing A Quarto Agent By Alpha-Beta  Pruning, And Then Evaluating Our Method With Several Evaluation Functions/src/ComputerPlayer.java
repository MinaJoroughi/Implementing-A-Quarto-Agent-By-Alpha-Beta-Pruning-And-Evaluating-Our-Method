
public class ComputerPlayer {
	private GameBoard gameBoard;
	private WinStrategy computerStrategy;
	
	public void makeComputerMove(GameBoard temp) {
		this.gameBoard = temp;
		computerStrategy.computeComputerMove(this.gameBoard);
	}
	
	public ComputerPlayer(GameBoard temp){
		this.gameBoard = temp;
		this.computerStrategy = new WinStrategy();
	}
	
}
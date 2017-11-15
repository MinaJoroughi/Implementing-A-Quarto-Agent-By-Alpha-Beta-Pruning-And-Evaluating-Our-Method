public class WinStrategy extends ComputerStrategy {
	private NotLoseStrategy successor = new  NotLoseStrategy();
	public void computeComputerMove(GameBoard temp) {
		this.successor.computeComputerMove( temp);
	}
}
public class NotLoseStrategy extends ComputerStrategy {

	private SmartStrategy successor = new SmartStrategy();

	public void computeComputerMove(GameBoard temp) {
		this.successor.computeComputerMove(	temp);
	}
}
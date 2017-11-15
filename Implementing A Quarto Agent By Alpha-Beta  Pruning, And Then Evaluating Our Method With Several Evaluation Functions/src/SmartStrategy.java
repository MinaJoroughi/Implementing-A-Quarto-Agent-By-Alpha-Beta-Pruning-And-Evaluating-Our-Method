
public class SmartStrategy extends ComputerStrategy {
	private RandomStrategy successor = new  RandomStrategy();
	public void computeComputerMove(GameBoard temp) {
		this.successor.computeComputerMove(temp);
	}
}
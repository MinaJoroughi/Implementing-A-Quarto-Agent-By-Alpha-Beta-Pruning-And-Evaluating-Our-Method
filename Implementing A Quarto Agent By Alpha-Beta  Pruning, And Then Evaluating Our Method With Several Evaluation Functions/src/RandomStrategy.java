import java.util.Random;
public class RandomStrategy extends ComputerStrategy {
	public void computeComputerMove(GameBoard board) {
		int size = board.getSize();
		while(true){
			Random randome= new Random();
			int ROW =randome.nextInt(size);
			int COL =randome.nextInt(size);
			if ( board.getPiece(ROW, COL) == GameState.Empty ){
				board.setPiece(ROW, COL, GameState.Computer);
				break;
			}
		}
	}
}
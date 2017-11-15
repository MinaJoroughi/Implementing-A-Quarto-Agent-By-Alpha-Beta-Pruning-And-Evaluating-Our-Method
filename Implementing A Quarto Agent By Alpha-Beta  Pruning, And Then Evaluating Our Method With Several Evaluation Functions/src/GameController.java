
import java.util.Scanner;
import java.util.Stack;

public class GameController implements GameObserver {
	private GameView gameView ;
	private GameLogic gameLogic;
	private Stack<GameCommand> gameCommandStack ;
	private GameCommand gameCommandPrototype;
	public static void main(String[] args) {
		GameController game  = new GameController();
		game.doWork();
	}
	public GameController(){
		gameLogic = new GameLogic();
		gameView = new GameView(this.gameLogic);
		
		this.gameCommandStack = new Stack<GameCommand>();
		this.gameLogic.attach(this);
	}
	public void update() {
		if(this.gameLogic.isLastMoveIllegal() ) this.gameCommandPrototype = this.gameCommandStack.pop();
	}
	public void doWork() {
		this.gameCommandPrototype = new GameCommand();
		this.gameView.displayGameBoard();
		while(true){
			if(this.gameLogic.getGameStatus() != GameState.Continue)  
				break;
			System.out.println("m x y -> To mark position x and y " );
			System.out.println("(q to Quit) || (u to undo) " );
			
			Scanner reader = new Scanner(System.in);
			String in=reader.next();
			switch (in){
				case "u":
					if(this.gameCommandStack.isEmpty()){
						System.out.println("You cannot Undo anymore !" );
						break;
					}else{
						this.gameCommandPrototype.unexecute(this.gameLogic);
						gameCommandPrototype = gameCommandStack.pop();
					}
					break;
				case "q":
					return ;
				case "m":
					int r= reader.nextInt();
					int c= reader.nextInt();		
					this.gameCommandStack.push(this.gameCommandPrototype);
					this.gameCommandPrototype = new GameCommand(r,c);
					this.gameCommandPrototype.execute(this.gameLogic);
					break;
			}
		}
	}
	
}
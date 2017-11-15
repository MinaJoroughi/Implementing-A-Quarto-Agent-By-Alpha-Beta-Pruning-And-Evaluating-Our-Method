public class GameBoard {
	private final int size = 3;
	private int [][] board ;
	public GameBoard(int [][] newBoard ){
		board= new int[getSize()][getSize()];
		for (int i=0;i<getSize();i++)
			for (int j=0;j<getSize();j++)
				board[i][j]=newBoard[i][j];
	}
	public GameBoard(){
		board= new int[getSize()][getSize()];
	}
	public int getSize(){
		return this.size;
	}
	public GameBoard cloneMe(){
		int [][] newBoard = new int[getSize()][getSize()];
		for (int i=0;i<getSize();i++)
			for (int j=0;j<getSize();j++)
				newBoard[i][j]=board[i][j];
		return new GameBoard(newBoard);
	}
	public boolean isBoardFull(){
		for (int i=0;i<getSize();i++)
			for (int j=0;j<getSize();j++)
				if(this.board[i][j] == GameState.Empty) return false;
		return true;
	}
	public boolean isWon(int piece) {
		if(board[0][0] == piece && board[1][0] == piece && board[2][0] == piece ) 
			return true;
		if(board[0][1] == piece && board[1][1] == piece && board[2][1] == piece )
			return true;
		if(board[0][2] == piece && board[1][2] == piece && board[2][2] == piece )
			return true;
		if(board[0][0] == piece && board[0][1] == piece && board[0][2] == piece )
			return true;
		if(board[1][0] == piece && board[1][1] == piece && board[1][2] == piece )
			return true;
		if(board[2][0] == piece && board[2][1] == piece && board[2][2] == piece )
			return true;
		if(board[0][0] == piece && board[1][1] == piece && board[2][2] == piece )
			return true;
		if(board[0][2] == piece && board[1][1] == piece && board[2][0] == piece )
			return true;	
		return false;
	}
	public void setPiece(int ROW,int COL,int temp) {
		this.board[ROW][COL] = temp;
		
	}
	public int getPiece(int ROW,int COL) {
		return this.board[ROW][COL];
		
	}
	public GameMemento createGameMemento() {
		return new GameMemento(this.cloneMe());
	}
}
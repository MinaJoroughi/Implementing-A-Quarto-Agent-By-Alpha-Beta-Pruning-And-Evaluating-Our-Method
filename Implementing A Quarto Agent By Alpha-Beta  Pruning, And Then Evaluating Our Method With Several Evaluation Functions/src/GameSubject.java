import java.util.ArrayList;

public abstract class GameSubject {
	private ArrayList<GameObserver> gameObserverList =new ArrayList<GameObserver> ();;
	public void attach(GameObserver temp) {
		this.gameObserverList.add(temp);
	}
	public void notifyGameObservers() {
		for (GameObserver temp :this.gameObserverList)
			temp.update();		
	}
}
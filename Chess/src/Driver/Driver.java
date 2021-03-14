package Driver;
import src.Game;

public class Driver {

	/**
	 * main class for chess game
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Game game = new Game();
		game.start(true,null,null,null);
	}

}

package codeexercise;
import java.util.*;

public class ShipPlace {
	private GameHelper helper = new GameHelper();
	private List<Ship> shipList = new ArrayList<>();
	private int numOfGuess = 0;
	
	private void inicialGame() {
		Ship s1 = new Ship();
		s1.setName("Ship1");
		shipList.add(s1);
		Ship s2 = new Ship();
		s2.setName("Ship2");
		shipList.add(s2);
		Ship s3 = new Ship();
		s3.setName("Ship3");
		shipList.add(s3);
		
		List<String> newLocation = GameHelper.myplaceShip(3);
		int i = 0;
		for (Ship tempship : shipList) {
			tempship.setLocation(newLocation.get(i));
			i++;
		}
		System.out.println("Initialize complete");
	}
	
	private void startPlaying() {
		while (!shipList.isEmpty()) {
			String userGuess = helper.getUserInput("enter a guess");
			checkUserGuess(userGuess);
		}
		
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuess++;
		String result = "miss";
		
		for (Ship temp : shipList) {
			result = temp.checkHit(userGuess);
			if (result.equals("hit")) {
				break;
			}
			if (result.equals("kill")) {
				shipList.remove(temp);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("Game Over");
		System.out.println("It took you " + numOfGuess + " guesses.");
	}
	
	public static void main(String[] args) {
		ShipPlace game = new ShipPlace();
		game.inicialGame();
		game.startPlaying();
	}
}

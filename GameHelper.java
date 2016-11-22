package codeexercise;
import java.io.*;
import java.util.*;

public class GameHelper {
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int comCount = 0;
	
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.println(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) {
				return null;
			}
		}
		catch (IOException e) {
			System.out.println("IOException " + e);
		}
		return inputLine.toLowerCase();
	}
	
	public List<String> placeShip(int comSize) {
		List<String> alphaCells = new ArrayList<>();
		String[] alphacoords = new String [comSize];
		String temp = null;
		int[] coords = new int[comSize];
		int attempts = 0;
		boolean posflag = false;
		int location = 0;
		
		comCount++;
		int incr = 1;
		if ((comCount % 2) == 1) {
			incr = gridLength;
		}
		
		while (!posflag & attempts++ < 200) {
			location = (int) (Math.random() * gridSize);
			System.out.println("trying location: " + location);
			int x = 0;
			posflag = true;
			while (posflag && x < comSize) {
				if (grid[location] == 0) {
					coords[x++] =location;
					location += incr;
					if (location >= gridSize) {
						posflag = false;
					}
					if (x > 0 && (location % gridLength == 0)) {
						posflag = false;
					}
					else {
						System.out.println("located at: " + location);
						posflag = false;
					}
				}
			}
			int i = 0;
			int row = 0;
			int column = 0;
			while (i < comSize) {
				grid[coords[i]] = 1;
				row = (int) (coords[i] / gridLength);
				column = coords[i] % gridLength;
				temp = String.valueOf(alphabet.charAt(column));
				alphaCells.add(temp.concat(Integer.toString(row)));
				i++;
			}
		}
		
		return alphaCells;
	}

	public static List<String> myplaceShip(int shipNumber) {
//		List<List<String>> result = new ArrayList<>();
		List<String> result = new ArrayList<>();
		Set<Integer> hash = new HashSet<>();
		while (hash.size() < shipNumber) {
//			get a random number of 0 ~ 49
			int randomInt = (int)(Math.random() * 49);
			if (!hash.contains(randomInt)) {
				hash.add(randomInt);
				result.add(numToCell(randomInt));
			}
		}
		
		return result;
	}
	
	private static String numToCell(int number) {
		final String alphabet = "abcdefg";
		int row = number / 7;
		int column = number % 7 + 1;
		char rowchar = alphabet.charAt(row);
		String tempsol = String.valueOf(rowchar) + String.valueOf(column);
		return tempsol;
	}
}

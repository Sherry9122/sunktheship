package codeexercise;

import java.util.ArrayList;
import java.util.List;

public class Ship {
	private List<String> locationCells = new ArrayList<>();
	private String name;
	
	public void setLocation(List<String> loc) {
		locationCells = loc;
	}
	
	public void setLocation(String location) {
		locationCells.add(location);
	}
	
	public void setName(String shipname) {
		name = shipname;
	}
	
	public String checkHit(String sguess) {
		String result = "miss";
		int index = locationCells.indexOf(sguess); //improve here
		if (index >= 0) {
			locationCells.remove(index);
			if (locationCells.isEmpty()) {
				result = "kill";
				System.out.println("The ship " + name + " is sunk");
			}
			else {
				result = "hit";
			}
		}
		//System.out.println(result);
		return result;
		
	}
}

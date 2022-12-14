package model;

import java.util.ArrayList;
import java.util.List;

public class ProgramData {

	private static List<Stone> stones = new ArrayList<>();
	private static List<Sign> signs = new ArrayList<>();
	
	/**
	 * Does nothing. Just satisfy my TOC.
	 */
	public ProgramData() {

	}

	/**
	 * Adds a stone to the program with its information. 
	 * 
	 * @param name the new stone's name.
	 * @param description the new stone's description of what it "does".
	 * @param imageURL the new stone's image URL.
	 * @param signs the new stone's "compatible" zodiac signs.
	 */
	public static void addStone(String name, String description, String imageURL, String signs) {
		if(searchStoneThread(name)) {
			System.out.println("La piedra ya existe");
		} else {
			stones.add(new Stone(name, description, imageURL, signs));
			sortStones();
		}
	}
	
	/**
	 * Searches for a stone by using its name.
	 * 
	 * @param stoneName the searched stone's name.
	 * @return true if the program find the stone. False otherwise.
	 */
	public static boolean searchStoneThread(String stoneName) {
		boolean result = false;
		
		int higherIndex = stones.size()-1;
		int lowerIndex = 0;
		
		while(lowerIndex <= higherIndex) {
			int middleIndex = (higherIndex+lowerIndex)/2;
			
			if(stoneName.equalsIgnoreCase(stones.get(middleIndex).getName())) {
				result = true;
				
				break;
			} else if(stoneName.compareToIgnoreCase(stones.get(middleIndex).getName()) < 0) {
				higherIndex = middleIndex-1;
			} else {
				lowerIndex = middleIndex+1;
			}
		}
		
		return result;
	}
	
	/**
	 * Sorts the list with all the stones in alphabetical order.
	 */
	private static void sortStones() {
		
	}
	
}

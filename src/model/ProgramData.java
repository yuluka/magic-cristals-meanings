package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgramData implements Serializable {

	/**
	 * Idk the function og that shit.
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String DATA_FILE_PATH = "data/stones.lashni";
	
	private static List<Cristal> stones = new ArrayList<>();
	private static List<Sign> signs = new ArrayList<>();
	
	/**
	 * Does nothing. Just satisfy my TOC.
	 */
	public ProgramData() {

	}

	/**
	 * Adds a stone to the program with its information if there is not, already, other
	 * stone with the same name.
	 * 
	 * @param name the new stone's name.
	 * @param description the new stone's description of what it "does".
	 * @param imageURL the new stone's image URL.
	 * @param signs the new stone's "compatible" zodiac signs.
	 */
	public static void addStone(String name, String description, String imageURL, String signs) {
		if(searchStone(name) != -1) {
			System.out.println("La piedra ya existe");
		} else {
			stones.add(new Cristal(name, description, imageURL, signs));
			
			System.out.println("Piedra agregada");
			
			sortStones();
			
			saveData();
		}
	}
	
	/**
	 * Searches for a stone by using its name and removes it from the stones list. If the 
	 * stone does not exist, informs it to the user.
	 * 
	 * @param name the stone's name.
	 */
	public static void removeStone(String name) {
		int stoneIndex = searchStone(name);
		
		if(stoneIndex == -1) {
			System.out.println("La piedra no existe");
		} else {
			stones.remove(stoneIndex);
			
			sortStones();
			
			saveData();
		}
	}
	
	/**
	 * Searches for a stone by using its name.
	 * 
	 * @param stoneName the searched stone's name.
	 * @return the index where the stone is placed. -1 if the stone doesn't exist.
	 */
	public static int searchStone(String stoneName) {
		int result = -1;
		
		int higherIndex = stones.size()-1;
		int lowerIndex = 0;
		
		while(lowerIndex <= higherIndex) {
			int middleIndex = (higherIndex+lowerIndex)/2;
			
			if(stoneName.equalsIgnoreCase(stones.get(middleIndex).getName())) {
				result = middleIndex;
				
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
		Collections.sort(stones, (A, B) -> {
			return A.getName().compareTo(B.getName());
		});
	}
	
	/**
	 * Saves the stones data in a ".lashni" file.
	 * Also, makes it in other thread to prevent the program to slowing down. 
	 */
	public static void saveData() {
		new Thread(() -> {
			try {
				File file = new File(DATA_FILE_PATH);
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(stones);
				
				oos.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	/**
	 * Fills the list of the stones, with the data placed in the selected file.
	 * Also, makes it in other thread to prevent the program to slowing down. 
	 */
	@SuppressWarnings("unchecked")
	public static void loadData() {
		new Thread(() -> {
			try {
				File file = new File(DATA_FILE_PATH);
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object auxObj = ois.readObject();
				stones = (ArrayList<Cristal>) auxObj;
				
				ois.close();

			} catch (FileNotFoundException e) {
				System.out.println("El archivo no existe");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}).start();
		
		System.out.println("Holi");
	}
	
	public static void printStones() {
		for (int i = 0; i < stones.size(); i++) {
			System.out.println(stones.get(i).getName());
		}
	}
	
	public static List<Cristal> getStones() {
		return stones;
	}

	public static List<Sign> getSigns() {
		return signs;
	}
}

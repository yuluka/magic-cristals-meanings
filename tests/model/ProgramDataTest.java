package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProgramDataTest {

	public void setupStage1() {
		ProgramData.addStone("Amatista", null, null, null);
		ProgramData.addStone("Berilio", null, null, null);
		ProgramData.addStone("Cornalina", null, null, null);
	}
	
	public void setupStage2() {
		ProgramData.addStone("Obsidiana", null, null, null);
		ProgramData.addStone("Berilio", null, null, null);
		ProgramData.addStone("Cornalina", null, null, null);
		ProgramData.addStone("Andesita", null, null, null);
	}
	
	@Test
	void searchTest1() {
		setupStage1();
		
		assertNotEquals(-1, ProgramData.searchStone("Amatista"));
	}

	@Test
	void searchTest2() {
		setupStage1();
		
		assertNotEquals(-1, ProgramData.searchStone("Berilio"));
	}
	
	@Test
	void searchTest3() {
		setupStage1();
		
		assertNotEquals(-1, ProgramData.searchStone("Cornalina"));
	}
	
	@Test
	void sortTest1() {
		setupStage2();
		
		assertEquals("Amatista", ProgramData.getStones().get(0).getName());
	}

}

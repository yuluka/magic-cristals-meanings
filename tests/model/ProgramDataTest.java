package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProgramDataTest {

	public void setupStage1() {
		ProgramData.addStone("Amatista", null, null, null);
		ProgramData.addStone("Berilio", null, null, null);
		ProgramData.addStone("Cornalina", null, null, null);
	}
	
	@Test
	void searchTest() {
		setupStage1();
		
		assertTrue(ProgramData.searchStoneThread("Cornalina"));
	}

}

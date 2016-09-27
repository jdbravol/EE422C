package assignment3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCases {
	
	@Test
	public static void EmptyCase(){
		ArrayList<String> nullArray = new ArrayList<String>();
		assertEquals(true, nullArray == Main.getWordLadderDFS("aloof", "smart"));
		assertEquals(true, nullArray == Main.getWordLadderBFS("aloof", "smart"));
	}

}

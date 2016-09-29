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

	@Test
	public static void GeneralCase(){
		//ArrayList<String> nullArray = new ArrayList<String>();
		int count = 9;
		assertEquals(true, 0 < Main.getWordLadderDFS("smart", "money").size()); //this tells us if the DFS reached the end word
		assertEquals(true, count >= Main.getWordLadderBFS("smart", "money").size() - 2);//we know the ladder should be at most 9 because of the pdf
	}
	@Test
	public static void SameWordCase(){
		assertEquals(true, 1 == Main.getWordLadderDFS("smart", "smart").size()); //a 0 rung word ladder 
		assertEquals(true, 1 == Main.getWordLadderBFS("smart", "smart").size());//
	}
}

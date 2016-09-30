package assignment3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCases {
	
	@Test
	public void EmptyCase(){
		ArrayList<String> nullArray = new ArrayList<String>();
		assertEquals(true, nullArray == Main.getWordLadderDFS("aloof", "smart"));
		assertEquals(true, nullArray == Main.getWordLadderBFS("aloof", "smart"));
	}

	@Test
	public void aloofToOther(){
		assertEquals(true, null == Main.getWordLadderDFS("aloof", "smart"));
		assertEquals(true, null == Main.getWordLadderBFS("aloof", "smart"));
	}

	@Test
	public void otherToAloof(){
		assertEquals(true, null == Main.getWordLadderDFS("smart", "aloof"));
		assertEquals(true, null == Main.getWordLadderBFS("smart", "aloof"));
	}
	
	@Test
	public void StackOverflow (){
		assertEquals(true, 0 < Main.getWordLadderBFS("stone", "smart").size());	
		assertEquals(true, 0 < Main.getWordLadderDFS("stone", "smart").size());
	}
	
	@Test
	public void GeneralCase(){
		//ArrayList<String> nullArray = new ArrayList<String>();
		int count = 9;
		assertEquals(true, 0 < Main.getWordLadderDFS("smart", "money").size()); //this tells us if the DFS reached the end word
		assertEquals(true, count >= Main.getWordLadderBFS("smart", "money").size() - 2);//we know the ladder should be at most 9 because of the pdf
	}
	
	@Test
	public void SameWordCase(){
		ArrayList<String> sameArray = new ArrayList<String>();
		sameArray.add("smart");
		assertEquals(true, 1 == Main.getWordLadderDFS("smart", "smart").size()); //a 0 rung word ladder 
		assertEquals(true, 1 == Main.getWordLadderBFS("smart", "smart").size());//
	}
	
	@Test
	public void GoingToAloofWords(){
		ArrayList<String> nullArray = new ArrayList<String>();
		assertEquals(true, nullArray == Main.getWordLadderDFS("smart", "aloof"));
		assertEquals(true, nullArray == Main.getWordLadderBFS("smart", "aloof"));

	}
	
	
}

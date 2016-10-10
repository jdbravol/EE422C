package assignment3;

import java.util.ArrayList;

import org.junit.Test;

public class TestCases {
	

	@Test
	public void aloofToOther(){
		assert(null == Main.getWordLadderBFS("aloof", "smart"));
		assert(1 == Main.getWordLadderDFS("aloof", "smart").size());
	}

	@Test
	public void otherToAloof(){
		assert(null == Main.getWordLadderBFS("smart", "aloof"));
		assert(1 == Main.getWordLadderDFS("smart", "aloof").size());
	}
	
	@Test
	public void StackOverflow (){
		assert( 0 < Main.getWordLadderBFS("stone", "smart").size());	
		assert( 0 < Main.getWordLadderDFS("stone", "smart").size());
	}
	
	@Test
	public void GeneralCase(){
		//ArrayList<String> nullArray = new ArrayList<String>();
		int count = 9;
		assert( 0 < Main.getWordLadderDFS("smart", "money").size()); //this tells us if the DFS reached the end word
		assert( count >= Main.getWordLadderBFS("smart", "money").size() - 2);//we know the ladder should be at most 9 because of the pdf
	}
	
	@Test
	public void SameWordCase(){
		ArrayList<String> sameArray = new ArrayList<String>();
		sameArray.add("smart");
		assert( 1 == Main.getWordLadderDFS("smart", "smart").size()); //a 0 rung word ladder 
		assert( 1 == Main.getWordLadderBFS("smart", "smart").size());//
	}
	
	
	
}

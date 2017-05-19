import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author petlid
 *
 */
public class FrameTest {
	
	/**
	 * Test method for {@link Frame#Frame(int[])}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testFrameAbove10() 
	{
		int[] input = { 9, 2 };
				
		Frame instance = new Frame(input);
	}
	
	
	/**
	 * Test method for {@link Frame#Frame(int[])}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testFrameFewThrows() 
	{
		int[] input = { 1 };
				
		Frame instance = new Frame(input);
	}
	
	
	/**
	 * Test method for {@link Frame#Frame(int[])}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testFrameManyThrows() 
	{
		int[] input = { 1, 2, 3 };
				
		Frame instance = new Frame(input);
	}
	
	/**
	 * Test method for {@link Frame#Frame(int[])}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testFrameNegativeInput() 
	{
		int[] input = { -1, 2 };
				
		Frame instance = new Frame(input);
	}
	

	/**
	 * Test method for {@link Frame#getFrame()}.
	 */
	@Test
	public void testGetFrame() 
	{
		int[] input = { 1, 2 };
		int[] expected = { input[0], input[1] };
				
		Frame instance = new Frame(input);
		
		int[] output = instance.getFrame();
		
		assertArrayEquals(expected, output);
	}
	
	@Test
	public void testGetScore() 
	{
		int[] input = { 0, 7 };
		int expected = 7;
		
		Frame frame = new Frame(input);
		
		int output = frame.getScore();
		
		assertEquals(expected, output);		
	}
	
	@Test
	public void testIsStrikeNotStrike()
	{
		int[] input = { 0, 10 };
		
		boolean expected = false;
		
		Frame instance = new Frame(input);
		
		boolean output = instance.isStrike();
		
		assertEquals(expected, output);
	}
	
	@Test
	public void testIsStrikeIsStrike()
	{
		int[] input = { 10, 0 };
		
		boolean expected = true;
		
		Frame instance = new Frame(input);
		
		boolean output = instance.isStrike();
		
		assertEquals(expected, output);
	}
	
	
	@Test
	public void testIsSpareNotSpare()
	{
		int[] input = { 2, 7 };
		
		boolean expected = false;
		
		Frame instance = new Frame(input);
		
		boolean output = instance.isSpare();
		
		assertEquals(expected, output);		
	}
	
	
	@Test
	public void testIsSpareIsSpare()
	{
		int[] input = { 2, 8 };
		
		boolean expected = true;
		
		Frame instance = new Frame(input);
		
		boolean output = instance.isSpare();
		
		assertEquals(expected, output);		
	}
	
	
//	@Test
//	public void testGetScoreSpare()
//	{
//		int[] input = { 2, 8 };
//		int expected = 12;
//		
//		Frame[] instance = { new Frame(input) };
//		
//		int output = Frame.getScoreOfSequence(instance);
//		
//		assertEquals(expected, output);		
//	}
//	
}

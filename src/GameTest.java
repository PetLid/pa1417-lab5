import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author petlid
 *
 */
public class GameTest {
	
	private Frame[] frames =
	{
		new Frame(new int[] {0, 1}),
		new Frame(new int[] {2, 8}),
		new Frame(new int[] {4, 2}),
		new Frame(new int[] {2, 7}),
		new Frame(new int[] {1, 9}),
		new Frame(new int[] {6, 1}),
		new Frame(new int[] {1, 2}),
		new Frame(new int[] {2, 3}),
		new Frame(new int[] {4, 0}),
		new Frame(new int[] {6, 0})				
	};

	/**
	 * Test method for {@link Game#Game(Frame[])}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public final void testGameFewFrames() {
						
		Frame[] input = 
		{
			new Frame(new int[] {0, 1}),
			new Frame(new int[] {2, 8})
		};
		
		Game instance = new Game(input);
	}

	/**
	 * Test method for {@link Game#Game(Frame[])}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public final void testGameManyFrames() {
				
		Frame[] input = 
		{
			new Frame(new int[] {0, 1}),
			new Frame(new int[] {2, 8}),
			new Frame(new int[] {4, 2}),
			new Frame(new int[] {2, 7}),
			new Frame(new int[] {1, 9}),
			new Frame(new int[] {6, 1}),
			new Frame(new int[] {1, 2}),
			new Frame(new int[] {2, 3}),
			new Frame(new int[] {4, 0}),
			new Frame(new int[] {6, 0}),
			new Frame(new int[] {8, 1})
		};
		
		Game instance = new Game(input);
	}
	
	/**
	 * Test method for {@link Game#Game(Frame[])}.
	 */
	@Test
	public final void testGame() {
		
		Frame[] expected = this.frames;
		
		Game instance = new Game(this.frames);
		
		Frame[] output = instance.getFrames();
		
		assertArrayEquals(expected, output);
	}
	
	@Test
	public final void testGetScore() {
		
		int[][] input = 
		{
			new int[] {0, 1},
			new int[] {1, 8},
			new int[] {4, 2},
			new int[] {2, 7},
			new int[] {0, 9},
			new int[] {6, 1},
			new int[] {1, 2},
			new int[] {2, 3},
			new int[] {4, 0},
			new int[] {6, 0}			
		};
						
		Frame[] frames = 
		{
			new Frame(input[0]),
			new Frame(input[1]),
			new Frame(input[2]),
			new Frame(input[3]),
			new Frame(input[4]),
			new Frame(input[5]),
			new Frame(input[6]),
			new Frame(input[7]),
			new Frame(input[8]),
			new Frame(input[9])			
		};
		
		int expected = 0;
		
		for (int i = 0; i < input.length; i++)
		{
			expected += input[i][0] + input[i][1];
		}
				
		Game instance = new Game(frames);
		
		int output = instance.getScore();
				
		assertEquals(expected, output);
	}

	@Test
	public final void testGetScoreStrike() {
		
		int[][] input = 
		{
			new int[] {0, 1},
			new int[] {1, 8},
			new int[] {4, 2},
			new int[] {2, 7},
			new int[] {0, 9},
			new int[] {6, 1},
			new int[] {10, 0},
			new int[] {2, 3},
			new int[] {4, 0},
			new int[] {6, 0}		
		};
						
		Frame[] frames = 
		{
			new Frame(input[0]),
			new Frame(input[1]),
			new Frame(input[2]),
			new Frame(input[3]),
			new Frame(input[4]),
			new Frame(input[5]),
			new Frame(input[6]),
			new Frame(input[7]),
			new Frame(input[8]),
			new Frame(input[9])			
		};
		
		int expected = 0;
		
		for (int i = 0; i < input.length; i++)
		{
			expected += input[i][0] + input[i][1];
		}
		
		expected += 5;
				
		Game instance = new Game(frames);
		
		int output = instance.getScore();
		
		assertEquals(expected, output);
	}

	@Test
	public final void testGetScoreSpare() {
		
		int[][] input = 
		{
			new int[] {0, 1},
			new int[] {1, 8},
			new int[] {4, 2},
			new int[] {2, 7},
			new int[] {0, 9},
			new int[] {6, 4},
			new int[] {1, 4},
			new int[] {2, 3},
			new int[] {4, 0},
			new int[] {6, 0}		
		};
						
		Frame[] frames = 
		{
			new Frame(input[0]),
			new Frame(input[1]),
			new Frame(input[2]),
			new Frame(input[3]),
			new Frame(input[4]),
			new Frame(input[5]),
			new Frame(input[6]),
			new Frame(input[7]),
			new Frame(input[8]),
			new Frame(input[9])			
		};
		
		int expected = 0;
		
		for (int i = 0; i < input.length; i++)
		{
			expected += input[i][0] + input[i][1];
		}
		
		expected += 1;
				
		Game instance = new Game(frames);
		
		int output = instance.getScore();
		
		assertEquals(expected, output);
	}

	@Test
	public void testGetScoreSpareFollowsStrike()
	{		
		int[][] input = 
		{
			new int[] {0, 1},
			new int[] {1, 8},
			new int[] {4, 2},
			new int[] {2, 7},
			new int[] {0, 9},
			new int[] {6, 1},
			new int[] {10, 0},
			new int[] {1, 9},
			new int[] {4, 0},
			new int[] {6, 0}		
		};
						
		Frame[] frames = 
		{
			new Frame(input[0]),
			new Frame(input[1]),
			new Frame(input[2]),
			new Frame(input[3]),
			new Frame(input[4]),
			new Frame(input[5]),
			new Frame(input[6]),
			new Frame(input[7]),
			new Frame(input[8]),
			new Frame(input[9])			
		};
		
		int expected = 0;
		
		for (int i = 0; i < input.length; i++)
		{
			expected += input[i][0] + input[i][1];
		}
		
		expected += 10 + 4;
	
		Game instance = new Game(frames);
		
		int output = instance.getScore();
		
		assertEquals(expected, output);		
	}
	
	@Test
	public void testGetScoreMultipleStrikes()
	{
		int[][] input = 
			{
				new int[] {0, 1},
				new int[] {1, 8},
				new int[] {4, 2},
				new int[] {2, 7},
				new int[] {0, 9},
				new int[] {6, 1},
				new int[] {10, 0},
				new int[] {10, 0},
				new int[] {4, 0},
				new int[] {6, 0}		
			};
							
			Frame[] frames = 
			{
				new Frame(input[0]),
				new Frame(input[1]),
				new Frame(input[2]),
				new Frame(input[3]),
				new Frame(input[4]),
				new Frame(input[5]),
				new Frame(input[6]),
				new Frame(input[7]),
				new Frame(input[8]),
				new Frame(input[9])			
			};
			
			int expected = 0;
			
			for (int i = 0; i < input.length; i++)
			{
				expected += input[i][0] + input[i][1];
			}
			
			expected += 18;
					
			Game instance = new Game(frames);
			
			int output = instance.getScore();
			
			assertEquals(expected, output);
	}

	@Test
	public void testGetScoreMultipleSpares()
	{
		int[][] input = 
			{
				new int[] {0, 1},
				new int[] {1, 9},
				new int[] {9, 1},
				new int[] {3, 6},
				new int[] {0, 9},
				new int[] {6, 1},
				new int[] {1, 0},
				new int[] {2, 0},
				new int[] {4, 0},
				new int[] {6, 0}		
			};
							
			Frame[] frames = 
			{
				new Frame(input[0]),
				new Frame(input[1]),
				new Frame(input[2]),
				new Frame(input[3]),
				new Frame(input[4]),
				new Frame(input[5]),
				new Frame(input[6]),
				new Frame(input[7]),
				new Frame(input[8]),
				new Frame(input[9])			
			};
			
			int expected = 0;
			
			for (int i = 0; i < input.length; i++)
			{
				expected += input[i][0] + input[i][1];
			}
			
			expected += 9 + 3;
					
			Game instance = new Game(frames);
			
			int output = instance.getScore();
			
			assertEquals(expected, output);
	}

	@Test
	public void testLastFrameSpare()
	{
		Frame[] frames = 
			{
				new Frame(new int[] {0, 1}),
				new Frame(new int[] {1, 8}),
				new Frame(new int[] {6, 1}),
				new Frame(new int[] {3, 6}),
				new Frame(new int[] {0, 9}),
				new Frame(new int[] {6, 1}),
				new Frame(new int[] {1, 0}),
				new Frame(new int[] {2, 0}),
				new Frame(new int[] {4, 0}),
				new Frame(new int[] {9, 1})			
			};
			
			int bonus_shot = 5;
			
			int expected = 59 + bonus_shot;
					
			Game instance = new Game(frames, bonus_shot);
			
			int output = instance.getScore();
			
			assertEquals(expected, output);
	}
	
	@Test
	public void testLastFrameStrike()
	{
		Frame[] frames = 
			{
				new Frame(new int[] {0, 1}),
				new Frame(new int[] {1, 8}),
				new Frame(new int[] {6, 1}),
				new Frame(new int[] {3, 6}),
				new Frame(new int[] {0, 9}),
				new Frame(new int[] {6, 1}),
				new Frame(new int[] {1, 0}),
				new Frame(new int[] {2, 0}),
				new Frame(new int[] {4, 0}),
				new Frame(new int[] {10, 0})			
			};
			
			int bonus_shot1 = 2, bonus_shot2 = 6;
			
			int expected = 59 + bonus_shot1 + bonus_shot2;
					
			Game instance = new Game(frames, bonus_shot1, bonus_shot2);
			
			int output = instance.getScore();
			
			assertEquals(expected, output);
	}
}
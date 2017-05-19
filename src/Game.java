public class Game 
{
	private Frame[] frames;
	
	Game(Frame[] frames)
	{
		if (frames.length != 10)
		{
			throw new IllegalArgumentException("Incorrect amount of frames");
		}
		
		this.frames = frames;
	}
	
	public Frame[] getFrames()
	{
		return this.frames;
	}
	
	public int getScore()
	{	
		int score = 0;
		boolean isLast = false;
		
		for(int i = 0; i < frames.length; i++)
		{
			isLast = i == frames.length - 1;
			
			// Strike and not last
			if (frames[i].isStrike() && !isLast)
			{
				// Subsequent throw is strike and not last
				if (frames[i+1].isStrike() && i < frames.length - 2)
				{
					score += frames[i+2].getFrame()[0];
				}
				
				score += frames[i+1].getScore();
			}
			
			// Spare and not last
			else if (frames[i].isSpare() && !isLast)
			{
				score += frames[i+1].getFrame()[0];
			}
			
			score += frames[i].getScore();
		}
		
		return score;
	}
}

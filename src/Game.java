public class Game 
{
	private Frame[] frames;
	int[] bonus_shots = new int[2];
	
	Game(Frame[] frames)
	{
		if (frames.length != 10)
		{
			throw new IllegalArgumentException("Incorrect amount of frames");
		}
		
		this.frames = frames;
	}
	
	Game(Frame[] frames, int bonus_shot)
	{
		this(frames);
		
		this.bonus_shots[0] = bonus_shot;
	}
	
	Game(Frame[] frames, int bonus_shot1, int bonus_shot2)
	{
		this(frames);
		
		this.bonus_shots[0] = bonus_shot1;
		this.bonus_shots[1] = bonus_shot2;
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
			if (frames[i].isStrike())
			{
				 if (!isLast)
				 {
					 // Subsequent throw is strike and not last
					 if (frames[i+1].isStrike() && i < frames.length - 2)
					 {
						 score += frames[i+2].getFrame()[0];
					 }
					
					 score += frames[i+1].getScore();
				 }
				 else
				 {
					 score += this.bonus_shots[0] + this.bonus_shots[1];
				 }
			}
			
			// Spare and not last
			else if (frames[i].isSpare())
			{
				if (!isLast)
				{
					score += frames[i+1].getFrame()[0];
				}
				else
				{
					score += this.bonus_shots[0];
				}
			}
			
			score += frames[i].getScore();
		}
		
		return score;
	}
}

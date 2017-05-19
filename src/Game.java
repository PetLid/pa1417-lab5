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
			
		int[] scores = new int[10];
		
		for(int i = frames.length - 1; i >= 0; i--)
		{
			scores[i] = 0;
			
			isLast = i == frames.length - 1;
			
			if (isLast)
			{
				if (frames[i].isSpare())
				{
					scores[i] += this.bonus_shots[0];
				}
				
				if (frames[i].isStrike())
				{
					scores[i] += this.bonus_shots[0] + this.bonus_shots[1];
				}
			}
			else
			{
				if (frames[i].isSpare())
				{
					score += frames[i+1].getFrame()[0];
				}
				
				else if (frames[i].isStrike())
				{
					scores[i] += Math.min(scores[i+1], 20);
				}
			}
			
			scores[i] += frames[i].getScore();
			
			score += scores[i];
		}
		
		
		return score;
	}
}

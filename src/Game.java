
public class Game {

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
		int score = Frame.getScoreOfSequence(this.frames);
		
		return score;
	}
}

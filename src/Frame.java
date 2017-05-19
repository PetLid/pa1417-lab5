
public class Frame {
	
	private int[] _throws;
	private boolean isSpare = false;
	private boolean isStrike = false;
	
	/**
	 * Creates a frame.
	 * A frame consists of two throws representing 
	 *  the number of pins knocked down.
	 * These numbers range from 0-10,
	 *	their sum cannot exceed 10.
	 * 
	 * @param _throws, an integer array representing the 
	 * 	number of knocked down pins per throw.
	 */
	Frame(int[] _throws)
	{
		if (_throws.length != 2)
		{
			throw new IllegalArgumentException("Incorrect number of throws");
		}
		
		if (_throws[0] < 0 || _throws[1] < 0)
		{
			throw new IllegalArgumentException("Negative numbers not allowed");
		}
		
		if (_throws[0] + _throws[1] > 10)
		{
			throw new IllegalArgumentException("Frame score exceeds 10");
		}
				
		this._throws = _throws;
		
		if (this._throws[0] == 10)
		{
			this.isStrike = true;
		}
		
		else if (this.getRawSum() == 10)
		{
			this.isSpare = true;
		}
	}

	
	
	int[] getFrame()
	{
		return _throws;
	}
	
	
	int getRawSum()
	{
		return _throws[0] + _throws[1];
	}
	

//	int getScore()
//	{
//		int score = 0;
//		
//		// Spare
//		if (isSpare())
//		{
//			score = 10 + _throws[0];
//		}
//		else 
//		{
//			score = getRawSum();
//		}
//		
//		return score;
//	}
//	
	
	static int getScoreOfSequence(Frame[] frames)
	{
		int score = 0;
		boolean isLast = false;
		
		
		for(int i = 0; i < frames.length; i++)
		{
			isLast = i == frames.length - 1;
			
			// Strike and not last
			if (frames[i].isStrike && !isLast)
			{
				// Subsequent throw is strike and not last
				if (frames[i+1].isStrike && i < frames.length - 2)
				{
					score += frames[i+2]._throws[0];
				}
				
				score += frames[i+1].getRawSum();
				
				//score += frames[i+1].getScore(); // getScoreOfSequence(new Frame[] {frames[i+1]});
			}
			
			// Spare and not last
			else if (frames[i].isSpare() && !isLast)
			{
				score += frames[i+1]._throws[0];
			}
			
			score += frames[i].getRawSum();
		}
		
		return score;
	}

	public boolean isSpare() {
		return isSpare;
	}	
	
	public boolean isStrike() {
		return isSpare;
	}
}

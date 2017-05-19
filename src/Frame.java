
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
	

	int getScore()
	{
		return _throws[0] + _throws[1];
	}
	
	public boolean isSpare() 
	{
		return isSpare;
	}	
	
	public boolean isStrike() 
	{
		return isStrike;
	}
}

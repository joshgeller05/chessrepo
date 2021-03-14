package src;
public class Spot implements Comparable{ 
    private Piece piece; 
    private int x; 
    private int y; 
  
    public Spot(int x, int y, Piece piece) 
    { 
        this.setPiece(piece); 
        this.setX(x); 
        this.setY(y); 
    } 
  
    /**
     * 
     * @return - return the spots piece
     */
    public Piece getPiece() 
    { 
        return this.piece; 
    } 
  
    /**
     * sets the spots piece
     * @param p - piece for the spot
     */
    public void setPiece(Piece p) 
    { 
        this.piece = p; 
    } 
  
    /**
     * 
     * @return - the spots x position
     */
    public int getX() 
    { 
        return this.x; 
    } 
  
    /**
     * sets the spots x position
     * @param x position to set
     */
    public void setX(int x) 
    { 
        this.x = x; 
    } 
  
    /**
     * 
     * @return - the spots y position
     */
    public int getY() 
    { 
        return this.y; 
    } 
  
    /**
     * sets the spots y position
     * @param y position to set
     */
    public void setY(int y) 
    { 
        this.y = y; 
    } 
    
    /**
     * convert the given position to a letter
     * @param i - integer to convert to a letter
     * @return - letter for given integer
     */
    public static String toAlphabetic(int i) {
        if( i<0 ) {
            return "-"+toAlphabetic(-i-1);
        }

        int quot = i/26;
        int rem = i%26;
        char letter = (char)((int)'A' + rem);
        if( quot == 0 ) {
            return ""+letter;
        } else {
            return toAlphabetic(quot-1) + letter;
        }
    }
    
    /**
     * 
     * @return - whether or not spot is valid
     */
    public boolean isValid()
    {
    	boolean result = true;
    	
    	if(this.getX() > 8 || this.getX() < 0 || this.getY() > 8 || this.getY() < 0)
    	{
    		result = false;
    	}
    	
    	return result;
    }

	@Override
	public String toString() {
		return toAlphabetic(y)+String.valueOf(x+1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((piece == null) ? 0 : piece.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/**
	 * 
	 * @param spot as a string
	 * @return - if this spot is equal to given string spot
	 */
	public boolean equals(String spot)
	{
		boolean result = false;
		
		String column = (String.valueOf(spot.charAt(0)).toLowerCase());
		int row = Integer.parseInt(String.valueOf(spot.charAt(1)))-1;
		int col = this.convertColumn(column);
		if(this.getX() == row && this.getY() == col)
		{
			result = true;
		}
		
		return result;
	}
	
    @Override
    public boolean equals(Object other)
    {
        if (other == null || getClass() != other.getClass()) {
        	return false;
        }
        else
        {
            Spot spot = (Spot) other;
            return x == spot.x &&
                    y == spot.y;        	
        }

    }

	@Override
	public int compareTo(Object other) {
		int compareY = ((Spot) other).getY();
		
		return this.getY() - compareY;
	}
	
	/**
	 * 
	 * @param p - piece to compare
	 * @return - if this spot has same color piece as given piece
	 */
	public boolean hasSameColorPiece(Piece p)
	{
		if(this.getPiece() != null && p != null)
		{
	        if (this.getPiece().isWhite() == p.isWhite()) {
	        	//cant move ontop of piece of the same color
	            return true;
	        }
		}
        return false;
	}
	
	/**
	 * 
	 * @param column - column as a string
	 * @return column as an int
	 */
    public int convertColumn(String column)
    {
    	char[] x = column.toCharArray();
    	int result = -1;
    	for(char c : x){
    	    int temp = (int)c;
    	    int temp_integer = 96; //for lower case
    	    if(temp<=122 & temp>=97)
    	        result =temp-temp_integer;
    	}
    	return result - 1;
    }
} 
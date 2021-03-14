package src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Piece { 

	private boolean white = false; 
    private int y = -1;
    private int x = -1;
    protected ArrayList<Spot> moves = new ArrayList<Spot>();
    public Piece(boolean white) 
    { 
        this.setWhite(white); 
    } 
  
    /**
     * 
     * @return - whether this piece is white or not
     */
    public boolean isWhite() 
    { 
        return this.white; 
    } 
  
    /**
     * set whether this piece is white or not
     * @param white
     */
    public void setWhite(boolean white) 
    { 
        this.white = white; 
    } 
    
    /**
     * resets piece's moves
     */
    public void resetMoves()
    {
    	moves.clear();
    }
    
    /**
     * 
     * @param board
     * @return list of moves this piece on a given board
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<Spot> getMoves(Board board) throws Exception {
		Spot start = new Spot(this.getX(),this.getY(),this);
		for(Spot spot : board.getSpots())
		{
			//check that the spot does not equal where the piece is
			//check that the spot is valid
			if(!start.equals(spot) && spot.isValid() && !spot.hasSameColorPiece(this))
			{
				if(this.canMove(start, spot, board))
				{
					moves.add(spot);
				}	
			}
		}
		Collections.sort(moves);
		return moves;
	} 
	
	/**
	 * implemented in each piece
	 * @param start - where piece starts move
	 * @param end - where piece ends move
	 * @param board - given board
	 * @return - whether piece can move to end spot
	 * @throws Exception
	 */
	public abstract boolean canMove(Spot start, Spot end, Board board) throws Exception;

    public abstract PieceType type();
    
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	} 
	
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + y;
		result = prime * result + x;
		result = prime * result + (white ? 1231 : 1237);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (y != other.y)
			return false;
		if (x != other.x)
			return false;
		if (white != other.white)
			return false;
		if(type() != other.type())
			return false;
		return true;
	}
	
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

	public String toString()
	{
		return this.type()+" "+toAlphabetic(this.y)+(this.x+1);
	}
    
} 
package src;
import java.util.ArrayList;
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
  
    public boolean isWhite() 
    { 
        return this.white; 
    } 
  
    public void setWhite(boolean white) 
    { 
        this.white = white; 
    } 
    
	public List<Spot> getMoves(Board board) throws Exception {
		Spot start = new Spot(this.getX(),this.getY(),this);
		for(Spot spot : board.getSpots())
		{
			if(!start.equals(spot))
			{
				if(this.canMove(start, spot, board))
				{
					moves.add(spot);
				}	
			}
		}
		return moves;
	} 
	
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
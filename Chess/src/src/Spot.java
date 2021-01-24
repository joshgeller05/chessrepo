package src;
public class Spot { 
    private Piece piece; 
    private int x; 
    private int y; 
  
    public Spot(int x, int y, Piece piece) 
    { 
        this.setPiece(piece); 
        this.setX(x); 
        this.setY(y); 
    } 
  
    public Piece getPiece() 
    { 
        return this.piece; 
    } 
  
    public void setPiece(Piece p) 
    { 
        this.piece = p; 
    } 
  
    public int getX() 
    { 
        return this.x; 
    } 
  
    public void setX(int x) 
    { 
        this.x = x; 
    } 
  
    public int getY() 
    { 
        return this.y; 
    } 
  
    public void setY(int y) 
    { 
        this.y = y; 
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
    
    public boolean equals(Spot other)
    {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Spot spot = (Spot) other;
        return x == spot.x &&
                y == spot.y;
    }

	@Override
	public String toString() {
		return toAlphabetic(y)+String.valueOf(x+1);
	}
} 
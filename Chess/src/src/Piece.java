package src;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece { 

	private boolean white = false; 
    private int column = -1;
    private int row = -1;
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
    
    public abstract List<Spot> getMoves(Board board) throws Exception;

    public abstract PieceType type();
    
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	} 
	
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
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
		if (column != other.column)
			return false;
		if (row != other.row)
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
		return this.type()+" "+toAlphabetic(this.column)+" "+this.row+" is white: "+this.isWhite();
	}
    
} 
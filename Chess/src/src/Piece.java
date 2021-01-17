package src;
import java.util.List;

public abstract class Piece { 

	private boolean white = false; 
    private String column = "";
    private int row = -1;
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
    
    public abstract List<Spot> canMove(Board board);

    public abstract PieceType type();
    
	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
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
		result = prime * result + ((column == null) ? 0 : column.hashCode());
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
		if (column == null) {
			if (other.column != null)
				return false;
		} else if (!column.equals(other.column))
			return false;
		if (row != other.row)
			return false;
		if (white != other.white)
			return false;
		if(type() != other.type())
			return false;
		return true;
	}

	public String toString()
	{
		return this.type()+" "+this.column+" "+this.row+" is white: "+this.isWhite();
	}
    
} 
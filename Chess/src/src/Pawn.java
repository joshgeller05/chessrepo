package src;

public class Pawn extends Piece { 
  
    public Pawn(boolean white) 
    { 
        super(white); 
    }
	
	public boolean canMove(Spot start, Spot end, Board board) throws Exception
	{	  		  
		  if (end.getPiece() != null && start.getY() == end.getY()) {
				// can't kill piece moving forwards
				return false;
		  }
		  
		  //this is checking if the pawn can move 2 spots forward
		  if (!isMoved() && start.getY() == end.getY() && Math.abs(end.getX() - start.getX()) <= 2) {
				if (end.getX() > start.getX() && isWhite()) {
					 return true;
				} else {
					 return end.getX() < start.getX() && !isWhite();
				}
		   
		  } //this is checking if the pawn can move 1 spot forward 
		  else if (start.getY() == end.getY() && Math.abs(start.getX() - end.getX()) < 2) {
				if (end.getX() > start.getX() && isWhite()) {
					 return true;
				} else
					 return end.getX() < start.getX() && !isWhite();
		  } //this is checking if the pawn can move diagonally forward left or right
		  else if (end.getY() == start.getY() - 1 || end.getY() == start.getY() + 1) {
				if (end.getPiece() != null && end.getPiece().isWhite() != isWhite()) {
					 return isWhite() ? end.getX() == start.getX() + 1 : end.getX() == start.getX() - 1;
				}
		  }
		  
		  return false;
	}
	
	public boolean isMoved()
	{
		boolean moved = true;
		if(isWhite())
		{
			if(this.getX() == 1)
			{
				moved = false;
			}
		}
		else
		{
			if(this.getX() == 6)
			{
				moved = false;
			}
		}
		return moved;
	}


	@Override
	public PieceType type() {
		return PieceType.PAWN;
	} 
  
}
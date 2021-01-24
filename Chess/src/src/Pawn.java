package src;
import java.util.List;

public class Pawn extends Piece { 
  
    public Pawn(boolean white) 
    { 
        super(white); 
    }

	public List<Spot> getMoves(Board board) throws Exception {
		Spot start = new Spot(this.getX(),this.getY(),this);
		for(Spot spot : board.getSpots())
		{
			if(canMove(start,spot))
			{
				moves.add(spot);
			}
		}
		return moves;
	} 
	
	public boolean canMove(Spot start, Spot end) throws Exception
	{
		  if (end.getX() > 8 || end.getX() < 0 || end.getY() > 8 || end.getY() < 0) {
				return false;
		  }

		  if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
				//Can't kill or move over piece of same color
				return false;
		  }
		  if (end.getPiece() != null && start.getX() == end.getX()) {
				// can't kill piece moving forwards
				return false;
		  }

		  if (start.getX() == end.getX() && Math.abs(end.getY() - start.getY()) <= 2) {
				if (end.getY() > start.getY() && isWhite()) {
					 return true;
				} else
					 return end.getY() < start.getY() && !isWhite();
		  } else if (start.getX() == end.getX() && Math.abs(start.getY() - end.getY()) < 2) {
				if (end.getY() > start.getY() && isWhite()) {
					 return true;
				} else
					 return end.getY() < start.getY() && !isWhite();
		  } else if (end.getX() == start.getX() - 1 || end.getX() == start.getX() + 1) {
				if (end.getPiece() != null && end.getPiece().isWhite() != isWhite()) {
					 return isWhite() ? end.getY() == start.getY() + 1 : end.getY() == start.getY() - 1;
				}
		  }

		  return false;
	}


	@Override
	public PieceType type() {
		return PieceType.PAWN;
	} 
  
}
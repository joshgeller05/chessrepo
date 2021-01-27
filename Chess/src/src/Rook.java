package src;
import java.util.List;

public class Rook extends Piece { 
    public Rook(boolean white) 
    { 
        super(white); 
    }
	
	public boolean canMove(Spot start, Spot end, Board board) throws Exception
	{
        if(end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                // can't kill piece of same color
                return false;
            }
        }
		if(start.getX() == end.getX())
		{
			//moving horizontally
			if(start.getY() > end.getY()) {
				for(int i = start.getY() - 1; i > end.getY(); i--) {
					Piece p = board.getSpot(start.getX(), i).getPiece();
					if(p != null) {
						//if there are pieces in the way
						return false;
					}
				}
			} else {
				for(int i = start.getY() + 1; i < end.getY(); i++) {
					Piece p = board.getSpot(start.getX(), i).getPiece();
					if (p != null) {
						//if there are pieces in the way
						return false;
					}
				}
			}
		}
		else if(start.getY() == end.getY())
		{
			//moving vertically
            if(start.getX() > end.getX()) {
                for(int i = start.getX() - 1; i > end.getX(); i--) {
                	Piece p = board.getSpot(i, start.getY()).getPiece();
                    if(p != null) {
                        //if there are pieces in the way
                        return false;
                    }
                }
            } else {
                for(int i = start.getX() + 1; i < end.getX(); i++) {
                	Piece p = board.getSpot(i, start.getY()).getPiece();
                    if (p != null) {
                        //if there are pieces in the way
                        return false;
                    }
                }
            }
		}
		else if(start.getY() != end.getY() || start.getX() != end.getX()) {
            return false;
        }

		return true;
	}

	@Override
	public PieceType type() {
		return PieceType.ROOK;
	} 
  
}
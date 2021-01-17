package src;
import java.util.List;

public class Rook extends Piece { 
  
    public Rook(boolean white) 
    { 
        super(white); 
    }

	@Override
	public List<Spot> getMoves(Board board) throws Exception {
		for(Spot spot : board.getSpots())
		{
			if(null != spot.getPiece()) //check if the spot contains an opposite colored piece
			{
				if(spot.getPiece().isWhite() != this.isWhite()) //not same color
				{
					canMove(spot,board);
				}
			}
			else //no piece is on spot
			{
				canMove(spot,board);
			}
		}
		return moves;
	} 
	
	public void canMove(Spot spot, Board board) throws Exception
	{
		
	}

	@Override
	public PieceType type() {
		return PieceType.ROOK;
	} 
  
}
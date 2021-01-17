package src;
import java.util.List;

public class Pawn extends Piece { 
  
    public Pawn(boolean white) 
    { 
        super(white); 
    }

	@Override
	public List<Spot> getMoves(Board board) throws Exception {
		for(Spot spot : board.getSpots())
		{
			canMove(spot,board);
		}
		return moves;
	} 
	
	public void canMove(Spot spot, Board board) throws Exception
	{
		Piece other = spot.getPiece();
		boolean isDiagonalOne = isSpotDiagnol(spot);
		if(other == null) //no piece in spot
		{
			boolean moveTwo = false;
			int spotX = spot.getX();
			int spotY = spot.getY();
			int pX = this.getRow();
			int pY = this.getColumn();
			//if theres not piece in the spot
			//check if the pawn is in its originating place
			//if its not only can move 1 place, if not move 2
			if(this.isWhite()) //if its white check the 2nd row, if its black check the 7th
			{
				if(this.getRow() == 2)
				{
					moveTwo = true;
				}
			}
			else
			{
				if(this.getRow() == 7)
				{
					moveTwo = true;
				}
				pX-=2;
			}
			
			
			if(spotX == pX && spotY == pY)
			{
				moves.add(spot);
			}
			
			if(moveTwo && !moves.contains(spot)) 
			{
				if(!isWhite())
				{
					pX-=1;
				}
				else
				{
					pX+=1;
				}
				
				if(spotX == pX && spotY == pY)
				{
					moves.add(spot);
				}

			}
			
		}
		else
		{
			//TODO: CONFIRM  THIS
			if(other.isWhite() != this.isWhite() && isDiagonalOne) //different colors
			{
				//if its diagonal one and theres a different color piece, take it
				moves.add(spot);
			}
		}
	}

	private boolean isSpotDiagnol(Spot spot) {
		int spotX = spot.getX();
		int spotY = spot.getY();
		int pX = this.getRow();
		int pY = this.getColumn();
		if((spotX ==pX && spotY == pY+1) || (spotX == pX && spotY == pY-1))
		{
			return true;
		}
		return false;
	}

	@Override
	public PieceType type() {
		return PieceType.PAWN;
	} 
  
}
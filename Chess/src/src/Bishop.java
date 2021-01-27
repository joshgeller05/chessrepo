package src;
import java.util.List;

public class Bishop extends Piece { 
  
    public Bishop(boolean white) 
    { 
        super(white); 
    }
	
	public boolean canMove(Spot start, Spot end, Board board) throws Exception
	{
		return false;
	}

	@Override
	public PieceType type() {
		return PieceType.BISHOP;
	} 
  
}
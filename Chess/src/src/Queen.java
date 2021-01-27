package src;
import java.util.List;

public class Queen extends Piece { 
  
    public Queen(boolean white) 
    { 
        super(white); 
    }

	@Override
	public PieceType type() {
		return PieceType.QUEEN;
	}

	@Override
	public boolean canMove(Spot start, Spot end, Board board) throws Exception {
		return false;
	} 
  
}
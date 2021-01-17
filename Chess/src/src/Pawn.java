package src;
import java.util.List;

public class Pawn extends Piece { 
  
    public Pawn(boolean white) 
    { 
        super(white); 
    }

	@Override
	public List<Spot> canMove(Board board) {
		return null;
	}

	@Override
	public PieceType type() {
		return PieceType.PAWN;
	} 
  
}
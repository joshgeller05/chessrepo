package src;
import java.util.List;

public class Rook extends Piece { 
  
    public Rook(boolean white) 
    { 
        super(white); 
    }

	@Override
	public List<Spot> canMove(Board board) {
		return null;
	}

	@Override
	public PieceType type() {
		return PieceType.ROOK;
	} 
  
}
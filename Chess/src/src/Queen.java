package src;
import java.util.List;

public class Queen extends Piece { 
  
    public Queen(boolean white) 
    { 
        super(white); 
    }

	@Override
	public List<Spot> getMoves(Board board) {
		return null;
	}

	@Override
	public PieceType type() {
		return PieceType.QUEEN;
	} 
  
}
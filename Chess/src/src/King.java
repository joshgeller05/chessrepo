package src;
import java.util.List;

public class King extends Piece { 
  
    public King(boolean white) 
    { 
        super(white); 
    }

	@Override
	public List<Spot> getMoves(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PieceType type() {
		return PieceType.KING;
	} 
  
}
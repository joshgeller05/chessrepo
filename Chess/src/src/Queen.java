package src;
import java.util.List;

public class Queen extends Piece { 
  
    public Queen(boolean white) 
    { 
        super(white); 
    }

	@Override
	public List<Spot> canMove(Board board) {
		return null;
	} 
  
}
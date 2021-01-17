import java.util.List;

public abstract class Piece { 
  
    private boolean white = false; 
  
    public Piece(boolean white) 
    { 
        this.setWhite(white); 
    } 
  
    public boolean isWhite() 
    { 
        return this.white; 
    } 
  
    public void setWhite(boolean white) 
    { 
        this.white = white; 
    } 
    
    public abstract List<Spot> canMove(Board board); 
    
} 
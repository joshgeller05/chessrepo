package src;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Scanner;

public class Game {
	private Board board;
	private ArrayList<Piece> white;
	private ArrayList<Piece> black;
	private Piece piece;
	public Game() {
		board = new Board();
		white = new ArrayList<Piece>();
		black = new ArrayList<Piece>();
		piece = null;
	}
	
	/**
	 * starts a chess game
	 * @param userInput - whether or not going to ask the user for input from line
	 * @param in_white - white pieces given to the game
	 * @param in_black - black pieces given to the game
	 * @param in_piece - piece to move given to the game
	 * @throws Exception
	 */
	public void start(boolean userInput, ArrayList<Piece> in_white, ArrayList<Piece> in_black, Piece in_piece) throws Exception
	{
		if(userInput)
		{
			Scanner scanner = new Scanner(System.in,"UTF-8");
			System.out.println("ENTER WHITE PIECES: ");
			String whitePieces = scanner.nextLine();
			this.setWhitePieces(whitePieces);
			System.out.println("ENTER BLACK PIECES: ");
			String blackPieces = scanner.nextLine();
			this.setBlackPieces(blackPieces);
			
			this.board.setBoard(white, black);
			System.out.println("ENTER PIECE TO MOVE: ");
			String pieceToMove = scanner.nextLine();
			this.setPieceToMove(pieceToMove);

			scanner.close();
		}
		else
		{
			this.setWhite(in_white);
			this.setBlack(in_black);
			this.piece = in_piece;		
		}
		ArrayList<Spot> moves = (ArrayList<Spot>) this.piece.getMoves(this.board);
		System.out.println(this.piece + " can move to: "+ moves);
	}
	
	/**
	 * set the white pieces for the board
	 * @param pieces
	 */
	public void setWhitePieces(String pieces)
	{
		String[] temp = pieces.split(", ");
		for(String str : temp)
		{
			Piece p = this.getPiece(str, true);
			if(null != p)
			{
				white.add(p);
			}
		}
		System.out.println(white);
	}
	
	/**
	 * set the black pieces for the board
	 * @param pieces
	 */
	public void setBlackPieces(String pieces)
	{
		String[] temp = pieces.split(", ");
		for(String str : temp)
		{
			Piece p = this.getPiece(str, false);
			if(null != p)
			{
				black.add(p);
			}
		}
		System.out.println(black);
	}
	
	/**
	 * tranlsate a piece string to a piece object
	 * @param str - piece as a string
	 * @param white - color of piece
	 * @return piece
	 */
	public Piece getPiece(String str, boolean white)
	{
		Piece p = null;
		int column = this.convertColumn(String.valueOf(str.charAt(1)));
		int row = Integer.parseInt(String.valueOf(str.charAt(2)));
		if(str.startsWith("K"))
		{
			p = new King(white);
		}
		else if(str.startsWith("Q"))
		{
			p = new Queen(white);
		}
		else if(str.startsWith("R"))
		{
			p = new Rook(white);
		}
		else if(str.startsWith("B"))
		{
			p = new Bishop(white);
		}
		else if(str.startsWith("N"))
		{
			p = new Knight(white);
		}
		else if(str.startsWith("P"))
		{
			p = new Pawn(white);
		}
		
		if(null != p)
		{
			p.setY(column);
			p.setX(row-1);
		}
		return p;
	}
	
	/**
	 * set the piece to move for the board
	 * @param p - piece as a string
	 */
	public void setPieceToMove(String p)
	{
		piece = this.getPiece(p, true);
		boolean isFound = false;
		for(Piece whitep : white)
		{
			if(piece.equals(whitep))
			{
				isFound = true;
			}
		}
		if(!isFound)
		{
			piece = this.getPiece(p, false);
			for(Piece blackP : black)
			{
				if(piece.equals(blackP))
				{
					isFound = true;
				}
			}
			if(!isFound)
			{
				piece = null;
				System.out.println("PIECE TO MOVE NOT IN WHITE OR BLACK LIST, GOODBYE");
			}
		}
	}
	
	/**
	 * convert the column as a string to an integer
	 * @param column - as a string
	 * @return column as an int
	 */
    public int convertColumn(String column)
    {
    	char[] x = column.toCharArray();
    	int result = -1;
    	for(char c : x){
    	    int temp = (int)c;
    	    int temp_integer = 96; //for lower case
    	    if(temp<=122 & temp>=97)
    	        result =temp-temp_integer;
    	}
    	return result - 1;
    }

    /**
     * get the white pieces
     * @return white pieces
     */
	public ArrayList<Piece> getWhite() {
		return white;
	}

	/**
	 * set the white pieces
	 * @param white pieces to set
	 */
	public void setWhite(ArrayList<Piece> white) {
		this.white = white;
	}

    /**
     * get the black pieces
     * @return black pieces
     */
	public ArrayList<Piece> getBlack() {
		return black;
	}

	/**
	 * set the black pieces
	 * @param black pieces to set
	 */
	public void setBlack(ArrayList<Piece> black) {
		this.black = black;
	}
	
	/**
	 * reset the white pieces
	 */
	public void resetWhite()
	{
		white.clear();
	}
	
	/**
	 * reset the black pieces
	 */
	public void resetBlack()
	{
		black.clear();
	}

	/**
	 * 
	 * @return the piece the board is moving
	 */
	public Piece getPieceToMove() {
		return piece;
	}

}

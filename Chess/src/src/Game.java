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
	
	public void start() throws Exception
	{
		Scanner scanner = new Scanner(System.in,"UTF-8");
		System.out.println("ENTER WHITE PIECES: ");
		String whitePieces = scanner.nextLine(); //"Kg1, Pf2, Ph2, Pg3, Pb6, Ne2, Bf5, Qc4";// scanner.nextLine();
		this.setWhitePieces(whitePieces);
		System.out.println("ENTER BLACK PIECES: ");
		String blackPieces = scanner.nextLine();//"Kb8, Ne8, Bb7, Pc7, Ra5";//scanner.nextLine();
		this.setBlackPieces(blackPieces);
		
		this.board.setBoard(white, black);
		System.out.println("ENTER PIECE TO MOVE: ");
		String pieceToMove = scanner.nextLine();//"Kg1";
		this.setPieceToMove(pieceToMove);
		ArrayList<Spot> moves = (ArrayList<Spot>) this.piece.getMoves(this.board);
		System.out.println(this.piece + " can move to: "+ moves);
		scanner.close();
	}
	
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
				System.out.println("PIECE TO MOVE NOT IN WHITE OR BLACK LIST, GOODBYE");
			}
		}
	}
	
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

}

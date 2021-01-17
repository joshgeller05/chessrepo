package src;

import java.util.ArrayList;
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
	
	public void start()
	{
		//Scanner scanner = new Scanner(System.in);
		System.out.println("WHITE: ");
		String whitePieces = "Rf1, Kg1, Pf2, Ph2, Pg3";// scanner.nextLine();
		this.setWhitePieces(whitePieces);
		System.out.println("BLACK: ");
		String blackPieces = "Kb8, Ne8, Pa7, Pb7, Pc7, Ra5";//scanner.nextLine();
		this.setBlackPieces(blackPieces);
		System.out.println("PIECE TO MOVE: ");
		String pieceToMove = "Rf1";//scanner.nextLine();
		this.setPieceToMove(pieceToMove);
		//scanner.close();
		this.board.setBoard(white, black);
	}
	
	public void convertToPieces()
	{
		
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
		String column = String.valueOf(str.charAt(1));
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
			p.setColumn(column);
			p.setRow(row);
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
		System.out.println(piece);
	}

}

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Bishop;
import src.Game;
import src.King;
import src.Knight;
import src.Pawn;
import src.Piece;
import src.Queen;
import src.Rook;
import src.Spot;

class TestGame {
	
	private Game game;
	
	@BeforeEach
	public void setUp()
	{
		game = new Game();
	}
	
	@Test
	public void testSetWhitePieces()
	{
		ArrayList<Piece> white = new ArrayList<Piece>();
		King king = new King(true);
		king.setX(0);
		king.setY(0);
		
		Pawn pawn = new Pawn(true);
		pawn.setX(1);
		pawn.setY(1);
		
		white.add(king);
		white.add(pawn);
		game.setWhitePieces("Ka1, Pb2");
		assertEquals(white,game.getWhite());
		
		game.resetWhite();
		game.setWhitePieces("Ka1, Pb2, Ga1");
		assertEquals(white,game.getWhite());
		
		game.resetWhite();
		game.setWhite(white);
		assertEquals(white,game.getWhite());
	}
	@Test
	public void testSetBlackPieces()
	{
		ArrayList<Piece> black = new ArrayList<Piece>();
		King king = new King(false);
		king.setX(0);
		king.setY(0);
		
		Pawn pawn = new Pawn(false);
		pawn.setX(1);
		pawn.setY(1);
		
		black.add(king);
		black.add(pawn);
		game.setBlackPieces("Ka1, Pb2");
		assertEquals(black,game.getBlack());
		
		game.resetBlack();
		game.setBlackPieces("Ka1, Pb2, Ga1");
		assertEquals(black,game.getBlack());
		
		game.resetBlack();
		game.setBlack(black);
		assertEquals(black,game.getBlack());
	}
	
	@Test
	public void testGetPiece()
	{
		Piece p = game.getPiece("Ka1", false);
		assertTrue(p instanceof King);
		p = game.getPiece("Qa1", false);
		assertTrue(p instanceof Queen);
		p = game.getPiece("Ra1", false);
		assertTrue(p instanceof Rook);
		p = game.getPiece("Ba1", false);
		assertTrue(p instanceof Bishop);
		p = game.getPiece("Na1", false);
		assertTrue(p instanceof Knight);
		p = game.getPiece("Pa1", false);
		assertTrue(p instanceof Pawn);
	}
	
	@Test
	public void testSetPieceToMove()
	{
		game.setBlackPieces("Ka8, Pa7");
		
		game.setWhitePieces("Ka1, Pb2");
		
		game.setPieceToMove("Ka1");
		
		assertTrue(game.getPieceToMove() instanceof King);
		
		game.setPieceToMove("Ka8");
		
		assertTrue(game.getPieceToMove() instanceof King);

		game.setPieceToMove("Pa7");
		
		assertTrue(game.getPieceToMove() instanceof Pawn);
		
		game.setPieceToMove("Pb2");
		
		assertTrue(game.getPieceToMove() instanceof Pawn);
		
		game.setPieceToMove("Pa2");
		
		assertEquals(game.getPieceToMove(), null);	
	}
	
	@Test
	public void testStart() throws Exception
	{
		ArrayList<Piece> black = new ArrayList<Piece>();
		King king = new King(false);
		king.setX(0);
		king.setY(0);
		
		Pawn pawn = new Pawn(false);
		pawn.setX(1);
		pawn.setY(1);
		
		black.add(king);
		black.add(pawn);
		
		ArrayList<Piece> white = new ArrayList<Piece>();
		King whiteKing = new King(true);
		king.setX(0);
		king.setY(0);
		
		Pawn whitePawn = new Pawn(true);
		pawn.setX(1);
		pawn.setY(1);
		
		white.add(whiteKing);
		white.add(whitePawn);
		
		game.start(false, white, black, whitePawn);
		
		assertEquals(white,game.getWhite());
		assertEquals(black,game.getBlack());
		assertEquals(whitePawn,game.getPieceToMove());
		
	}

}

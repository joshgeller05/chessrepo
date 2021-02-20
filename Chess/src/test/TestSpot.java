package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Pawn;
import src.Piece;
import src.Rook;
import src.Spot;

class TestSpot {
	
	private Piece p;
	private Spot s;
	
	@BeforeEach
	public void setUp()
	{
		p = new Pawn(true);
		s = new Spot(1,1,p);
	}
	
	@Test
	public void testConstructorGettersAndSetters()
	{
		
		assertTrue(s.getPiece() == p);
		assertTrue(s.getX() == 1);
		assertTrue(s.getY() == 1);
		
		
	}
	
	@Test
	public void testIsValid()
	{

		
		assertTrue(s.isValid());
		
		s.setX(9);
		s.setY(9);
		assertFalse(s.isValid());
		
		s.setX(-1);
		s.setY(-1);
		assertFalse(s.isValid());
		
		s.setX(5);
		s.setY(9);
		assertFalse(s.isValid());
		
		s.setX(-1);
		s.setY(5);
		assertFalse(s.isValid());
	}
	
	@Test
	public void testToString()
	{
		assertEquals(s.toString(),"B2");
	}
	
	@Test
	public void testHashCode()
	{
		assertEquals(s.hashCode(),28888653);
	}
	
	@Test
	public void testEqualsString()
	{
		assertTrue(s.equals("B2"));
		
		assertFalse(s.equals("B5"));
	}
	
	@Test
	public void testEqualsObject()
	{
		Spot spot = new Spot(1,1,p);
		assertFalse(s.equals(new Spot(5,5,new Rook(false))));
		
		assertFalse(s.equals(new Spot(1,5,new Rook(false))));
		
		assertFalse(s.equals(new Spot(1,5,null)));
		
		assertFalse(s.equals(new Pawn(false)));
		
		assertTrue(s.equals(spot));
	}
	
	@Test
	public void testCompareTo()
	{
		Spot spot = new Spot(1,1,p);
		
		assertEquals(0,s.compareTo(spot));
		
		spot = new Spot(5,5,new Rook(false));
		
		assertEquals(-4,s.compareTo(spot));
	}
	
	@Test
	public void testHasSameColorPiece()
	{
		Piece piece = null;
		
		assertFalse(s.hasSameColorPiece(piece));
		
		s.setPiece(null);
		
		assertFalse(s.hasSameColorPiece(piece));
		
		s.setPiece(p);
		piece = new Rook(false);
		assertFalse(s.hasSameColorPiece(piece));
		piece = new Rook(true);
		assertTrue(s.hasSameColorPiece(piece));
	}

}

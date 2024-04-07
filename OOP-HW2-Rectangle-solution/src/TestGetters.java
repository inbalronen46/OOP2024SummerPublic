import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestGetters {

	Rectangle rectangle1;
	Rectangle rectangle2;
	Rectangle rectangle4;
	Rectangle rectangle5;
	Rectangle rectangle3;
	Rectangle rectangle6;
	
	@Before
	public void setUp() {
		rectangle1 = new DimensionRectangle();
		rectangle2 = new DimensionRectangle(new Point(1.0, 2.0), (double)3, (double)2);		
		rectangle3 = new DimensionRectangle(new Point(-1.0, -2.0), (double)2, (double)3);

		rectangle4 = new TwoPointRectangle();
		rectangle5 = new TwoPointRectangle(new Point(1.0, 4.0), new Point(4.0, 2.0));		
		rectangle6 = new TwoPointRectangle(new Point(-1.0, 1.0), new Point(1.0, -2.0));
	}
	
	@Test
    public void testConstructorAndHeight() {
		assertEquals(1.0, rectangle1.getHeight(), HW2Utils.getPRECISION());
		assertEquals(2.0, rectangle2.getHeight(), HW2Utils.getPRECISION());
		assertEquals(3.0, rectangle3.getHeight(), HW2Utils.getPRECISION());
		assertEquals(1.0, rectangle4.getHeight(), HW2Utils.getPRECISION());
		assertEquals(2.0, rectangle5.getHeight(), HW2Utils.getPRECISION());
		assertEquals(3.0, rectangle6.getHeight(), HW2Utils.getPRECISION());
    }
	
	@Test
    public void testConstructorAndWidth() {
		assertEquals(1.0, rectangle1.getWidth(), HW2Utils.getPRECISION());
		assertEquals(3.0, rectangle2.getWidth(), HW2Utils.getPRECISION());
		assertEquals(2.0, rectangle3.getWidth(), HW2Utils.getPRECISION());
		assertEquals(1.0, rectangle4.getWidth(), HW2Utils.getPRECISION());
		assertEquals(3.0, rectangle5.getWidth(), HW2Utils.getPRECISION());
		assertEquals(2.0, rectangle6.getWidth(), HW2Utils.getPRECISION());
    }
	
	@Test
    public void testConstructorAndBottomLeft() {
		assertEquals(0.0, rectangle1.getBottomLeft().getX(), HW2Utils.getPRECISION());
		assertEquals(0.0, rectangle1.getBottomLeft().getY(), HW2Utils.getPRECISION());
		assertEquals(0.0, rectangle4.getBottomLeft().getX(), HW2Utils.getPRECISION());
		assertEquals(0.0, rectangle4.getBottomLeft().getY(), HW2Utils.getPRECISION());
		
		assertEquals(1.0, rectangle2.getBottomLeft().getX(), HW2Utils.getPRECISION());
		assertEquals(2.0, rectangle2.getBottomLeft().getY(), HW2Utils.getPRECISION());
		assertEquals(1.0, rectangle5.getBottomLeft().getX(), HW2Utils.getPRECISION());
		assertEquals(2.0, rectangle5.getBottomLeft().getY(), HW2Utils.getPRECISION());
		
		assertEquals(-1.0, rectangle3.getBottomLeft().getX(), HW2Utils.getPRECISION());
		assertEquals(-2.0, rectangle3.getBottomLeft().getY(), HW2Utils.getPRECISION());
		assertEquals(-1.0, rectangle6.getBottomLeft().getX(), HW2Utils.getPRECISION());
		assertEquals(-2.0, rectangle6.getBottomLeft().getY(), HW2Utils.getPRECISION());		
    
		//check copy
		Point point1 = rectangle3.getBottomLeft();
		Point point2 = rectangle4.getBottomLeft();
		point1.moveHorizontal(1);
		point2.moveHorizontal(1);
		assertNotSame(point1, rectangle3.getBottomLeft());
		assertNotEquals(point1, rectangle3.getBottomLeft());
		assertNotSame(point2, rectangle4.getBottomLeft());
	}
	
	@Test
    public void testConstructorNegative() {
		Rectangle rectangle7 = new DimensionRectangle(new Point(1,1), -1, 1);
		Rectangle rectangle8 = new DimensionRectangle(new Point(1,1), 1, -1);
		assertEquals(rectangle7.getBottomLeft(), new Point(0,0));
		assertEquals(rectangle8.getBottomLeft(), new Point(0,0));
		assertEquals(1.0, rectangle7.getHeight(), HW2Utils.getPRECISION());	
		assertEquals(1.0, rectangle7.getWidth(), HW2Utils.getPRECISION());	
		assertEquals(1.0, rectangle8.getHeight(), HW2Utils.getPRECISION());	
		assertEquals(1.0, rectangle8.getWidth(), HW2Utils.getPRECISION());	
		
		Rectangle rectangle9 = new TwoPointRectangle(new Point(1,1), new Point(1,8));
		Rectangle rectangle10 = new TwoPointRectangle(new Point(1,1), new Point(8,1));
		assertEquals(rectangle9.getBottomLeft(), new Point(0,0));
		assertEquals(rectangle10.getBottomLeft(), new Point(0,0));
		assertEquals(1.0, rectangle9.getHeight(), HW2Utils.getPRECISION());	
		assertEquals(1.0, rectangle9.getWidth(), HW2Utils.getPRECISION());	
		assertEquals(1.0, rectangle10.getHeight(), HW2Utils.getPRECISION());	
		assertEquals(1.0, rectangle10.getWidth(), HW2Utils.getPRECISION());
	}
	

    
    
    
    
    @Test
	public void testIsGetPoints() {
    	Set<Point> expectedPoints = new HashSet<>(Arrays.asList(
                new Point(0, 1),                   // Top-left
                new Point(1, 1),                  // Top-right
                new Point(1, 0),                   // Bottom-right
                new Point(0, 0)                    // Bottom-left
            ));
    	Set<Point> actualPoints = new HashSet<>(Arrays.asList(rectangle1.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	actualPoints = new HashSet<>(Arrays.asList(rectangle4.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	
    	expectedPoints = new HashSet<>(Arrays.asList(
                new Point(1, 4),                   // Top-left
                new Point(4, 4),                  // Top-right
                new Point(4, 2),                   // Bottom-right
                new Point(1, 2)                    // Bottom-left
            ));
    	actualPoints = new HashSet<>(Arrays.asList(rectangle2.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	actualPoints = new HashSet<>(Arrays.asList(rectangle5.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	
    	expectedPoints = new HashSet<>(Arrays.asList(
                new Point(-1, 1),                   // Top-left
                new Point(1, 1),                  // Top-right
                new Point(1, -2),                   // Bottom-right
                new Point(-1, -2)                    // Bottom-left
            ));
    	actualPoints = new HashSet<>(Arrays.asList(rectangle3.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	actualPoints = new HashSet<>(Arrays.asList(rectangle6.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    }
    
    @Test
	public void testCopyIsGetPoints() {
    	Point[] points = rectangle2.getAllPoints();	
    	points[0].moveHorizontal(1);
    	assertNotEquals(points[0], rectangle2.getAllPoints()[0]);
    	points = rectangle2.getAllPoints();	
    	points[2].moveHorizontal(1);
    	assertNotEquals(points[2], rectangle2.getAllPoints()[2]);
    	
    	points = rectangle5.getAllPoints();	
    	points[0].moveHorizontal(1);
    	assertNotEquals(points[0], rectangle5.getAllPoints()[0]);
    	points = rectangle5.getAllPoints();	
    	points[2].moveHorizontal(1);
    	assertNotEquals(points[2], rectangle5.getAllPoints()[2]);
    }
}

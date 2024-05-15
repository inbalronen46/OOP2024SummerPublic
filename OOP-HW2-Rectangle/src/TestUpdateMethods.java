import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TestUpdateMethods {

	Rectangle rectangle1;
	Rectangle rectangle2;
	Rectangle rectangle4;
	Rectangle rectangle5;
	Rectangle rectangle3;
	Rectangle rectangle6;
	
	@Before
	public void setUp() {
		rectangle2 = new DimensionRectangle(new Point(1.0, 2.0), (double)3, (double)2);		
		rectangle3 = new DimensionRectangle(new Point(-1.0, -2.0), (double)2, (double)3);

		rectangle5 = new TwoPointRectangle(new Point(1.0, 4.0), new Point(4.0, 2.0));		
		rectangle6 = new TwoPointRectangle(new Point(-1.0, 1.0), new Point(1.0, -2.0));
	}

	@Test
	public void testMoveHorizontal() {
		rectangle2.moveHorizontal(4);
		assertEquals(3, rectangle2.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle2.getBottomLeft(), new Point(5.0, 2.0));
		
		rectangle3.moveHorizontal(4);
		assertEquals(2, rectangle3.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle3.getBottomLeft(), new Point(3.0, -2.0));

		rectangle2.moveHorizontal(-4);
		assertEquals(3, rectangle2.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle2.getBottomLeft(), new Point(1.0, 2.0));
		
		rectangle5.moveHorizontal(4);
		assertEquals(3, rectangle5.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle5.getBottomLeft(), new Point(5.0, 2.0));
		
		rectangle6.moveHorizontal(4);
		assertEquals(2, rectangle6.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle6.getBottomLeft(), new Point(3.0, -2.0));

		rectangle5.moveHorizontal(-4);
		assertEquals(3, rectangle5.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle5.getBottomLeft(), new Point(1.0, 2.0));
	}
	
	@Test
	public void testMoveVertical() {
		rectangle2.moveVertical(4);
		assertEquals(2, rectangle2.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(rectangle2.getBottomLeft(), new Point(1.0, 6.0));
		
		rectangle3.moveVertical(4);
		assertEquals(3, rectangle3.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(rectangle3.getBottomLeft(), new Point(-1.0, 2.0));

		rectangle2.moveVertical(-4);
		assertEquals(2, rectangle2.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(rectangle2.getBottomLeft(), new Point(1.0, 2.0));
		
		rectangle5.moveVertical(4);
		assertEquals(2, rectangle5.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(rectangle5.getBottomLeft(), new Point(1.0, 6.0));
		
		rectangle6.moveVertical(4);
		assertEquals(3, rectangle6.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(rectangle6.getBottomLeft(), new Point(-1.0, 2.0));

		rectangle5.moveVertical(-4);
		assertEquals(2, rectangle5.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(rectangle5.getBottomLeft(), new Point(1.0, 2.0));
	}
	
	@Test
	public void testMove() {
		Point movePoint = new Point(-0.2, 1);
		rectangle2.move(movePoint);
		assertEquals(2, rectangle2.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(3, rectangle2.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle2.getBottomLeft(), new Point(0.8, 3.0));
		
		
		rectangle6.move(movePoint);
		assertEquals(3, rectangle6.getHeight(), HW2Utils.getPRECISION());
		assertEquals(2, rectangle6.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle6.getBottomLeft(), new Point(-1.2, -1.0));		
	}
	
	
	
	
	@Test
	public void testFlipHorizontal() {
		rectangle2.flipHorizontal();
		assertEquals(2, rectangle2.getHeight(), HW2Utils.getPRECISION());
		assertEquals(3, rectangle2.getWidth(), HW2Utils.getPRECISION());
		assertEquals(rectangle2.getBottomLeft(), new Point(1.0, 0.0));
		Set<Point> expectedPoints = new HashSet<Point>(Arrays.asList(
                new Point(1, 0),                   // Top-left
                new Point(4, 0),                  // Top-right
                new Point(1, 2),                   // Bottom-right
                new Point(4, 2)                    // Bottom-left
            ));
		Set<Point> actualPoints = new HashSet<>(Arrays.asList(rectangle2.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	
    	rectangle5.flipHorizontal();
		assertEquals(2, rectangle5.getHeight(), HW2Utils.getPRECISION());
		assertEquals(3, rectangle5.getWidth(), HW2Utils.getPRECISION());
		assertEquals(rectangle5.getBottomLeft(), new Point(1.0, 0.0));
		expectedPoints = new HashSet<>(Arrays.asList(
                new Point(1, 0),                   // Top-left
                new Point(4, 0),                  // Top-right
                new Point(1, 2),                   // Bottom-right
                new Point(4, 2)                    // Bottom-left
            ));
		actualPoints = new HashSet<Point>(Arrays.asList(rectangle5.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	
    	rectangle3.flipHorizontal();
		assertEquals(3, rectangle3.getHeight(), HW2Utils.getPRECISION());
		assertEquals(2, rectangle3.getWidth(), HW2Utils.getPRECISION());
		assertEquals(rectangle3.getBottomLeft(), new Point(-1.0, -5.0));
		expectedPoints = new HashSet<Point>(Arrays.asList(
                new Point(-1, -5),                   
                new Point(1, -2),                  
                new Point(-1, -2),                   
                new Point(1, -5)                    
            ));
		actualPoints = new HashSet<>(Arrays.asList(rectangle3.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	
    	rectangle6.flipHorizontal();
		assertEquals(3, rectangle6.getHeight(), HW2Utils.getPRECISION());
		assertEquals(2, rectangle6.getWidth(), HW2Utils.getPRECISION());
		assertEquals(rectangle6.getBottomLeft(), new Point(-1.0, -5.0));
		expectedPoints = new HashSet<Point>(Arrays.asList(
                new Point(-1, -5),                   
                new Point(1, -2),                  
                new Point(-1, -2),                   
                new Point(1, -5)                
            ));
		actualPoints = new HashSet<Point>(Arrays.asList(rectangle6.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
	}
	
	@Test
	public void testFlipVerticall() {
		rectangle2.flipVertical();
		assertEquals(2, rectangle2.getHeight(), HW2Utils.getPRECISION());
		assertEquals(3, rectangle2.getWidth(), HW2Utils.getPRECISION());
		assertEquals(rectangle2.getBottomLeft(), new Point(-2.0, 2.0));
		Set<Point> expectedPoints = new HashSet<>(Arrays.asList(
                new Point(1, 4),                   // Top-left
                new Point(-2, 4),                  // Top-right
                new Point(1, 2),                   // Bottom-right
                new Point(-2, 2)                    // Bottom-left
            ));
		Set<Point> actualPoints = new HashSet<Point>(Arrays.asList(rectangle2.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	
    	rectangle5.flipVertical();
		assertEquals(2, rectangle5.getHeight(), HW2Utils.getPRECISION());
		assertEquals(3, rectangle5.getWidth(), HW2Utils.getPRECISION());
		assertEquals(rectangle5.getBottomLeft(), new Point(-2.0, 2.0));
		expectedPoints = new HashSet<>(Arrays.asList(
                new Point(1, 4),                   // Top-left
                new Point(-2, 4),                  // Top-right
                new Point(1, 2),                   // Bottom-right
                new Point(-2, 2)                    // Bottom-left
            ));
		actualPoints = new HashSet<Point>(Arrays.asList(rectangle5.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	
    	rectangle3.flipVertical();
		assertEquals(3, rectangle3.getHeight(), HW2Utils.getPRECISION());
		assertEquals(2, rectangle3.getWidth(), HW2Utils.getPRECISION());
		assertEquals(rectangle3.getBottomLeft(), new Point(-3.0, -2.0));
		expectedPoints = new HashSet<Point>(Arrays.asList(
                new Point(-3, -2),                   
                new Point(-1, -2),                  
                new Point(-1, 1),                   
                new Point (-3, 1)                    
            ));
		actualPoints = new HashSet<>(Arrays.asList(rectangle3.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
    	
    	rectangle6.flipVertical();
		assertEquals(3, rectangle6.getHeight(), HW2Utils.getPRECISION());
		assertEquals(2, rectangle6.getWidth(), HW2Utils.getPRECISION());
		assertEquals(rectangle6.getBottomLeft(), new Point(-3.0, -2.0));
		expectedPoints = new HashSet<Point>(Arrays.asList(
                new Point(-3, -2),                   
                new Point(-1, -2),                  
                new Point(-1, 1),                   
                new Point (-3, 1)                
            ));
		actualPoints = new HashSet<Point>(Arrays.asList(rectangle6.getAllPoints()));
    	assertEquals(expectedPoints, actualPoints);
	}
}

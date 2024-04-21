import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSetters {

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
	public void testHeight() {
		rectangle1.updateHeight(20); // Set new height
        assertEquals(20, rectangle1.getHeight(), HW2Utils.getPRECISION());
        assertEquals(rectangle1.getBottomLeft(), new Point(0.0, 0.0));// 
        
        rectangle2.updateHeight(20); // Set new height
        assertEquals(20, rectangle2.getHeight(), HW2Utils.getPRECISION()); // 
        assertEquals(rectangle2.getBottomLeft(), new Point(1.0, 2.0));
        
        rectangle3.updateHeight(20); // Set new height
        assertEquals(20, rectangle3.getHeight(), HW2Utils.getPRECISION()); // 
        assertEquals(rectangle3.getBottomLeft(), new Point(-1.0, -2.0));
        
        rectangle4.updateHeight(20); // Set new height
        assertEquals(20, rectangle4.getHeight(), HW2Utils.getPRECISION()); // 
        assertEquals(rectangle4.getBottomLeft(), new Point(0.0, 0.0));
        		
        rectangle5.updateHeight(20); // Set new height
        assertEquals(20, rectangle5.getHeight(), HW2Utils.getPRECISION()); // 
        assertEquals(rectangle5.getBottomLeft(), new Point(1.0, 2.0));
        
        rectangle6.updateHeight(20); // Set new height
        assertEquals(20, rectangle6.getHeight(), HW2Utils.getPRECISION()); // 
        assertEquals(rectangle6.getBottomLeft(), new Point(-1.0, -2.0));
        
        // check negative
        rectangle6.updateHeight(-20); // Set new height
        assertEquals(20, rectangle6.getHeight(), HW2Utils.getPRECISION()); // 
        
     // check negative
        rectangle6.updateHeight(0); // Set new height
        assertEquals(20, rectangle6.getHeight(), HW2Utils.getPRECISION()); 
        
     // check negative
        rectangle3.updateHeight(-20); // Set new height
        assertEquals(20, rectangle3.getHeight(), HW2Utils.getPRECISION()); // 
        
     // check negative
        rectangle3.updateHeight(0); // Set new height
        assertEquals(20, rectangle3.getHeight(), HW2Utils.getPRECISION()); 
        
        
	}
	
	@Test
	public void testWidth() {
		rectangle1.updateWidth(20); 
        assertEquals(20, rectangle1.getWidth(), HW2Utils.getPRECISION()); // 
        assertEquals(rectangle1.getBottomLeft(), new Point(0.0, 0.0));
        
        rectangle2.updateWidth(20); 
        assertEquals(20, rectangle2.getWidth(), HW2Utils.getPRECISION()); // 
        assertEquals(rectangle4.getBottomLeft(), new Point(0.0, 0.0));
        
        rectangle3.updateWidth(20); 
        assertEquals(20, rectangle3.getWidth(), HW2Utils.getPRECISION()); // 
        assertEquals(rectangle4.getBottomLeft(), new Point(0.0, 0.0));
        
        rectangle4.updateWidth(20); 
        assertEquals(20, rectangle4.getWidth(), HW2Utils.getPRECISION()); // 
        assertEquals(rectangle4.getBottomLeft(), new Point(0.0, 0.0));
        
        rectangle5.updateWidth(20); 
        assertEquals(20, rectangle5.getWidth(), HW2Utils.getPRECISION()); // 
        assertEquals(rectangle4.getBottomLeft(), new Point(0.0, 0.0));
        
        rectangle6.updateWidth(20); 
        assertEquals(20, rectangle6.getWidth(), HW2Utils.getPRECISION()); //
        assertEquals(rectangle4.getBottomLeft(), new Point(0.0, 0.0));
        
        //test <= 0
        rectangle6.updateWidth(-20); 
        assertEquals(20, rectangle6.getWidth(), HW2Utils.getPRECISION()); 

        rectangle6.updateWidth(0); 
        assertEquals(20, rectangle6.getWidth(), HW2Utils.getPRECISION()); 
        
        rectangle3.updateWidth(-20); 
        assertEquals(20, rectangle3.getWidth(), HW2Utils.getPRECISION()); 

        rectangle3.updateWidth(0); 
        assertEquals(20, rectangle3.getWidth(), HW2Utils.getPRECISION()); 
	}
	
	@Test
	public void testCopy() {
		Point newPlace = new Point(1,1);
		Rectangle rectangle7 = new DimensionRectangle(newPlace, (double)3, (double)2);
		rectangle7.updateWidth(20); 
		assertNotSame(newPlace, rectangle7.getBottomLeft()); // 
		
		newPlace = new Point(1,1);
		Point newPlace2 = new Point(2,2);
		Rectangle rectangle8 = new TwoPointRectangle(newPlace, newPlace2);	
		Point left = rectangle8.getBottomLeft();
		rectangle8.updateWidth(20); 
		assertNotSame(left, rectangle8.getBottomLeft()); 
	}
	
	@Test
	public void testScale() {
		// scale with parametr<=0 (nothing is done).
		rectangle2.scale(0);
		assertEquals(2, rectangle2.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(3, rectangle2.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle2.getBottomLeft(), new Point(1.0, 2.0));
		
		rectangle2.scale(-1);
		assertEquals(2, rectangle2.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(3, rectangle2.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle2.getBottomLeft(), new Point(1.0, 2.0));
		
		rectangle5.scale(0);
		assertEquals(2, rectangle5.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(3, rectangle5.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle5.getBottomLeft(), new Point(1.0, 2.0));
		
		rectangle5.scale(-1);
		assertEquals(2, rectangle5.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(3, rectangle5.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle5.getBottomLeft(), new Point(1.0, 2.0));
		
		rectangle2.scale(3);
		assertEquals(6, rectangle2.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(9, rectangle2.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle2.getBottomLeft(), new Point(1.0, 2.0));
		
		rectangle3.scale(4);
		assertEquals(12, rectangle3.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(8, rectangle3.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle3.getBottomLeft(), new Point(-1.0, -2.0));
		
		rectangle5.scale(3);
		assertEquals(6, rectangle5.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(9, rectangle5.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle5.getBottomLeft(), new Point(1.0, 2.0));
		
		rectangle6.scale(4);
		assertEquals(12, rectangle6.getHeight(), HW2Utils.getPRECISION());  
		assertEquals(8, rectangle6.getWidth(), HW2Utils.getPRECISION());  
		assertEquals(rectangle6.getBottomLeft(), new Point(-1.0, -2.0));
	}
	

}

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOtherMethods {

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
	public void testArea() {
		assertEquals(1, rectangle1.area(), HW2Utils.getPRECISION());
		assertEquals(6, rectangle2.area(), HW2Utils.getPRECISION());
		assertEquals(6, rectangle3.area(), HW2Utils.getPRECISION());
		assertEquals(1, rectangle4.area(), HW2Utils.getPRECISION());
		assertEquals(6, rectangle5.area(), HW2Utils.getPRECISION());
		assertEquals(6, rectangle6.area(), HW2Utils.getPRECISION());
	}
	
	@Test
	public void testPerimeter() {
		assertEquals(4, rectangle1.perimeter(), HW2Utils.getPRECISION());
		assertEquals(10, rectangle2.perimeter(), HW2Utils.getPRECISION());
		assertEquals(10, rectangle3.perimeter(), HW2Utils.getPRECISION());
		assertEquals(4, rectangle4.perimeter(), HW2Utils.getPRECISION());
		assertEquals(10, rectangle5.perimeter(), HW2Utils.getPRECISION());
		assertEquals(10, rectangle6.perimeter(), HW2Utils.getPRECISION());
	}
	
	@Test
	public void testIsEqual() {
		assert rectangle2.isEqual(rectangle2 );
		assert rectangle5.isEqual(rectangle5);
		assert rectangle1.isEqual(rectangle1);
		assert rectangle4.isEqual(rectangle4);

		assert rectangle2.isEqual(rectangle5);
		assert rectangle5.isEqual(rectangle2);
		assert rectangle2.isEqual(rectangle5);
		assert rectangle5.isEqual(rectangle2);

		assert rectangle1.isEqual(rectangle1);
		assert rectangle4.isEqual(rectangle4);
		assert rectangle1.isEqual(rectangle4);
		assert rectangle4.isEqual(rectangle1);
		
		assert rectangle3.isEqual(rectangle3);
		assert rectangle6.isEqual(rectangle6);
		assert rectangle3.isEqual(rectangle6);
		assert rectangle6.isEqual(rectangle3);

		assert !rectangle1.isEqual(rectangle2);
		assert !rectangle1.isEqual(rectangle5);
		assert !rectangle4.isEqual(rectangle2);
		assert !rectangle4.isEqual(rectangle5);
		assert !rectangle4.isEqual(rectangle6);
		assert !rectangle1.isEqual(rectangle3);
	}
}

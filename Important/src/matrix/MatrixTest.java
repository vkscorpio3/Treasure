package matrix;

import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest {

	
	@Test
	public void test1() {
		double[][] data = new double[][] {{1,2,3},{4,5,6}};
		Matrix matrix = new Matrix(data);
		assertEquals(2, matrix.getNrows());
		assertEquals(3, matrix.getNcols());
		assertTrue(Math.abs(2 - matrix.getValueAt(0, 1)) < 1e-5);
		assertTrue(Math.abs(4 - matrix.getValueAt(1, 0)) < 1e-5);
	}
	@Test
	public void testAdd1() {
		Matrix X = new Matrix(new double[][]{{1,1},{2,8},{3,27},{4,64},{5,125}});
		Matrix X_ = X.insertColumnWithValue1();
		assertEquals(3, X_.getNcols());
		assertTrue(Math.abs(1.0-X_.getValueAt(0, 0)) < 1e-5);
		assertTrue(Math.abs(1.0-X_.getValueAt(1, 0)) < 1e-5);
		assertTrue(Math.abs(1.0-X_.getValueAt(2, 0)) < 1e-5);
		assertTrue(Math.abs(1.0-X_.getValueAt(3, 0)) < 1e-5);
		assertTrue(Math.abs(1.0-X_.getValueAt(4, 0)) < 1e-5);
		assertTrue(Math.abs(1.0-X_.getValueAt(0, 1)) < 1e-5);
		assertTrue(Math.abs(2.0-X_.getValueAt(1, 1)) < 1e-5);
		assertTrue(Math.abs(3.0-X_.getValueAt(2, 1)) < 1e-5);
		assertTrue(Math.abs(4.0-X_.getValueAt(3, 1)) < 1e-5);
		assertTrue(Math.abs(5.0-X_.getValueAt(4, 1)) < 1e-5);
		
	}
}

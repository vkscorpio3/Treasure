package matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixMathematicsTest {

	@Test
	public void testtranspose1() {
		Matrix matrix = new Matrix(new double[][]{{1,2},{3,4}});
		Matrix tanspose = MatrixMathematics.transpose(matrix);
		assertEquals("1.03.02.04.0",tanspose.getValueAt(0, 0)+""+tanspose.getValueAt(0, 1)+""+tanspose.getValueAt(1, 0)+""+tanspose.getValueAt(1, 1));
	}
	@Test
	public void testtranspose2() {
		Matrix matrix = new Matrix(new double[][]{{1,2}});
		assertEquals(2,matrix.getNcols());
		assertEquals(1,matrix.getNrows());
		Matrix tanspose = MatrixMathematics.transpose(matrix);
		assertEquals("1.02.0",tanspose.getValueAt(0, 0)+""+tanspose.getValueAt(1, 0));
		assertEquals(1,tanspose.getNcols());
		assertEquals(2,tanspose.getNrows());
	}
	
	@Test
	public void testcreateSubMatrix() {
		Matrix matrix = new Matrix(new double[][]{{1,2,3},{4,5,6},{7,8,9}});
		Matrix sub = MatrixMathematics.createSubMatrix(matrix, 0, 0);
		assertEquals("5.06.08.09.0",sub.getValueAt(0, 0)+""+sub.getValueAt(0, 1)+""+sub.getValueAt(1, 0)+""+sub.getValueAt(1, 1));
		sub = MatrixMathematics.createSubMatrix(matrix, 0, 1);
		assertEquals("4.06.07.09.0",sub.getValueAt(0, 0)+""+sub.getValueAt(0, 1)+""+sub.getValueAt(1, 0)+""+sub.getValueAt(1, 1));
		sub = MatrixMathematics.createSubMatrix(matrix, 1, 1);
		assertEquals("1.03.07.09.0",sub.getValueAt(0, 0)+""+sub.getValueAt(0, 1)+""+sub.getValueAt(1, 0)+""+sub.getValueAt(1, 1));
	}
	
	@Test
	public void testdeterminant1x1() throws NoSquareException {
		Matrix matrix = new Matrix(new double[][]{{2}});
		double det = MatrixMathematics.determinant(matrix);
		assertTrue(Math.abs(det - 2) < 1e-5);
	}
	@Test
	public void testdeterminant() throws NoSquareException {
		Matrix matrix = new Matrix(new double[][]{{-2,2,3},{-1,1,3},{2,0,-1}});
		double det = MatrixMathematics.determinant(matrix);
		assertTrue(Math.abs(det - 6) < 1e-5);
	}
	@Test
	public void testdeterminant2() throws NoSquareException {
		Matrix matrix = new Matrix(new double[][]{{3,2,0,1},{4,0,1,2},{3,0,2,1},{9,2,3,1}});
		double det = MatrixMathematics.determinant(matrix);
		assertTrue(Math.abs(det - 24) < 1e-5);
	}
	@Test
	public void testdeterminant3() throws NoSquareException {
		Matrix matrix = new Matrix(new double[][]{{1,2,3,4},{5,6,7,8},{2,6,4,8},{3,1,1,2}});
		double det = MatrixMathematics.determinant(matrix);
		assertTrue(Math.abs(det - 72) < 1e-5);
	}
	@Test
	public void testcofactor1() throws Exception {
		Matrix matrix = new Matrix(new double[][]{{1,2,3},{0,4,5},{1,0,6}});
		Matrix cofactor = MatrixMathematics.cofactor(matrix);
		assertTrue(Math.abs(24-cofactor.getValueAt(0, 0)) < 1e-5);
		assertTrue(Math.abs(5-cofactor.getValueAt(0, 1)) < 1e-5);
		assertTrue(Math.abs(-4-cofactor.getValueAt(0, 2)) < 1e-5);
		assertTrue(Math.abs(-12-cofactor.getValueAt(1, 0)) < 1e-5);
		assertTrue(Math.abs(3-cofactor.getValueAt(1, 1)) < 1e-5);
		assertTrue(Math.abs(2-cofactor.getValueAt(1, 2)) < 1e-5);
		assertTrue(Math.abs(-2-cofactor.getValueAt(2, 0)) < 1e-5);
		assertTrue(Math.abs(-5-cofactor.getValueAt(2, 1)) < 1e-5);
		assertTrue(Math.abs(4-cofactor.getValueAt(2, 2)) < 1e-5);
		
	}
	@Test
	public void testInverse() throws Exception {
		Matrix matrix = new Matrix(new double[][]{{1,2,3},{0,4,5},{1,0,6}});
		Matrix inverse = MatrixMathematics.inverse(matrix);
		assertTrue(Math.abs(12.0/11.0-inverse.getValueAt(0, 0)) < 1e-5);
		assertTrue(Math.abs(-6.0/11.0-inverse.getValueAt(0, 1)) < 1e-5);
		assertTrue(Math.abs(-1.0/11.0-inverse.getValueAt(0, 2)) < 1e-5);
		assertTrue(Math.abs(5.0/22.0-inverse.getValueAt(1, 0)) < 1e-5);
		assertTrue(Math.abs(3.0/22.0-inverse.getValueAt(1, 1)) < 1e-5);
		assertTrue(Math.abs(-5.0/22.0-inverse.getValueAt(1, 2)) < 1e-5);
		assertTrue(Math.abs(-2.0/11.0-inverse.getValueAt(2, 0)) < 1e-5);
		assertTrue(Math.abs(1.0/11.0-inverse.getValueAt(2, 1)) < 1e-5);
		assertTrue(Math.abs(2.0/11.0-inverse.getValueAt(2, 2)) < 1e-5);
		
	}
	@Test
	public void testInverse2() throws Exception {
		Matrix matrix = new Matrix(new double[][]{{3,9,2},{0,0,0},{-4,-5,1}});
		Matrix inverse = MatrixMathematics.inverse(matrix);
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				assertTrue(notANumber(inverse.getValueAt(i, j)));
			}
		}
	}
	private boolean notANumber(double value) {
		return Double.isNaN(value) || Double.isInfinite(value);
	}
	
	@Test
	public void testAdd() throws Exception{
		Matrix matrix1 = new Matrix(new double[][]{{1,3},{1,0},{1,2}});
		Matrix matrix2 = new Matrix(new double[][]{{0,0},{7,5},{2,1}});
		Matrix sum = MatrixMathematics.add(matrix1, matrix2);
		assertTrue(Math.abs(1.0-sum.getValueAt(0, 0)) < 1e-5);
		assertTrue(Math.abs(3.0-sum.getValueAt(0, 1)) < 1e-5);
		assertTrue(Math.abs(8.0-sum.getValueAt(1, 0)) < 1e-5);
		assertTrue(Math.abs(5.0-sum.getValueAt(1, 1)) < 1e-5);
		assertTrue(Math.abs(3.0-sum.getValueAt(2, 0)) < 1e-5);
		assertTrue(Math.abs(3.0-sum.getValueAt(2, 1)) < 1e-5);
	}
	@Test
	public void testSubtract() throws Exception{
		Matrix matrix1 = new Matrix(new double[][]{{1,3},{1,0},{1,2}});
		Matrix matrix2 = new Matrix(new double[][]{{0,0},{7,5},{2,1}});
		Matrix sum = MatrixMathematics.subtract(matrix1, matrix2);
		assertTrue(Math.abs(1.0-sum.getValueAt(0, 0)) < 1e-5);
		assertTrue(Math.abs(3.0-sum.getValueAt(0, 1)) < 1e-5);
		assertTrue(Math.abs(-6.0-sum.getValueAt(1, 0)) < 1e-5);
		assertTrue(Math.abs(-5.0-sum.getValueAt(1, 1)) < 1e-5);
		assertTrue(Math.abs(-1.0-sum.getValueAt(2, 0)) < 1e-5);
		assertTrue(Math.abs(1.0-sum.getValueAt(2, 1)) < 1e-5);
	}
	@Test
	public void testmultiply1() throws Exception{
		Matrix matrix1 = new Matrix(new double[][]{{1,0,-2},{0,3,-1}});
		Matrix matrix2 = new Matrix(new double[][]{{0,3},{-2,-1},{0,4}});
		Matrix mult = MatrixMathematics.multiply(matrix1, matrix2);
		assertEquals(2, mult.getNrows());
		assertEquals(2, mult.getNcols());
		assertTrue(Math.abs(0.0-mult.getValueAt(0, 0)) < 1e-5);
		assertTrue(Math.abs(-5.0-mult.getValueAt(0, 1)) < 1e-5);
		assertTrue(Math.abs(-6.0-mult.getValueAt(1, 0)) < 1e-5);
		assertTrue(Math.abs(-7.0-mult.getValueAt(1, 1)) < 1e-5);
	}
	@Test
	public void testmultiply2() throws Exception{
		Matrix matrix1 = new Matrix(new double[][]{{1,2,3},{4,5,6}});
		Matrix matrix2 = new Matrix(new double[][]{{7,8},{9,10},{11,12}});
		Matrix mult = MatrixMathematics.multiply(matrix1, matrix2);
		assertEquals(2, mult.getNrows());
		assertEquals(2, mult.getNcols());
		assertTrue(Math.abs(58.0-mult.getValueAt(0, 0)) < 1e-5);
		assertTrue(Math.abs(64.0-mult.getValueAt(0, 1)) < 1e-5);
		assertTrue(Math.abs(139.0-mult.getValueAt(1, 0)) < 1e-5);
		assertTrue(Math.abs(154.0-mult.getValueAt(1, 1)) < 1e-5);
	}
	@Test
	public void testmultiply3() throws Exception{
		Matrix matrix1 = new Matrix(new double[][]{{3,4,2}});
		Matrix matrix2 = new Matrix(new double[][]{{13,9,7,15},{8,7,4,6},{6,4,0,3}});
		Matrix mult = MatrixMathematics.multiply(matrix1, matrix2);
		assertEquals(1, mult.getNrows());
		assertEquals(4, mult.getNcols());
		assertTrue(Math.abs(83.0-mult.getValueAt(0, 0)) < 1e-5);
		assertTrue(Math.abs(63.0-mult.getValueAt(0, 1)) < 1e-5);
		assertTrue(Math.abs(37.0-mult.getValueAt(0, 2)) < 1e-5);
		assertTrue(Math.abs(75.0-mult.getValueAt(0, 3)) < 1e-5);
	}
}

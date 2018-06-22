/**
 * Test file for Complex class
 */
package test.java;

import org.junit.Assert;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Complex;

/**
 * Junit test case for my immutable complex class.
 * @author arrivault
 *
 */
public class ComplexTest {

	private double rmin;
	private double rmax;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rmin = -1e5;
		rmax = 1e5;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link Complex#Complex(double, double)}.
	 */
	@Test
	public final void testComplex() {
		double r = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Assert.assertTrue(new Complex(r, i) instanceof Complex);
	}

	/**
	 * Test method for {@link Complex#realPart()}.
	 */
	@Test
	public final void testRealPart() {
		double r = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c = new Complex(r, i);
		Assert.assertEquals(Double.compare(r, c.realPart()), 0);
	}

	/**
	 * Test method for {@link Complex#imaginaryPart()}.
	 */
	@Test
	public final void testImaginaryPart() {
		double r = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c = new Complex(r, i);
		Assert.assertEquals(Double.compare(i, c.imaginaryPart()), 0);
	}

	/**
	 * Test method for {@link Complex#add(Complex)}.
	 */
	@Test
	public final void testAdd() {
		double r1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c1 = new Complex(r1, i1);
		double r2 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i2 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c2 = new Complex(r2, i2);

		Complex c = c1.add(c2);
		Assert.assertEquals(Double.compare(c.realPart(), r1+r2), 0);
		Assert.assertEquals(Double.compare(c.imaginaryPart(), i1+i2), 0);
	}

	/**
	 * Test method for {@link Complex#subtract(Complex)}.
	 */
	@Test
	public final void testSubtract() {
		double r1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c1 = new Complex(r1, i1);
		double r2 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i2 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c2 = new Complex(r2, i2);

		Complex c = c1.subtract(c2);
		Assert.assertEquals(Double.compare(c.realPart(), r1-r2), 0);
		Assert.assertEquals(Double.compare(c.imaginaryPart(), i1-i2), 0);
	}

	/**
	 * Test method for {@link Complex#multiply(Complex)}.
	 */
	@Test
	public final void testMulptiply() {
		double r1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c1 = new Complex(r1, i1);
		double r2 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i2 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c2 = new Complex(r2, i2);

		Complex c = c1.multiply(c2);
		Assert.assertEquals(Double.compare(c.realPart(), r1*r2 - i1*i2), 0);
		Assert.assertEquals(Double.compare(c.imaginaryPart(), i1*r2 + i2*r1), 0);
	}

	/**
	 * Test method for {@link Complex#divide(Complex)}.
	 */
	@Test
	public final void testDivide() {
		double r1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c1 = new Complex(r1, i1);
		double r2 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i2 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		if (Double.compare(r2, 0) == 0 && Double.compare(i2, 0) == 0){
			r2 = 1.0;
		}
		Complex c2 = new Complex(r2, i2);

		double den = r2*r2 + i2*i2;
		Complex num = c1.multiply(c2.conj());
		
		Complex c = c1.divide(c2);
		Assert.assertEquals(c.realPart(), num.realPart()/den, 1e-10);
		Assert.assertEquals(c.imaginaryPart(), num.imaginaryPart()/den, 1e-10);
	}

	/**
	 * Test method for {@link Complex#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		double r1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c1 = new Complex(r1, i1);
		Assert.assertTrue(c1.equals(c1));
		Assert.assertFalse(c1.equals(r1));
		Assert.assertTrue(c1.equals(new Complex(r1,i1)));
		Assert.assertFalse(c1.equals(new Complex(r1+1.0,i1+1.0)));
	}

	/**
	 * Test method for {@link Complex#toString()}.
	 */
	@Test
	public final void testToString() {
		double r1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		double i1 = ThreadLocalRandom.current().nextDouble(rmin, rmax);
		Complex c1 = new Complex(r1, i1);
		Assert.assertEquals(c1.toString(),"(" + r1 + " + " + i1 + "i)");
	}

}

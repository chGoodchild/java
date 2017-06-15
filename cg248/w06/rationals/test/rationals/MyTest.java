package rationals;

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by Chandran Goodchild on 6/5/17.
 * Test all the methods that I wrote.
 */
public class MyTest {

    /**
     * Test rational.
     */
    @Test
    public void testRational() {
        Rational r1 = new Rational(10000000000l, 1);
        assertEquals(10000000000l, r1.numerator);
        assertEquals(1, r1.denominator);
    }

    /**
     * Test addition of rationals.
     */
    @Test
    public void testAdd() {
        Rational r1 = new Rational(10000000000l, 1);
        Rational r2 = new Rational(1, 2);
        assertEquals(new Rational(20000000001l, 2), r1.add(r2));
    }

    /**
     * Test the multiplication of rationals.
     */
    @Test
    public void testMultiply() {
        Rational r1 = new Rational(10000000000l, 1);
        Rational r2 = new Rational(1, 2);
        assertEquals(new Rational(5000000000l, 1), r1.multiply(r2));
    }

    /**
     * Test the inversion of rationals.
     */
    @Test
    public void testInvert() {
        Rational r1 = new Rational(10000000000l, 1);
        assertEquals(new Rational(1, 10000000000l), r1.invert(r1));
    }

    /**
     * Test the conversion of rationals into doubles.
     */
    @Test
    public void testToDouble() {
        Rational r2 = new Rational(1, 2);
        assertEquals(0.5, r2.toDouble(), 0.001);
    }

    /**
     * Check if the numerator is returned correctly.
     */
    @Test
    public void testGetNominator() {
        Rational r2 = new Rational(1, 2);
        assertEquals(1, r2.getNominator(), 0.001);
    }

    /**
     * Check if the denominator is returned correctly.
     */
    @Test
    public void testGetDenominator() {
        Rational r2 = new Rational(1, 2);
        assertEquals(2, r2.getDenominator(), 0.001);
    }

    /**
     * Check if the two objects are equal.
     */
    @Test
    public void testEquals() {
        Rational r2 = new Rational(1, 2);
        assertEquals(true, r2.equals(r2));
    }

    /**
     * Test the toString method.
     */
    @Test
    public void testToString() {
        Rational r2 = new Rational(1, 2);
        assertEquals("numerator 1 denominator 2", r2.toString());
    }
}

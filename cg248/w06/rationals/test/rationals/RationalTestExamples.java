package rationals;

import org.junit.Test;

import static org.junit.Assert.*;

public class RationalTestExamples {

    @Test
    public void testAddingPrecicely() {
        Rational r1 = new Rational(10000000000l, 1);
        Rational r2 = new Rational(1, 2);
        assertEquals(new Rational(20000000001l, 2), r1.add(r2));
    }

    @Test
    public void testUniqueNominator() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(2, 4);
        assertEquals(r1.getNominator(), r2.getNominator());
        assertEquals(r1.getDenominator(), r2.getDenominator());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowingWithDenominatorZero() {
        new Rational(1, 0);
    }
}

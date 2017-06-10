package rationals;

import java.util.Arrays;

/**
 * Created by Chandran Goodchild on 6/5/17.
 * Store the numerator and denominator of a rational number in
 * instances of this class and do simple calculations on demand.
 */
public class Rational {
    /**
     * Numerator of the rational number.
     */
    public long numerator;
    /**
     * Denominator of the rational number.
     */
    public long denominator;

    /**
     * Constructor
     * @param nominator The numerator of this rational number.
     * @param denominator The denominator of this rational number.
     */
    public Rational(long nominator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }

        if (denominator < 0) {
            this.numerator = -nominator;
            this.denominator = -denominator;
        } else {
            this.numerator = nominator;
            this.denominator = denominator;
        }

        if (this.numerator % this.denominator == 0) {
            this.numerator = this.numerator / this.denominator;
            this.denominator = 1;
        }

        for (int i = 10; i > 1; i--) {
            if ((this.numerator % i == 0) && (this.denominator % i == 0)) {
                this.numerator = this.numerator / i;
                this.denominator = this.denominator / i;
                i = 10;
            }
        }
    }

    /**
     * Add this rational number with the rational number in the
     * argument of this function.
     * @param r The rational number to be added with this instance.
     * @return Return a rational number which is the sum of the two.
     */
    public Rational add(Rational r) {

        long d, n;

        /**
         * Avoid large numbers whenever possible.
         */
        if (this.denominator % r.denominator == 0) {
            long factor = this.denominator / r.denominator;
            n = Math.addExact(this.numerator, Math.multiplyExact(r.numerator, factor));
            d = this.denominator;
        } else if (r.denominator % this.denominator == 0) {
            long factor = r.denominator / this.denominator;
            n = Math.addExact(Math.multiplyExact(this.numerator, factor), r.numerator);
            d = r.denominator;
        } else {
            n = Math.addExact(Math.multiplyExact(this.numerator, r.denominator), Math.multiplyExact(r.numerator, this.denominator));
            d = Math.multiplyExact(this.denominator, r.denominator);
        }

        if (d == 0) {
            throw new IllegalArgumentException();
        }

        /**
         * This statement is only required in order to satisfy the
         * unit test in Jenkins. Rational(0, 2) should also be a valid
         * return statement...
         */
        if (n == 0) {
            return new Rational(0, 1);
        }

        return new Rational(n, d);
    }

    /**
     * Multiply this rational number with the rational number in the
     * argument of this function.
     * @param r The rational number to be multiplied with this
     * instance.
     * @return Return a rational number which is the product of the
     * two.
     */
    public Rational multiply(Rational r) {

        long n, d;

        /**
         * Simplify the terms wherever possible.
         */
        if (this.numerator % r.denominator == 0) {
            n = Math.multiplyExact(this.numerator / r.denominator, r.numerator);
            d = Math.multiplyExact(this.denominator, 1);
        } else if (r.numerator % this.denominator == 0) {
            n = Math.multiplyExact(this.numerator, r.numerator / this.denominator);
            d = Math.multiplyExact(1, r.denominator);
        } else {
            n = Math.multiplyExact(this.numerator, r.numerator);
            d = Math.multiplyExact(this.denominator, r.denominator);
        }

        /**
         * Further simplification.
         */
        for (int i = 10; i > 1; i--) {
            if ((n % i == 0) && (d % i == 0)) {
                n = n / i;
                d = d / i;
                i = 10;
            }
        }
        return new Rational(n, d);
    }

    /**
     * Invert the rational number from the argument.
     * @param r The rational number to be inverted
     * @return Return a rational number that is the inverse of the
     * given argument.
     */
    public Rational invert(Rational r) {
        long n =  r.denominator;
        long d = r.numerator;
        return new Rational(n, d);
    }

    /**
     * Convert the rational number to a double and return it.
     * @return Return the numerator divided by the denominator as a
     * double.
     */
    public double toDouble() {
        return ((double) this.numerator / (double) this.denominator);
    }

    /**
     * @return Return the numerator as a long.
     */
    public long getNominator() {
        return this.numerator;
    }

    /**
     * @return Return the denominator of this rational number as a
     * long.
     */
    public long getDenominator() {
        return this.denominator;
    }

//    /**
//     * Generate a unique hash code for different instances of this class.
//     *
//     * @return Return a unique hash code for this instance.
//     */
//    @Override
//    public int hashCode() {
//       return Arrays.hashCode(new Object[]{this.numerator, this.denominator});
//    }

    /**
     * @param r The argument to be compared with this instance.
     * @return Boolean : Return true if this instance equals the given
     * argument.
     */
    @Override public boolean equals(Object r) {
        Rational rat  = (Rational) r;
        return (this.numerator == rat.numerator && this.denominator == rat.denominator);
    }
}

/**
 * @file   GeometryTest.java
 * @date   Sun May 28 22:24:39 2017
 * 
 * @brief  Test with an Oracle.
 * 
 * 
 */

package lineintersection;

import org.junit.Test;

import static org.junit.Assert.*;

/** 
 * Test the class Geometry.
 * 
 * @param a1 
 * @param b1 
 * @param a2 
 * @param b2 
 * 
 * @return 
 */
public class GeometryTest {

    /** 
     * Test the input from Geometry.lineIntersection. If the two lines
     * y = a1 * x + b1 and y = a2 * x + b2 intersect it should return
     * null (thus the value of "geo" should be null. Else if a1 == a2,
     * they are parallel and they don't intersect in a single
     * point. Thus the value of geo shoud not be equal to null.
     * 
     * @param a1 
     * @param b1 
     * @param a2 
     * @param b2 
     * 
     * @return 
     */
    public boolean checkIntersection(double[] geo, double a1, double b1, double a2, double b2) {
	if (a1 == a2) {
	    // boolean intersect = false;
	    if (geo == null) {
		return true;
	    } else {
		return false;
	    }
	} else {
	    // boolean intersect = true;
	    if (geo != null) {
		return true;
	    } else {
		return false;
	    }
	}
    }

    @Test
    public void lineIntersection() throws Exception {

	double a1 = 0;
	double b1 = 0;
	double a2 = 1;
	double b2 = 1;

	assertTrue(checkIntersection(Geometry.lineIntersection(a1, b1, a2, b2), a1, b1, a2, b2));
	a1 = a2 = b2 = 1;
	assertTrue(checkIntersection(Geometry.lineIntersection(a1, b1, a2, b2), a1, b1, a2, b2));
    }
}

package unittests;

import org.junit.Test;

import static org.junit.Assert.*;

/** 
 * Test the functionality of turbine.turbine control. All possible
 * scenarios are covered by the test...
 * 
 */
public class FunctionsTest {
    @Test
    public void turbineControl() throws Exception {
	Functions turbine = new Functions();

	assertEquals("DISCONNECT", turbine.turbineControl(52));
	assertEquals("DISCONNECT", turbine.turbineControl(10));
	assertEquals("LESS_WATER", turbine.turbineControl(50.01));
	assertEquals("MORE_WATER", turbine.turbineControl(49.99));
	assertEquals("STEADY", turbine.turbineControl(50.0005));
    }
}

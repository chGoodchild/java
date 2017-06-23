package subsequence;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Thiemann on 21.05.17.
 * Edited by Chandran on 2.06.17.
 * Test the functionality of subsequenceCompare.
 */
public class MainTest {
    @Test
    public void subsequenceCompare() {
	Main compare = new Main();
	assertEquals("GREATER", compare.subsequenceCompare("Hello World", "eloWrld"));
	assertEquals("LESS", compare.subsequenceCompare("eloWrld", "Hello World"));
	assertEquals("INCOMPARABLE", compare.subsequenceCompare("Hello World", "World Hello"));
	assertEquals("EQUAL", compare.subsequenceCompare("Hello", "Hello"));
    }
}

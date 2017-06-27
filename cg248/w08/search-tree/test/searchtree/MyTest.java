package searchtree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Chandran Goodchild on 27.06.17.
 *
 * Test cases for the classes Tree and Node.
 *
 */
public class MyTest {

    @Test
    public void exampleTests() {
        // Test the constructor.
        Tree t = Trees.makeTree(new int[]{3, 3, 3, 3, 3, 3, 4, 4, 1, 1, 1, 1, 1});

        // Test Node.add(), which was used by the constructor.
        assertTrue(t.contains(3));

        // Test Tree.contains() and Node.contains().
        assertFalse(t.contains(6));

        // Test Tree.size() and Node.size().
        assertEquals(3, t.size());

        // Test Tree.listTree(), Tree.add() and Node.add().
        Tree t2 = t.add(6).add(7).add(6);

        // --------------------------------------------------
        // Confirm that Tree.add() functioned correctly
        // --------------------------------------------------
        // Make sure that Tree.add() created a NEW object and it didn't just
        // add a new Node to the object that "Node t" points to.
        assertFalse(t.contains(6));

        // Confirm that "t2" now points to the modified node even though "t" doesn't.
        assertTrue(t2.contains(6));

        assertEquals(5, t2.size());
        assertEquals(3, t.size());

        // Test Node.elementsAsString() and Tree.elementsAsString().
        assertEquals("1, 3, 4, 6, 7", t2.elementsAsString());
        // --------------------------------------------------


        // Make sure it functions correctly with an empty input:
        Tree empty = Trees.makeTree(new int[]{});
        assertEquals(0, empty.size());
        assertEquals("", empty.elementsAsString());
        assertFalse(empty.contains(0));
    }

}

package searchtree;

import org.junit.Test;


import static org.junit.Assert.*;

public class TestExamples {

    @Test
    public void exampleTests() {
        Tree t = Trees.makeTree(new int[]{2, 3, 4, 4, 1});
        assertTrue(t.contains(4));
        assertFalse(t.contains(6));
        assertEquals(4, t.size());

        Tree t2 = t.add(6).add(7).add(6);
        assertFalse(t.contains(6));
        assertTrue(t2.contains(6));
        assertEquals(6, t2.size());
        assertEquals(4, t.size());

        assertEquals("1, 2, 3, 4, 6, 7", t2.elementsAsString());

        Tree empty = Trees.makeTree(new int[]{});
        assertEquals(0, empty.size());
        assertEquals("", empty.elementsAsString());
        assertFalse(empty.contains(0));
    }
}
package blockworld;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Chandran Goodchild on 6/9/17.
 */
public class MyTestCases {
    @Test
    public void testMinimalWorld() {
        List<Block> bs = Collections.singletonList(new Block (0, 0, 1, 'x'));
        BlockWorld w = new BlockWorld(1, 3, bs, '.');
        assertFalse(w.isDead());
        assertArrayEquals(new char[][]{ new char[]{ 'x', '.', '.'}}, w.observe());

        // Test step
        w.step();

        // Test isDead
        assertFalse(w.isDead());

        // Test observe
        assertArrayEquals(new char[][]{ new char[]{ '.', 'x', '.'}}, w.observe());

        // Test sort
        bs.get(0).y = 0;
        assertArrayEquals(new char[][]{ new char[]{ '.', 'x', '.'}}, w.observe());
        w.sort();
        assertArrayEquals(new char[][]{ new char[]{ 'x', '.', '.'}}, w.observe());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingBlockConstruction() {
        new Block(-1, 0, 1, 'x');
    }

    @Test
    public void testPassingBlockConstruction() {
        Block b = new Block(1, 0, 1, 'L');
        assertEquals('L', b.shape);
    }

    @Test
    public void testPassingWorldConstruction() {
        List<Block> bs = Collections.singletonList(new Block (0, 0, 1, 'x'));
        BlockWorld w = new BlockWorld(1, 3, bs, '.');
        assertEquals(1, w.width);
        assertEquals(3, w.height);
        assertEquals(bs, w.blocks);
        assertEquals('.', w.empty);

        // Test getWidth:
        assertEquals(1, w.getWidth());

        // Test getHeight:
        assertEquals(3, w.getHeight());

        // Test getWidth:
        assertEquals(1, w.width);
    }
}

package blockworld;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

        assertThat(bs, IsNot.not(IsEqual.equalTo(w.blocks)));

        // Test "new object"
        bs.get(0).y = 0;
        assertArrayEquals(new char[][]{ new char[]{ '.', 'x', '.'}}, w.observe());
        w.sort();

        assertThat(new char[][]{ new char[]{ 'x', '.', '.'}}, IsNot.not(IsEqual.equalTo((w.observe()))));

        // Test sort
        w.world.get(0).get(1).get(0).y = 0;
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
    public void jenkinsTest() {
        ArrayList<Block> block = new ArrayList<>();
        block.add(new Block(0, 0, 2, 'x'));
        block.add(new Block(1, 0, 1, 'o'));
        BlockWorld w2 = new BlockWorld(2, 3, block, '.');
        assertArrayEquals(new char[][]{ new char[]{ 'x', '.', '.'}, new char[]{'o', '.', '.'}}, w2.observe());
    }

    @Test
    public void jenkinsTestTwo() {
        ArrayList<Block> block = new ArrayList<>();
        block.add(new Block(0, 0, 2, 'x'));
        block.add(new Block(0, 0, 1, 'o'));
        BlockWorld w3 = new BlockWorld(2, 3, block, '.');
        w3.step();
        w3.step();
        w3.step();
        w3.step();
        w3.step();
        assertArrayEquals(new char[][]{ new char[]{ '.', '.', 'x'}, new char[]{'.', '.', '.'}}, w3.observe());
    }

    @Test
    public void jenkinsTestThree() {
        ArrayList<Block> block = new ArrayList<>();
        block.add(new Block(0, 0, 2, 'x'));
        block.add(new Block(0, 0, 0, 'o'));
        BlockWorld wLong = new BlockWorld(2, 6, block, '.');
        wLong.step();
        wLong.step();
        wLong.step();

        wLong.step();
        wLong.step();
        wLong.step();
        assertEquals(true, wLong.isDead());
    }

    @Test
    public void jenkinsTestFour() {
        ArrayList<Block> block = new ArrayList<>();
        block.add(new Block(0, 0, 2, 'x'));
        block.add(new Block(0, 0, 1, 'o'));
        BlockWorld w3 = new BlockWorld(2, 3, block, '.');
        w3.step();
        assertArrayEquals(new char[][]{ new char[]{ '.', 'o', 'x'}, new char[]{'.', '.', '.'}}, w3.observe());
    }


    @Test
    public void jenkinsTestFive() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(new Block(0, 0, 2, 'x'));
        blocks.add(new Block(1, 0, 1, 'o'));

        BlockWorld w1 = new BlockWorld(2, 3, blocks, '.');
        w1.step();
        assertArrayEquals(new char[][]{ new char[]{ '.', '.', 'x'}, new char[]{'.', 'o', '.'}}, w1.observe());

        BlockWorld w2 = new BlockWorld(2, 3, blocks, '.');
        assertArrayEquals(new char[][]{ new char[]{ 'x', '.', '.'}, new char[]{'o', '.', '.'}}, w2.observe());

        BlockWorld w3 = new BlockWorld(2, 3, blocks, '.');
        w3.step();

        assertEquals(false, w3.isDead());
    }

    @Test
    public void testPassingWorldConstruction() {
        List<Block> bs = Collections.singletonList(new Block (0, 0, 1, 'x'));
        BlockWorld w = new BlockWorld(1, 3, bs, '.');
        assertEquals(1, w.width);
        assertEquals(3, w.height);
        assertThat(bs, IsNot.not(IsEqual.equalTo(w.blocks)));
        assertEquals('.', w.empty);

        // Test getWidth:
        assertEquals(1, w.getWidth());

        // Test getHeight:
        assertEquals(3, w.getHeight());

        // Test getWidth:
        assertEquals(1, w.width);
    }
}

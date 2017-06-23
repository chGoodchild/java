package onedgame;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Chandran Goodchild on 22.06.17.
 */
public class MainTest {
    /**
     * Return true since the game is winnable.
     */
    @Test
    public void testCrawl() {
        assertTrue(Main.crawl(0, 2, new boolean[]{false, true, false, false, true, true}, new ArrayList<>()));
    }

    /**
     * Return true since the game is winnable.
     */
    @Test
    public void testIsWinnable() {
        assertTrue(Main.isWinnable(2, new boolean[]{false, true, false, true, false, true, false, true, false,
                true, false, true, false, true, false, true, false, true, false, true, false, true, false, true,
                false, true, false, true, false, true, true}));
    }

    /**
     * Return false since the game is not winnable.
     */
    @Test
    public void testIsWinnableFalse() {
        assertFalse(Main.isWinnable(2, new boolean[]{false, true, false, true, true, false, false, true, false,
                true, false, true, false, true, false, true, false, true, false, true, false, true, false, true,
                false, true, false, true, false, true, true}));
    }
}
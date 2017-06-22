package onedgame;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestExamples {

    @Test
    public void testWinning1() {
        assertTrue(Main.isWinnable(3, new boolean[]{false,
                                                    false,
                                                    false,
                                                    true,
                                                    true ,
                                                    true}));
    }

    @Test
    public void testLoosing1() {
        assertFalse(Main.isWinnable(3, new boolean[]{false,
                                                     false,
                                                     true,
                                                     true ,
                                                     true,
                                                     false}));

    }

}
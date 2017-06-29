package blockworld;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Chandran Goodchild on 6/6/17.
 */
public class Block {
    int x, y, velocity;
    char shape;

    /**
     * Constructor of the block - Initialize the values.
     * @param x X position.
     * @param y Y position.
     * @param velocity The velocity of the block.
     * @param shape The shape of the block.
     */
    public Block(int x, int y, int velocity, char shape) throws IllegalArgumentException{

        if (x < 0 || y < 0 || velocity < 0) {
            throw new IllegalArgumentException();
        }

        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.shape = shape;
    }
}
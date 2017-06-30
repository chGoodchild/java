package blockworld;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chandran Goodchild on 6/6/17.
 * This class stores the state of a three dimensional world of blocks using ArrayLists.
 * The first two dimensions are considered as physical locations on the X, Y plane and the third dimension represents
 * the number of items in that location. The blocks move downwards every time the function step is called. The block
 * world is considered "dead" when all the blocks have reached the bottom of the block world.
 */
public class BlockWorld {

    int width, height;
    List<Block> blocks;
    char empty;
    ArrayList<ArrayList<ArrayList<Block>>> world = new ArrayList<>();

    /**
     * Constructor
     * @param width The width of the world (X axis)
     * @param height The height of the world (Y axis)
     * @param blocks The blocks in the world (3rd dimension)
     * @param empty The character that symbolizes an empty space in the world
     */
    public BlockWorld(int width, int height, List<Block> blocks, char empty) {
        this.width = width;
        this.height = height;
        this.empty = empty;

        this.blocks = new ArrayList<Block>();

        // Make sure that this List<Block> contains NEW blocks!
        for (int i = 0; i < blocks.size(); i++) {
            this.blocks.add(new Block(blocks.get(i).x, blocks.get(i).y, blocks.get(i).velocity, blocks.get(i).shape));

            if (blocks.get(i).x >= this.width) {
                throw new IllegalArgumentException();
            }

            if (blocks.get(i).y >= this.height) {
                throw new IllegalArgumentException();
            }
        }

            for (int m = 0; m < this.width; m++) {
                // Add a new ArrayList for each line.
                world.add(new ArrayList<>());
                for (int n = 0; n < this.height; n++) {
                    // Add a new ArrayList for each column.
                    world.get(m).add(new ArrayList<>());

                    // No need to sort after this:
                    for (int i = 0; i < this.blocks.size(); i++) {

                    if (this.blocks.get(i).x == m && this.blocks.get(i).y == n) {
                        this.world.get(m).get(n).add(this.blocks.get(i));
                    }
                }
            }
        }
    }

    /**
     * @return Return the width of the world
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * @return Return the height of the world.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * @return Return the current state of the world as a two dimensional array, where
     * the block with the largest ascii value is returned if there are multiple blocks
     * in one location.
     */
    public char[][] observe() {

        char[][] out = new char[this.width][this.height];

        for (int m = 0; m < this.width; m++) {
            for (int n = 0; n < this.height; n++) {
                if (this.world.get(m).get(n).size() == 0) {
                    out[m][n] = empty;
                } else {
                    out[m][n] = 0;
                    for (int o = 0; o < this.world.get(m).get(n).size(); o++) {
                        if (out[m][n] < (int) this.world.get(m).get(n).get(o).shape) {
                            out[m][n] = this.world.get(m).get(n).get(o).shape;
                        }
                    }
                }
            }
        }

        return out;
    }

    /**
     * Change the blocks location according to it's velocity.
     */
    public void step() {

        int counter = 0;

        for (int m = 0; m < this.width; m++) {
            for (int n = 0; n < this.height; n++) {
                for (int o = 0; o < this.world.get(m).get(n).size(); o++) {

                    this.world.get(m).get(n).get(o).y = this.world.get(m).get(n).get(o).y + this.world.get(m).get(n).get(o).velocity;

                    if (this.world.get(m).get(n).get(o).y  < 0) {
                        this.world.get(m).get(n).get(o).y = 0;
                    }

                    if (this.world.get(m).get(n).get(o).y  >= this.height) {
                        this.world.get(m).get(n).get(o).y = this.height - 1;
                    }

                    if (this.world.get(m).get(n).get(o).x  < 0) {
                        this.world.get(m).get(n).get(o).x = 0;
                    }

                    if (this.world.get(m).get(n).get(o).x  >= this.width) {
                        this.world.get(m).get(n).get(o).x = this.width - 1;
                    }

                    counter++;
                }
            }
        }

        // Sort once per object.
        for (int i = 0; i < counter; i++) {
            sort();
        }
    }

    /**
     * Make sure that the blocks location is also updated in the ArrayLists.
     */
    public void sort() {

        int newX, newY, size;
        Block tmp;

        for (int m = 0; m < this.width; m++) {
            for (int n = 0; n < this.height; n++) {
                for (int o = 0; o < this.world.get(m).get(n).size(); o++) {
                    tmp = this.world.get(m).get(n).get(o);

                    if (tmp.x < 0) {
                        tmp.x = this.world.get(m).get(n).get(o).x = 0;
                    }

                    if (tmp.x >= this.width) {
                        tmp.x = this.world.get(m).get(n).get(o).x = this.width - 1;
                    }

                    if (tmp.y < 0) {
                        tmp.y = this.world.get(m).get(n).get(o).y = 0;
                    }

                    if (tmp.y >= this.height) {
                        tmp.y = this.world.get(m).get(n).get(o).y = this.height - 1;
                    }

                    newX = tmp.x;
                    newY = tmp.y;

                    if (newX != m || newY != n) {
                        if (newX <= this.width - 1 && newY <= this.height - 1) {
                            this.world.get(m).get(n).remove(o);
                            this.world.get(newX).get(newY).add(tmp);
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @return Return true if all the blocks have reached the bottom
     * of the block world. Else return false.
     */
    public boolean isDead() {
        boolean is_dead = true;
        for (int m = 0; m < this.width; m++) {
            for (int n = 0; n < this.height - 1; n++) {
                for (int i = 0; i < this.world.get(m).get(n).size(); i++) {
                    if (this.world.get(m).get(n).get(i).velocity > 0){
                        is_dead = false;
                    }
                }
            }
        }
        return is_dead;
    }
}
